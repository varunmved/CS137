package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class ExitCommand extends Command implements ActionListener, ICommand {
	private GameWorld target;
	private static ExitCommand locInstance;

	private ExitCommand() {
		super("Exit");
	}

	public void actionPerformed(ActionEvent evt) {
		target.exitApp();
	}

	public void setTarget(GameWorld gw) {
		target = gw;
	}

	public static ExitCommand getInstance() {
		if (locInstance == null) {
			locInstance = new ExitCommand();
		}
		return (ExitCommand) locInstance;
	}

}
