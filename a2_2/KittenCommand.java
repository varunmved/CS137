package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class KittenCommand extends Command implements ActionListener, ICommand{
	private GameWorld target;
	private static KittenCommand locInstance;
	
	private KittenCommand(){
		super("Kitten");
	}

	
	public void actionPerformed(ActionEvent evt) {
		target.catFight();	
	}
	
	public void setTarget(GameWorld gw){
		target = gw;
	}
	public static KittenCommand getInstance(){
		if(locInstance == null){
			locInstance = new KittenCommand();
		}
		return (KittenCommand)locInstance;
	}
	
}
