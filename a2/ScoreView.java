package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
//extends Form
public class ScoreView extends Container implements Observer{
    private Label tsL, dcL, ccL, drL, crL, soundL;
    private String soundString;
    private GameWorld targetWorld;
	public void update(Observable observable, Object data) {
		tsL.setText("Total Score: " + targetWorld.getCurrentScore());
		dcL.setText("Dogs Captured: " + targetWorld.getDogsCaptured());
	    ccL.setText("Cats Captured: " + targetWorld.getCatsCaptured());
	    drL.setText("Dogs Remaining: " + targetWorld.getDogPopulation());
	    crL.setText("Cats Remaining: " + targetWorld.getCatPopulation());
	    if(targetWorld.getSound()){
	    	soundString = "ON";
	    }else{
	    	soundString = "OFF";
	    }
	    
	    soundL.setText("Sound: " + soundString);
	}
	ScoreView(){
	    setLayout(new GridLayout(1, 1));
	    tsL = new Label("Total Score: " + 0);
	    dcL = new Label("Dogs Captured: " + 0);
	    ccL = new Label("Cats Captured: " + 0);
	    drL = new Label("Dogs Remaining: " + 0);
	    crL = new Label("Cats Remaining: " + 0);
	    soundL = new Label("Sound: " + "OFF");
	    
	    Container scoreContainer = new Container(new GridLayout(1,6));
	    scoreContainer.add(tsL).add(dcL).add(ccL).add(drL).add(crL).add(soundL);
	    scoreContainer.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.MAGENTA));
	    scoreContainer.getAllStyles().setPadding(Component.LEFT, 70);
	    this.add(scoreContainer);
	}
	public void setTargetWorld(GameWorld gw){
		if(gw != null){targetWorld = gw;}
		else{System.out.println("Given target world is null");}
	}
	

}
