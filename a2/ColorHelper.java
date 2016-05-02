package com.mycompany.a2;
/*
 *Bryce Hairabedian
 * CSC 133 Sec 1
 * Assignment 1
 */
import com.codename1.charts.util.ColorUtil;
//This class helps me call for certain shades of red easily
public class ColorHelper {
    public ColorHelper(){}
    public static int getRed(int shade){//the higher the color the darker the red
        int setColor;
        switch (shade){
            case 1: //Light red
                setColor = ColorUtil.rgb(255,165,165);
                break;
            case 2:
                setColor = (ColorUtil.rgb(255,150,150));
                break;
            case 3:
                setColor = (ColorUtil.rgb(255,100,100));
                break;
            case 4:
                setColor = (ColorUtil.rgb(255,50,50));
                break;
            case 5://Most Red
                setColor = (ColorUtil.rgb(255,0,0));
                break;
            default:
                setColor = getRed(1);
                break;
        }
        return setColor;
    }
    public int getYellow(){
        return ColorUtil.rgb(255,247,0);
    }
    public int getBlack(){
        return ColorUtil.rgb(0,0,0);
    }
}
