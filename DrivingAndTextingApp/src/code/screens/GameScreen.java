package code.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import code.Dirt;
import code.Game;
import code.Notification;
import code.Road;
import code.TextEntry;
import code.cars.ObstacleCar;
import code.cars.PlayerCar;
import code.cars.PoliceCar;

/*
 * This is our Game Screen class, where the majority of our code resides. The Game is fairly simply: avoid cars while
 * completing the prompted text messages in a timely manner.
 */

public class GameScreen extends Screen{

	private int playerScore = 0;
	private int timerValue = 500;	//Initial timer Value
	private int notificationDelay;
	//Random Object used for Randomly Generated Values
	Random random = new Random();

	//All objects such as cars, blocks, notifications, and labels
	private Road road;
	private PlayerCar playerCar;
	private ArrayList<ObstacleCar> obstacleCars;
	private PoliceCar policeCar;
	private TextEntry textEntry;
	private Notification notification;

	private ArrayList<Dirt> dirtBlocks;

	//Relevant Constants
	private static final int DELAY = 100;
	private static final long serialVersionUID = 0;
	private static final int gameOverCollision = 0;
	private static final int gameOverDetection = 1;
	private static final int gameOverTimer = 2;

	//Should the Game be Running?
	private boolean running = true;
	//Has the window been rendered for the first time?
	private boolean firstRend = false;
	//Should we display the print notification?
	private boolean printNotification = true;

	//Constructor, calls super class' constructor
	public GameScreen(Game game){
		super(game);
		setBackground(Color.GREEN.darker());
		setFocusable(true);

		road = new Road();

		//Create all Dirt Block Objects
		dirtBlocks = new ArrayList<Dirt>();
		dirtBlocks.add(new Dirt(50, 300));
		dirtBlocks.add(new Dirt(20, 240));
		dirtBlocks.add(new Dirt(35, 110));
		dirtBlocks.add(new Dirt(90, 50));
		dirtBlocks.add(new Dirt(75, 0));
		dirtBlocks.add(new Dirt(500, 380));
		dirtBlocks.add(new Dirt(530, 240));
		dirtBlocks.add(new Dirt(480, 110));
		dirtBlocks.add(new Dirt(570, 10));

		//Create Player Car
		playerCar = new PlayerCar();

		//Create Obstacle Cars with Coordinates
		obstacleCars = new ArrayList<ObstacleCar>();
		
		obstacleCars.add(new ObstacleCar(0, -400));
		obstacleCars.add(new ObstacleCar(0, -700));
		obstacleCars.add(new ObstacleCar(0, -1000));
		obstacleCars.add(new ObstacleCar(0, -900));
		obstacleCars.add(new ObstacleCar(0, -500));

		//Create Police Car with Coords
		policeCar = new PoliceCar(0, -800);

		//Create Text Entry
		textEntry = new TextEntry(this);
		textEntry.chooseTextMessage(); //Choose the first message

		//Create Notification Icon
		notification = new Notification(this);

		//Initiate all Key Listeners
		initiateListeners();
	}

	//Creates listener Objects
	public void initiateListeners(){
		KeyListener listener = new KeyListener(){

			@Override
			public void keyTyped(KeyEvent event){
				textEntry.keyTyped(event);
			}

			@Override
			public void keyReleased(KeyEvent event){}

			@Override
			public void keyPressed(KeyEvent event){
				if(event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_RIGHT)
					playerCar.keyPressed(event);
				else if (printNotification)
					textEntry.keyPressed(event);
			}
		};

		//Adds listener and sets focus to Window
		addKeyListener(listener);
		requestFocusInWindow();
		setFocusable(true);
	}

	//Game Over Method that ends the game and takes user to Game Over Screen
	public void gameOver(int state){
		running = false;

		//Creates Game Over Screen
		game.getContentPane().removeAll();
		game.setCurrentScreen(new GameOverScreen(game, state, playerScore));
		game.getContentPane().add(game.getCurrentScreen());
		game.getContentPane().validate();
	}

	//Returns Player Score
	public int getScore(){
		return playerScore;
	}

	public int getTimerValue() {
		return timerValue;
	}

	//Paints the textEntry Object for the first time to allow for smoother gameplay
	public void paintInitialTextEntry(Graphics graphic){
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Paint it and Set its visibility to false (we don't need to see it the first time)
		textEntry.paint(graphic2D);
		textEntry.setVisible(false);
	}

	//Paints ALL OUR OBJECTS
	@Override
	public void paint(Graphics graphic){
		super.paint(graphic);
		Graphics2D graphic2D = (Graphics2D) graphic;
		graphic2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//Paint Text Entry if prompted to
		if(!textEntry.isVisible() && !firstRend){
			textEntry.paint(graphic2D);
			firstRend = true;
		}

		//Paint the Road
		road.paint(graphic2D);

		//Paint All Dirt Blocks
		for(Dirt eachDirtBlock : dirtBlocks)
			eachDirtBlock.paint(graphic2D);

		//Paint both Police Car and Player Car
		playerCar.paint(graphic2D);
		policeCar.paint(graphic2D);
		//Paint All Obstacle Cars
		for(ObstacleCar eachObstacleCar : obstacleCars)
			eachObstacleCar.paint(graphic2D);

		//Paint Notification Icon
		if (printNotification)
			notification.paint(graphic2D);
		else if (notificationDelay == 0)
			printNotification = true;
		else
			notificationDelay--;


		graphic.setFont(new Font("Serif", Font.BOLD, 20));
		graphic.drawString("Score: "+ String.valueOf(getScore()), 500, 40); 

		graphic.drawString("Timer: "+ String.valueOf(timerValue), 25, 375);

		//Only paint if the user has opened the texting window
		if(textEntry.isVisible())
			textEntry.paint(graphic2D);
	}

	//Increment Timer
	public void timerIncrease(){
		timerValue += 100;
	}

	@Override
	public void run(){
		while(running){
			playerScore++;
			timerValue--;

			/*
			 * Call Move Method for Each Object that should Move
			 */
			playerCar.move();
			policeCar.move();

			for(Dirt eachDirtBlock : dirtBlocks)
				eachDirtBlock.move();

			//Check Collision
			if(playerCar.checkCollision(policeCar))
				gameOver(gameOverCollision);

			//Check if Police Detects Unlawful Activity
			if(playerCar.checkPoliceDetection(policeCar, textEntry))
				gameOver(gameOverDetection);

			//Timer runs out
			if(timerValue == 0)
				gameOver(gameOverTimer);

			//Move Obstacle Cars
			for(ObstacleCar eachObstacleCar : obstacleCars){
				eachObstacleCar.move();
				if(playerCar.checkCollision(eachObstacleCar))
					gameOver(gameOverCollision);
			}
			//Repaint
			repaint();

			try{
				Thread.sleep(DELAY);
			} catch(InterruptedException e){
				System.out.println("Interrupted: " + e.getMessage());
			}
		}
	}

	//Delays the next message to be Typed
	public void newMessageDelay() {
		printNotification = false;
		notificationDelay = (random.nextInt(40) + 20);
	}

}

