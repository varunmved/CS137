package com.mycompany.a2;
import java.util.Random;

/*
 *Bryce Hairabedian
 * CSC 133 Sec 1
 * Assignment 1
 */
import com.codename1.charts.util.ColorUtil;

public class Cat extends Animals{
	Random random = new Random();
    //***Constructors
    public Cat(GameWorld gw){
    	super(gw);
    	super.setSpeed(5);
    	this.setSize(getRandIntBetween(20,50));
    	setColor(ColorUtil.YELLOW);
    }
	public Cat(){
    	setSpeed(5);
    	setColor(ColorUtil.YELLOW);
    	this.setSize(getRandIntBetween(20,50));
    }
	public Cat(Cat inCat, GameWorld gw){
		super(gw);
		super.setSpeed(5);
		this.setSize(getRandIntBetween(20,50));
		setColor(ColorUtil.YELLOW);
		
		float catX = inCat.getXLocation() + getRandIntBetween(1, 10);
		float catY = inCat.getYLocation() + getRandIntBetween(1, 10);
		
		super.setLocation(catX, catY);
	}
    public Cat(Cat inCat){//new kitten
    	super.setSpeed(5);
    	setSize(getRandIntBetween(20,50));
    	setColor(ColorUtil.YELLOW);
    	
    	float catX = inCat.getXLocation() + getRandIntBetween(1, 10);
        float catY = inCat.getYLocation();

        catY += getRandIntBetween(1,10);//more randomness of kitten spawned location
        catX += getRandIntBetween(1,10);
    	this.setXLocation(catX);
    	this.setYLocation(catY);
    }
    //****Methods
    public int getRandIntBetween(int min, int max){
        int r = random.nextInt(max - min) + min;
        return r;
    }
    @Override
    public String toString(){
        String locationString = Math.round(getXLocation()*100.0)/100.0 +", "
                +Math.round(getYLocation()*100.0)/100.0;
        String colorString = "[" + ColorUtil.red(getColor()) + ","
                                        + ColorUtil.green(getColor()) + ","
                                        + ColorUtil.blue(getColor()) + "]";
        return ("CAT; Location: " + locationString
                        + " Color: " + colorString
                        + " Size: "+ getSize()
                        + " Speed: " + getSpeed()
                        + " Direction: " + getDirection());
    }

}//END CAT