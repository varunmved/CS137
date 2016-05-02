package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class JumpToDogCommand extends Command implements ActionListener, ICommand{
	private GameWorld target;
	private static JumpToDogCommand locInstance;
	
	private JumpToDogCommand(){
		super("Jump-to-Dog");
	}

	
	public void actionPerformed(ActionEvent evt) {
		target.netToRandomDog();	
	}
	
	public void setTarget(GameWorld gw){
		target = gw;
	}
	public static JumpToDogCommand getInstance(){
		if(locInstance == null){
			locInstance = new JumpToDogCommand();
		}
		return (JumpToDogCommand)locInstance;
	}
	
}
