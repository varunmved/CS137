package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private GameWorld targetWorld;
	public MapView(){
		setLayout(new GridLayout(1, 1));
		this.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
	}
	public void update(Observable o, Object arg){
		//code here to call the method in GameWorld (Observable)
		//that outputs the game object information to the console
		targetWorld.printMap();
	}
	public void setTargetWorld(GameWorld gw){
		if(gw != null){
			targetWorld=gw;
		}
		else{
				System.out.println("Given null gw");
		}
	}
}
