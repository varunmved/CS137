package com.mycompany.a2;
import java.util.Random;

/*
 *Bryce Hairabedian
 * CSC 133 Sec 1
 * Assignment 1
 */
import com.codename1.charts.util.ColorUtil;

public class Dog extends Animals{
    //*********Attributes
    private int scratches;
    private Random random = new Random();
    //***Constructors
    public Dog(GameWorld gw){
    	super(gw);
    	super.setSpeed(5);
    	this.setSize(getRandIntBetween(20,50));
    	setColor(ColorHelper.getRed(1));
    	scratches=0;
    }
    public Dog(){
    	super();
    	this.setSize(getRandIntBetween(20,50));
        setColor(ColorHelper.getRed(1));//start the dog off with lightest shade of red
        scratches=0;
        setSpeed(5);
        
    }

    //****Methods
    public int getRandIntBetween(int min, int max){
        int r = random.nextInt(max - min) + min;
        return r;
    }
    public int getScratches(){return this.scratches;}
    public void setScratches(int scratch){this.scratches = scratch;}
    public void scratchThisDog(){
        if(scratches<5){
            this.scratches++;
        }
        else{
            scratches=5;
        }
        decreaseDogSpeed();
        switch(scratches){ //make the dog more and more red with each scratch
            case 1: //Light red
                setColor(ColorHelper.getRed(1));
                break;
            case 2:
                setColor(ColorHelper.getRed(2));//darker shade of red
                break;
            case 3:
                setColor(ColorHelper.getRed(3));//darker shade of red
                break;
            case 4:
                setColor(ColorHelper.getRed(4));//even darker shade of red
                break;
            case 5://Most Red
                setColor(ColorHelper.getRed(5));
                break;
            default:
                setColor(ColorHelper.getRed(5));
                break;
        }
    }
    @Override
    public String toString(){
         String locationString = Math.round(getXLocation()*100.0)/100.0 +", "
                    +Math.round(getYLocation()*100.0)/100.0;

        String colorString = "[" + ColorUtil.red(getColor()) + ","
                    + ColorUtil.green(getColor()) + ","
                    + ColorUtil.blue(getColor()) + "]";

        return ("DOG; Location: " + locationString
                    + " Color: " + colorString
                    + " Size: "+ getSize()
                    + " Speed: " + getSpeed()
                    + " Direction: " + getDirection()
                    + " Scratches: " + getScratches()
            );
    }

    /*decreaseDogSpeed: decreases this dogs speed by one*/
    private void decreaseDogSpeed(){
        int locSpeed =getSpeed();
        if(locSpeed>0){ //if the dogs speed is in range subtract one
            locSpeed--;
            setSpeed(locSpeed);
        }
        else if(locSpeed<=0){
            setSpeed(0);
        }
    }
}//END DOG************************
