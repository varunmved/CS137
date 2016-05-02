package com.mycompany.a2;


import java.util.Random;

/*
 *Bryce Hairabedian
 * CSC 133 Sec 1
 * Assignment 2
 */
abstract class Animals extends GameObject implements IMoving{

    private int speed;
    private int direction;
    private Random random;
    //***********Constructors
    public Animals(GameWorld gw){
    	super(gw);
    	//setSpeed taken care of in CAT or DOG objects
    	this.direction = getRandomDirection();
    }
    public Animals(){
    	super();
    }
    		
    @Override
    public void setSize(int s){
    	if(s >= 20 || s<=50)
    		super.setSize(s);
    }
    

    //*********Methods
    private int getRandomDirection(){
    	random = new Random();
    	return random.nextInt(360);
    }
    public int getSpeed(){return this.speed;}
    public void setSpeed(int inSpeed){this.speed = inSpeed;}
    
    public int getDirection(){return this.direction;}
    public void setDirection(int inDirection){this.direction = inDirection;}

    //******All Animals move the same way
    public void move(){
    	

    	float delta_X = (float)Math.cos(90-getDirection())*getSpeed();//calculate the
        float delta_Y = (float)Math.sin(90-getDirection())*getSpeed();
        float X_newLocation = (getXLocation()+delta_X);//get new xLocation by adding the change to the direction
        float Y_newLocation = (getYLocation()+delta_Y);
        
       // int xHeight = getMapView_X();
        if((X_newLocation<super.getHeightBound() - getSize()/2) &&(X_newLocation> getSize()/2)){
            if((Y_newLocation<super.getWidthBound()- getSize()/2) &&(Y_newLocation> getSize()/2)){
                setLocation(X_newLocation,Y_newLocation);
            }
        }
    }
    
}//END ANIMAL***********************