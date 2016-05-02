package com.mycompany.a2;

abstract class Catchers extends GameObject implements IGuided{
	public Catchers(GameWorld gw){
		super(gw);
	}
	public Catchers(){}
    public void jumpToCat(Cat cat) {
        setLocation(cat.getXLocation(),cat.getYLocation());
    }

    public void jumpToDog(Dog dog) {
        setLocation(dog.getXLocation(),dog.getYLocation());
    }

    public void moveUp(){
        float localX = getXLocation();
        float localY = getYLocation();
        if(localY <super.getHeightBound() - (getSize()/2)){
            setLocation(localX,localY+1);
        }
    }//end moveUp()

    public void moveDown(){
        float localX = getXLocation();
        float localY = getYLocation();
        if(localY > (getSize()/2)){
            setLocation(localX,localY-1);
        }
    }

    public void moveRight(){
        float localX = getXLocation();
        float localY = getYLocation();
        if(localX < super.getWidthBound() - (getSize()/2)){
            setLocation(localX + 1,localY);
        }
    }

    public void moveLeft(){
        float localX = getXLocation();
        float localY = getYLocation();
        if(localX > (getSize()/2)){
            setLocation(localX-1,localY);
        }
    }

}//END CATCHERS