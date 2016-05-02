package com.mycompany.a2;
import java.util.ArrayList;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;

import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
/*

 *Bryce Hairabedian
 * CSC 133 Sec 1
 * Assignment 2
 */

public class Game extends Form{
	
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private final int SOLID = 255;
	private final String GAMETITLE = new String("Dog Catcher Game");
	
	private CheckBox checkbox;
	private Button expandButton, netLeftButton, jumpDogButton, netUpButton, contractButton, fightButton;
	private Button netDownButton, netRightButton, jumpCatButton, scoopButton, kittenButton, tickButton;
	
	DownSizeNetCommand myDownSizeNetCommand;
	ExpandNetCommand myExpandNetCommand;
	FightCommand myFightCommand;
	JumpToCatCommand myJumpToCatCommand;
	JumpToDogCommand myJumpToDogCommand;
	KittenCommand myKittenCommand;
	ScoopCommand myScoopCommand;
	MoveUpCommand myMoveUpCommand;
	MoveDownCommand myMoveDownCommand;
	ExitCommand myExitCommand;
	TickCommand myTickCommand;
	SoundCommand mySoundCommand;
	MoveLeftCommand myMoveLeftCommand;
	MoveRightCommand myMoveRightCommand;
	AboutCommand myAboutCommand;
	HelpCommand myHelpCommand;
	
	ArrayList<ActionListener> cmdCollection = new ArrayList<ActionListener>();
	
	public Game(){
		gw = new GameWorld();
		
		//Create Observers
		mv = new MapView();
		sv = new ScoreView();
		
		//Register Observers
		gw.addObserver(mv);
		gw.addObserver(sv);
		
		//Set Targets
		mv.setTargetWorld(gw);
		sv.setTargetWorld(gw);
	
		/** code here to create Command objects for each command, */
		createCommandObjects();
		
		//Set Target for all commands
		int i = cmdCollection.size() - 1;
		for(;i>=0;i--){
			((ICommand)(cmdCollection.get(i))).setTarget(gw);
		}
		
		/** GUI Stuff */
	//ToolBar
		Toolbar tb = new Toolbar();
		this.setToolbar(tb);
		this.setTitle(GAMETITLE);
		tb.addCommandToSideMenu(myScoopCommand);
		tb.addCommandToSideMenu(mySoundCommand);
		tb.addCommandToSideMenu(myAboutCommand);
		tb.addCommandToSideMenu(myExitCommand);
		tb.addCommandToRightBar(myHelpCommand);
		
	//Checkbox
		checkbox = new CheckBox();
		
		checkbox.setCommand(mySoundCommand);
		mySoundCommand.putClientProperty("SideComponent",  checkbox);
		checkbox.setEnabled(true);//initialize
	//Create all Buttons and style		
		createButtons();
	//set commands to all buttons
		setCommandsToAllButtons(); //only buttons, not checkbox
	//Set Layout
		this.setLayout(new BorderLayout());
		
	//West Container
		Container westContainer = new Container(new GridLayout(4,1));
		westContainer.getAllStyles().setPadding(Component.TOP, 100);
		westContainer.getAllStyles().setPadding(Component.BOTTOM, 100);
		westContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.YELLOW));

	//East Container
		Container eastContainer = new Container(new GridLayout(4,1));
		eastContainer.getAllStyles().setPadding(Component.TOP, 100);
		eastContainer.getAllStyles().setPadding(Component.BOTTOM, 100);
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.GREEN));

	//South Container
		Container southContainer = new Container(new FlowLayout(Component.CENTER));
		southContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.MAGENTA));
		
		

	//Add buttons to Containers
		westContainer.add(expandButton);
		westContainer.add(netUpButton);
		westContainer.add(netLeftButton);
		westContainer.add(jumpDogButton);
		
		eastContainer.add(contractButton);
		eastContainer.add(netDownButton);
		eastContainer.add(netRightButton);
		eastContainer.add(jumpCatButton);
		eastContainer.add(scoopButton);
		
		southContainer.add(kittenButton);
		southContainer.add(tickButton);
		southContainer.add(fightButton);

		add(BorderLayout.EAST, eastContainer);
		add(BorderLayout.WEST, westContainer);
		add(BorderLayout.SOUTH, southContainer);
		add(BorderLayout.CENTER, mv);//mv is the south container
		add(BorderLayout.NORTH, sv); //sv is the north container
		
	//Bind Keys to commands
		addKeyListener('e', myExpandNetCommand);
		addKeyListener('x', myExitCommand);
		addKeyListener('t', myTickCommand);
		addKeyListener('f', myFightCommand);
		addKeyListener('k', myKittenCommand);
		addKeyListener('a', myJumpToCatCommand);
		addKeyListener('o', myJumpToDogCommand);
		addKeyListener('u', myMoveUpCommand);
		addKeyListener('d', myMoveDownCommand);
		addKeyListener('l', myMoveLeftCommand);
		addKeyListener('r', myMoveRightCommand);
		addKeyListener('s', myScoopCommand);
		addKeyListener('c', myDownSizeNetCommand);
		
		this.show();
		gw.initScore(mv.getWidth(),mv.getHeight());//initialize score 
		/*******************************************/
		gw.initLayout();	//initialize world create Objecs
		//mv.getWidth();
		gw.initScore(mv.getWidth(),mv.getHeight());//initialize score and map view
	} //end Game() constuctor
	public int getMapHeight(){
		return mv.getHeight();
	}
	public int getMapWidth(){
		return mv.getWidth();
	}
	private void setCommandsToAllButtons(){
		expandButton.setCommand(myExpandNetCommand);
		contractButton.setCommand(myDownSizeNetCommand);
		netUpButton.setCommand(myMoveUpCommand);
		netDownButton.setCommand(myMoveDownCommand);
		netLeftButton.setCommand(myMoveLeftCommand);
		netRightButton.setCommand(myMoveRightCommand);
		
		jumpDogButton.setCommand(myJumpToDogCommand);
		jumpCatButton.setCommand(myJumpToCatCommand);
		
		scoopButton.setCommand(myScoopCommand);
		kittenButton.setCommand(myKittenCommand);
		tickButton.setCommand(myTickCommand);
		
		fightButton.setCommand(myFightCommand);
	}
	
	/**Create Command Objects and add to command collection*/
	private void createCommandObjects(){
		myDownSizeNetCommand = DownSizeNetCommand.getInstance();
		cmdCollection.add(myDownSizeNetCommand);
		
		myExpandNetCommand = ExpandNetCommand.getInstance();
		cmdCollection.add(myExpandNetCommand);
		
		myFightCommand = FightCommand.getInstance();
		cmdCollection.add(myFightCommand);
		
		myJumpToCatCommand = JumpToCatCommand.getInstance();
		cmdCollection.add(myJumpToCatCommand);
		
		myJumpToDogCommand = JumpToDogCommand.getInstance();
		cmdCollection.add(myJumpToDogCommand);
		
		myKittenCommand = KittenCommand.getInstance();
		cmdCollection.add(myKittenCommand);
		
		myScoopCommand = ScoopCommand.getInstance();
		cmdCollection.add(myScoopCommand);
		
		myMoveUpCommand = MoveUpCommand.getInstance();
		cmdCollection.add(myMoveUpCommand);
		
		myMoveDownCommand = MoveDownCommand.getInstance();
		cmdCollection.add(myMoveDownCommand);
		
		myMoveRightCommand = MoveRightCommand.getInstance();
		cmdCollection.add(myMoveRightCommand);
		
		myMoveLeftCommand = MoveLeftCommand.getInstance();
		cmdCollection.add(myMoveLeftCommand);
	
		myTickCommand = TickCommand.getInstance();
		cmdCollection.add(myTickCommand);
		
		mySoundCommand = SoundCommand.getInstance();
		cmdCollection.add(mySoundCommand);
		
		myExitCommand = ExitCommand.getInstance();
		cmdCollection.add(myExitCommand);
		
		
		myAboutCommand = AboutCommand.getInstance();
		cmdCollection.add(myAboutCommand);
		
		myHelpCommand = HelpCommand.getInstance();
		cmdCollection.add(myHelpCommand);
	}
	private void createButtons(){
		//West/Left side buttons
		expandButton = new Button("Expand Net");
		netLeftButton = new Button("Left");
		jumpDogButton = new Button("Jump-to-Dog");
		netUpButton = new Button("Up");
		
		//East/right side buttons
		contractButton = new Button("Contract Net");
		netDownButton = new Button("Down");
		netRightButton = new Button("Right");
		jumpCatButton = new Button("Jump-to-Cat");
		scoopButton = new Button("Scoop");
		
		//South/lower buttons
		kittenButton = new Button("Kitten");
		fightButton = new Button("Fight");
		tickButton = new Button("Tick");
		
	    //Styles-> set transparency for all
		checkbox.getAllStyles().setBgTransparency(SOLID);
		expandButton.getAllStyles().setBgTransparency(SOLID);
		netLeftButton.getAllStyles().setBgTransparency(SOLID);
		jumpDogButton.getAllStyles().setBgTransparency(SOLID);
		netUpButton.getAllStyles().setBgTransparency(SOLID);
		contractButton.getAllStyles().setBgTransparency(SOLID);
		netDownButton.getAllStyles().setBgTransparency(SOLID);
		netRightButton.getAllStyles().setBgTransparency(SOLID);
		jumpCatButton.getAllStyles().setBgTransparency(SOLID);
		scoopButton.getAllStyles().setBgTransparency(SOLID);
		kittenButton.getAllStyles().setBgTransparency(SOLID);
		fightButton.getAllStyles().setBgTransparency(SOLID);
		tickButton.getAllStyles().setBgTransparency(SOLID);
		
		//Styles-> set color
		checkbox.getAllStyles().setBgColor(ColorUtil.GRAY);
		
		expandButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		expandButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		netLeftButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		netLeftButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		jumpDogButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		jumpDogButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		netUpButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		netUpButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		contractButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		contractButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		netDownButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		netDownButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		netRightButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		netRightButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		jumpCatButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		jumpCatButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		scoopButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		scoopButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		kittenButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		kittenButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		fightButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		fightButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		
		tickButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		tickButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);

	}
	public static void printInvalidInput(){
            System.out.println("Invalid Input, Please Try again");
    }
}//END GAME





