package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class AboutCommand extends Command implements ActionListener, ICommand {
	private GameWorld target;
	private static AboutCommand locInstance;

	private AboutCommand() {
		super("About");
	}

	public void actionPerformed(ActionEvent evt) {
		target.showAbout();
	}

	public void setTarget(GameWorld gw) {
		target = gw;
	}

	public static AboutCommand getInstance() {
		if (locInstance == null) {
			locInstance = new AboutCommand();
		}
		return (AboutCommand) locInstance;
	}

}
