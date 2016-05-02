package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class ExpandNetCommand extends Command implements ActionListener, ICommand {
	private GameWorld target;
	private static ExpandNetCommand locInstance;

	private ExpandNetCommand() {
		super("Expand Net");
	}

	public void actionPerformed(ActionEvent evt) {
		target.expandNet();
	}

	public void setTarget(GameWorld gw) {
		target = gw;
	}

	public static ExpandNetCommand getInstance() {
		if (locInstance == null) {
			locInstance = new ExpandNetCommand();
		}
		return (ExpandNetCommand) locInstance;
	}

}
