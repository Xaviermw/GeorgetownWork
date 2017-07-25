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
 * This is our StartScreen that prompts itself to the User at launch
 */

import code.Game;

public class StartScreen extends Screen{

	private static final long serialVersionUID = 0;

	public StartScreen(Game game){
		super(game);
		initGUI();
	}

	public void initGUI(){
		setBackground(Color.CYAN);

		//Labels and Buttons
		JLabel background = new JLabel(new ImageIcon("car-accident.jpg"));
		JLabel title = new JLabel("No Need for Speed !!!");
		JButton startButton = new JButton("Start Game");
		JButton instructionButton = new JButton("Instructions to the Game");
		JButton infoButton = new JButton("Learn More");
		JButton exitButton = new JButton("Exit");

		setLayout(null);

		//Setting Bounds for Labels and Buttons
		background.setBounds(0,0,600,400);
		title.setBounds(100,20,400,80);
		startButton.setBounds(200,200,200,40);
		instructionButton.setBounds(200,250,200,40);
		infoButton.setBounds(200,300,200,40);
		exitButton.setBounds(200,350,200,40);

		//Adds Listeners
		startButton.addActionListener(new StartButtonListener());
		instructionButton.addActionListener(new InstructionButtonListener());
		infoButton.addActionListener(new InfoButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		background.setOpaque(false);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);

		//Adds
		add(background);
		background.add(title);
		background.add(startButton);
		background.add(instructionButton);
		background.add(infoButton);
		background.add(exitButton);
	}

	//Nested Classes that implement Action Listeners for Buttons

	//Start Game Button
	class StartButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			game.getContentPane().removeAll();
			game.setCurrentScreen(new GameScreen(game));
			game.getContentPane().add(game.getCurrentScreen());
			game.getContentPane().validate();
			game.start();
			game.getCurrentScreen().requestFocusInWindow();
		}
	}

	//Instructions Button
	class InstructionButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			game.getContentPane().removeAll();
			game.setCurrentScreen(new InstructionScreen(game));
			game.getContentPane().add(game.getCurrentScreen());
			game.getContentPane().validate();
			game.getCurrentScreen().requestFocusInWindow();
		}
	}

	//Information Screen Button
	class InfoButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			game.getContentPane().removeAll();
			game.setCurrentScreen(new InfoScreen(game));
			game.getContentPane().add(game.getCurrentScreen());
			game.getContentPane().validate();
			game.getCurrentScreen().requestFocusInWindow();
		}
	}

	//Exit Game Listener
	class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(ABORT);
		}
	}

}
