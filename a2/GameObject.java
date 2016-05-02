package com.mycompany.a2;

import java.util.Random;

//*************************************GAME OBJECT */
public abstract class GameObject{
//*********************Attributes
    private int color;
    private int size, heightBound, widthBound;
    private float xLocation;
    private float yLocation;
    private GameWorld targetWorld;
    private Random random;
//*********************Constructors
    public GameObject(GameWorld gw){
    	heightBound = gw.getMapHeight();
    	widthBound = gw.getMapWidth();
    	xLocation = getRandomXLocation();
    	yLocation = getRandomYLocation();
    }
	
	public GameObject(){ }
//*********************Methods
	
	private float getRandomXLocation(){//TODO truncate the extras 1000.0X
        random = new Random();
		return random.nextFloat()*heightBound;
    }
	private float getRandomYLocation(){//TODO truncate the extras 1000.0X
        random = new Random();
		return random.nextFloat()*widthBound;
    }
    public int getSize(){return size;}
    public void setTargetWorld(GameWorld gw){
		if(gw != null){
			targetWorld=gw;
			heightBound = gw.getMapHeight();
	    	widthBound = gw.getMapWidth();
	    	xLocation = getRandomXLocation();
	    	yLocation = getRandomYLocation();
		}
		else{
				System.out.println("Given null gw");
		}
	}
    
    //Sets the size but checks the objects range 
    public void setSize(int inSize){
        if(this instanceof Net){
            if(inSize>0 && inSize<=100){
                this.size =inSize;
            }else{System.out.println("Wrong Size");}
        }
        else if(this instanceof Animals){
            if(inSize>=20 && inSize<=50){
                this.size =inSize;
            }else{System.out.println("Wrong Size");}
        }
    }//setSize()
    public int getHeightBound() {
		return heightBound;
	}
	public int getWidthBound() {
		return widthBound;
	}

    public int getColor(){return this.color;}
    public void setColor(int setColor){this.color = setColor;}

    public float getXLocation(){
        return this.xLocation;
    }
    public float getYLocation(){
        return this.yLocation;
    }

    public void setXLocation(float x){
        if(x < widthBound && x > 0){
            this.xLocation=x;
        }
    }
    public void setYLocation(float y){
        if(y < heightBound && y > 0){
            this.yLocation = y;
        }
    }
    public void setLocation(float x, float y){
    	this.xLocation =x; this.yLocation=y;
    }
} //**********END GAME OBJECT