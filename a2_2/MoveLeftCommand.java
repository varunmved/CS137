package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class MoveLeftCommand extends Command implements ActionListener, ICommand{
	private GameWorld target;
	private static MoveLeftCommand locInstance;
	
	private MoveLeftCommand(){super("Move net Left");}

	
	public void actionPerformed(ActionEvent evt) {
		target.moveLeft();	
	}
	
	public void setTarget(GameWorld gw){
		target = gw;
	}
	public static MoveLeftCommand getInstance(){
		if(locInstance == null){
			locInstance = new MoveLeftCommand();
		}
		return (MoveLeftCommand)locInstance;
	}

}
