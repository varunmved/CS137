package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class MoveDownCommand extends Command implements ActionListener, ICommand{
	private GameWorld target;
	private static MoveDownCommand locInstance;
	
	private MoveDownCommand(){super("Net Move Down");}

	
	public void actionPerformed(ActionEvent evt) {
		target.moveDown();	
	}
	
	public void setTarget(GameWorld gw){
		target = gw;
	}
	public static MoveDownCommand getInstance(){
		if(locInstance == null){
			locInstance = new MoveDownCommand();
		}
		return (MoveDownCommand)locInstance;
	}

}
