package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class MoveUpCommand extends Command implements ActionListener, ICommand{
	private GameWorld target;
	private static MoveUpCommand locInstance;
	
	private MoveUpCommand(){
		super("Move Up");
	}

	
	public void actionPerformed(ActionEvent evt) {
		target.moveUp();	
	}
	
	public void setTarget(GameWorld gw){
		target = gw;
	}
	public static MoveUpCommand getInstance(){
		if(locInstance == null){
			locInstance = new MoveUpCommand();
		}
		return (MoveUpCommand)locInstance;
	}

}
