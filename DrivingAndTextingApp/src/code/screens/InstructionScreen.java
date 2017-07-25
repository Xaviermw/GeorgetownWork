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
 * This is our Instructions Screen that informs the user the basics about our Applet
 */



import code.Game;


public class InstructionScreen extends Screen{

	private static final long serialVersionUID = 0;

	//Initializes GUI
	public InstructionScreen(Game game){
		super(game);
		initGUI();
	}

	public void initGUI(){
		setBackground(Color.CYAN);
		//Labels the Contain Text to Display to Users

		JLabel background = new JLabel(new ImageIcon("car-accident.jpg"));
		JLabel instruction = new JLabel();
		JLabel instructionTitle = new JLabel("INSTRUCTIONS");
		JLabel policeCarLabel = new JLabel("Police Car");
		JButton startButton = new JButton("Return to Main Screen");
		

			//Set Instruction Title Attributes

		background.setBounds(0,0,600,400);

		instructionTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		instructionTitle.setBounds(200,5,200,100);
		instructionTitle.setLocation(240,-20);
			//Set Police Car Label

		background.setOpaque(false);


		//Set Instruction Title Attributes
		background.setBounds(0,0,600,400);
		instructionTitle.setFont(new Font("Serif", Font.ITALIC, 20));
		instructionTitle.setBounds(200,5,200,100);
		instructionTitle.setLocation(240,-20);

		//Set Police Car Label
		background.setOpaque(false);
		policeCarLabel.setLocation(450,250);
		policeCarLabel.setOpaque(false);

		//Set Instructions 
		instruction.setText("<html>Use the left and right arrows to move your car between lanes.<br><br>"
				+ "A red circle in the upper left corner will flash when you have a new text message!<br>"
				+ "Use the down arrow to pull down the text screen.<br>" 
				+ "Use the up arrow to pull up the text screen.<br>"
				+ "Type the text and press Enter to send the text.<br><br><br>"
				+ "Avoid texting with a police car on the road!<br><br>"
				+ "Avoid accidents with other cars!</html>");

		//Set Instructions Attributes
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		instruction.setVerticalAlignment(SwingConstants.CENTER);
		instruction.setFont(new Font("Serif", Font.PLAIN, 14));
		instruction.setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		//Add Listener to Start Button
		startButton.addActionListener(new StartButtonListener());

		//Set Bounds for Instructions, button and Label
		instruction.setBounds(50,50,500,250);
		startButton.setBounds(200,320,200,50);
		policeCarLabel.setBounds(400,230,100,100);

		instruction.setOpaque(true);
		policeCarLabel.setOpaque(false);

		JLabel ObstCar = new JLabel();			//Picture of an example Obstacle Car
		ObstCar.setBackground(Color.RED);
		ObstCar.setBounds(425,200,30,60);
		ObstCar.setOpaque(true);

		JLabel PoliceCar = new JLabel();		//Picture of an example Police Car
		PoliceCar.setBackground(Color.BLUE);
		PoliceCar.setBounds(475,200,30,60);
		PoliceCar.setOpaque(true);

		JLabel PlayerCar = new JLabel();		//Picture of an example Player Car
		PlayerCar.setBackground(Color.GREEN);
		PlayerCar.setBounds(450,53,30,60);
		PlayerCar.setOpaque(true);
		

		//Add
		add(background);

		background.add(policeCarLabel);
		background.add(instructionTitle);
		background.add(PlayerCar);
		background.add(PoliceCar);
		background.add(ObstCar);
		background.add(instruction);
		background.add(startButton);
		background.add(policeCarLabel);
	}

	//Implements Listener for Start Button
	class StartButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.getContentPane().removeAll();
			game.setCurrentScreen(new StartScreen(game));
			game.getContentPane().add(game.getCurrentScreen());
			game.getContentPane().validate();
		}
	}

}
