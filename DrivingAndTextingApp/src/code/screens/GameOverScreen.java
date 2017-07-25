package code.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * This is our Game Over Screen, It includes a fact, score, and buttons to transition between screens (extends Screen)
 */

import code.Game;


public class GameOverScreen extends Screen{

	private static final long serialVersionUID = 0;

	//Detects whether or not game was ended due to Collision or Detection
	private static final int gameOverCollision = 0;
	private static final int gameOverDetection = 1;
	private String warning;

	//Constructor that calls from super class of Screen
	public GameOverScreen(Game game, int state, int playerScore){
		super(game);
		initGUI(state, playerScore);
	}


	//Initializes the GUI of Game Over Screen, takes in state and score as parameter
	public void initGUI(int state, int playerScore){
		//Colors background Cyan
		setBackground(Color.CYAN);

		//Adjusts the warning string depending on the state of how the game ended

		JLabel background = new JLabel(new ImageIcon("car-accident.jpg"));

		if (state == gameOverCollision) {
			warning = "You just collided with another vehicle! <br>"
					+ "Texting while driving makes you 23x more likely to crash";
		}
		else if(state == gameOverDetection){
			warning = "You were just caught texting while driving! <br>"
					+ "You would be fined $100 in DC";
		}
		else{
			warning = "Congratulations, you ignored your text messages. You win! ";
		}

		//Takes the whole warning and score and places into JLabel
		String msg = "<html>" + warning + "<br>Your 'score' is: " + String.valueOf(playerScore) + "</html>";
		JLabel message = new JLabel(msg);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setFont(new Font("Serif", Font.BOLD, 20));

			//Button Construction
		
		JButton startButton = new JButton("Start Game");
		JButton infoButton = new JButton("Learn More");
		JButton exitButton = new JButton("Exit");

		setLayout(null);

		background.setBounds(0,0,600,400);
		message.setBounds(100,50,400,120);
		startButton.setBounds(200,200,200,50);
		infoButton.setBounds(200,270,200,50);
		exitButton.setBounds(200,340,200,50);

		//Adds Listeners

		background.setOpaque(false);

		startButton.addActionListener(new StartButtonListener());
		infoButton.addActionListener(new InfoButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		add(background);
		background.add(message);
		background.add(startButton);
		background.add(infoButton);
		background.add(exitButton);
	}


	/*
	 * Nested Classes for Button Listeners that wait for events to occur
	 */

	//Start Game
	class StartButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.getContentPane().removeAll();
			//set Screen to New Game Screen
			game.setCurrentScreen(new GameScreen(game));
			game.getContentPane().add(game.getCurrentScreen());
			game.getContentPane().validate();
			game.start();
			//Requests focus for Listeners
			game.getCurrentScreen().requestFocusInWindow();
		}
	}

	//Information Screen
	class InfoButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.getContentPane().removeAll();
			game.setCurrentScreen(new InfoScreen(game));
			game.getContentPane().add(game.getCurrentScreen());
			game.getContentPane().validate();
		}
	}

	//Exit Applet Button
	class ExitButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(ABORT);
		}
	}

}
