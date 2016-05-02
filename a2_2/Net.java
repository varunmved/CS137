package com.mycompany.a2;
/*
 *Bryce Hairabedian
 * CSC 133 Sec 1
 * Assignment 1
 */
import com.codename1.charts.util.ColorUtil;

public class Net extends Catchers{
    public Net(){
        setColor(ColorUtil.BLUE);
    }
    public Net(GameWorld gw){
    	super(gw);
    	setColor(ColorUtil.BLUE);
    	this.setSize(100);//initial net size
    }
    @Override
    public String toString(){
        String locationString = Math.round(getXLocation()*100.0)/100.0 +", "
                +Math.round(getYLocation()*100.0)/100.0;
        String colorString = "[" + ColorUtil.red(getColor()) + ","
                + ColorUtil.green(getColor()) + ","
                + ColorUtil.blue(getColor()) + "]";

        return ("NET; Location: " +locationString
                + " Color: " + colorString
                + " Size: "+ getSize());
    }
}
