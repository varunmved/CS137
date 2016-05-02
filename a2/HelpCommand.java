package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class HelpCommand extends Command implements ActionListener, ICommand {
	private GameWorld target;
	private static HelpCommand locInstance;

	private HelpCommand() {
		super("Help?");
	}

	public void actionPerformed(ActionEvent evt) {
		target.showHelp();
	}

	public void setTarget(GameWorld gw) {
		target = gw;
	}

	public static HelpCommand getInstance() {
		if (locInstance == null) {
			locInstance = new HelpCommand();
		}
		return (HelpCommand) locInstance;
	}

}
