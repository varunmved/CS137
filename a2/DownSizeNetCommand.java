package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class DownSizeNetCommand extends Command implements ActionListener, ICommand{
	private GameWorld target;
	private static DownSizeNetCommand locInstance;
	
	private DownSizeNetCommand(){
		super("Contract Net");
	}
	
	public void actionPerformed(ActionEvent evt) {
		target.downSizeNet();	
	}
	
	public void setTarget(GameWorld gw){
		target = gw;
	}
	public static DownSizeNetCommand getInstance(){
		if(locInstance == null){
			locInstance = new DownSizeNetCommand();
		}
		return (DownSizeNetCommand)locInstance;
	}	
}
