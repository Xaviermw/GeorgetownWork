package code.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import code.Game;

/*
 * This Information Screen contains all useful links to take the user to websites containing info
 */

public class InfoScreen extends Screen{

	private static final long serialVersionUID = 0;

	//Constructor that initializes GUI
	public InfoScreen(Game game){
		super(game);
		initGUI();
	}

	public void initGUI(){

		setBackground(Color.CYAN);		
			
			//Buttons to take User to Sites

		JLabel background = new JLabel(new ImageIcon("car-accident.jpg"));
		JButton webButton = new JButton("Learn More Statistics Here");
		JButton multiButton = new JButton("Learn More About The Dangers of Multitasking Here");

		//Quotes that inform User about dangers of Texting and Driving
		JLabel webQuote = new JLabel("<html>13% of Drivers aged 18-20 involved in car wrecks admitted to talking or texting on the time of their crash.</html>");
		webQuote.setFont(new Font("Serif", Font.BOLD, 16));
		JLabel multiQuote = new JLabel("<html>Multitasking doesn't just slow you down and increase the number of mistakes you make; it temporarily changes the way your brain works.<html>");
		multiQuote.setFont(new Font("Serif", Font.BOLD, 16));

		//Return to Main Screen
		JButton startButton = new JButton("Return to Main Screen");

		setLayout(null);

		webQuote.setBounds(100, 10, 400, 100);
		webButton.setBounds(200, 120, 200, 30);
		multiQuote.setBounds(100, 160, 400, 100);
		multiButton.setBounds(100, 270, 400, 30);
		startButton.setBounds(200, 320, 200, 50);
		background.setBounds(0,0,600,400);
		webQuote.setBounds(100,10, 400,100);
		webButton.setBounds(200,120, 200,30);
		multiQuote.setBounds(100,160, 400,100);
		multiButton.setBounds(100,270,400,30);
		startButton.setBounds(200,320,200,50);

		background.setOpaque(false);

		webButton.addActionListener(new WebButtonListener());
		multiButton.addActionListener(new MultiButtonListener());
		startButton.addActionListener(new StartButtonListener());

		add(background);
		background.add(webQuote);
		background.add(webButton);
		background.add(multiQuote);
		background.add(multiButton);
		background.add(startButton);
	}

	/*
	 * Nested Classes that implement Action Listeners for Buttons
	 */

	//Web Button that takes to link
	class WebButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//URL, converts to URI object for parsing
			String link = "http://www.textinganddrivingsafety.com/texting-and-driving-stats/";
			try{
				URI myUri = new URI(link);
				try{
					java.awt.Desktop.getDesktop().browse(myUri);
				} catch(IOException e1){
					e1.printStackTrace();
				}
			} catch(URISyntaxException e1){
				e1.printStackTrace();
			}
		}
	}

	//Button that takes to site about MultiTasking
	class MultiButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String link = "http://www.brainfacts.org/sensing-thinking-behaving/awareness-and-attention/articles/2013/the-multitasking-mind/";
			try{
				URI myUri = new URI(link);
				try{
					java.awt.Desktop.getDesktop().browse(myUri);
				} catch(IOException e1){
					e1.printStackTrace();
				}
			} catch(URISyntaxException e1){
				e1.printStackTrace();
			}
		}
	}

	//Button that goes to Start Screen
	class StartButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.getContentPane().removeAll();
			game.setCurrentScreen(new StartScreen(game));
			game.getContentPane().add(game.getCurrentScreen());
			game.getContentPane().validate();
		}
	}

}
