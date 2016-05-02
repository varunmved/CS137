package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class MoveRightCommand extends Command implements ActionListener, ICommand{
	private GameWorld target;
	private static MoveRightCommand locInstance;
	
	private MoveRightCommand(){super("Move Net Right");}

	
	public void actionPerformed(ActionEvent evt) {
		target.moveRight();	
	}
	
	public void setTarget(GameWorld gw){
		target = gw;
	}
	public static MoveRightCommand getInstance(){
		if(locInstance == null){
			locInstance = new MoveRightCommand();
		}
		return (MoveRightCommand)locInstance;
	}

}
