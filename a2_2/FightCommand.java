package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class FightCommand extends Command implements ActionListener, ICommand {
	private GameWorld target;
	private static FightCommand locInstance;

	private FightCommand() {
		super("Fight");
	}

	public void actionPerformed(ActionEvent evt) {
		target.catDogfight();
	}

	public void setTarget(GameWorld gw) {
		target = gw;
	}

	public static FightCommand getInstance() {
		if (locInstance == null) {
			locInstance = new FightCommand();
		}
		return (FightCommand) locInstance;
	}

}
