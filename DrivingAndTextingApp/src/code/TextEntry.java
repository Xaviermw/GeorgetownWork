package code;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.math.*;

/*
 * This is our Text Entry Window Object that displays random text messages for users to recreate
 */


import code.screens.GameScreen;

public class TextEntry{

	//List of possible text messages
	private List<String> messages = Arrays.asList("I will be right there", "Hold on, I am on my way",
			"I can not talk right now, I am driving", "Yes, I can go tonight", "No, sorry, I am busy",
			"Yeah, I already bought everything", "Hey d00d, what are you up to rn?", "Nothing, hbu?", "Hi what's up?",
			"Hello", "No, not now", "Just some readings", "Good, thanks", "Really tired actually", "No, not enough time today",
			"Hold on, I'm going to overtake this car");

	//How many messages are there?
	private int noOfMessages = messages.size();

	//Random object for randomly generated values
	private Random r;

	private boolean visible = false;
	private String messageToType = "Message To Type";
	private String userMessage = "";
	private GameScreen gameScreen;

	//Instructions
	private static final String inst = "Please type the following message exactly:";

	public TextEntry(GameScreen gameScreen){
		this.gameScreen = gameScreen;
	}

	//Function to choose one random text message from list of possible text messages
	public void chooseTextMessage(){
		r = new Random();
		int randomNumber = r.nextInt((noOfMessages - 0));

		messageToType = messages.get(randomNumber);
	}

	//Function to check correctness of user's text message
	public boolean compareUserMessage(){
		int numberOfErrors = 0;
		int i = 0;
		//Until we hit end of either user's or prompted message
		while(i < messageToType.length() && i < userMessage.length()){
			if(messageToType.charAt(i) != userMessage.charAt(i))
				numberOfErrors++;
			i++;
		}

		//Account for missing characters
		numberOfErrors = numberOfErrors + (messageToType.length() - i);

		if(numberOfErrors > 10)
			return false;
		else
			return true;
	}

	//Reset
	public void resetUserMessage(){
		userMessage = "";
	}

	//Reset
	public void resetMessageToType(){
		chooseTextMessage();
	}

	public boolean isVisible(){
		return visible;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}

	//KeyPressed events to track user input
	public void keyPressed(KeyEvent event){
		//If the window isn't open
		if(!visible){
			if(event.getKeyCode() == KeyEvent.VK_DOWN)
			{
				visible = true;
			}
		}
		else{
			switch(event.getKeyCode()){
			case KeyEvent.VK_UP:
				visible = false;
				break;
			//Delete one char
			case KeyEvent.VK_BACK_SPACE:
				if(userMessage.length() > 0)
					userMessage = userMessage.substring(0, userMessage.length() - 1);
				break;			
			//Submit text message
			case KeyEvent.VK_ENTER:
				if(userMessage.length() > 0){
					if(compareUserMessage()){
						resetUserMessage();
						resetMessageToType();
						visible = false;
						gameScreen.timerIncrease();
						gameScreen.newMessageDelay();
					}
					else
						System.out.println("Bad!");
				}
			default:
				break;
			}
		}
	}

	//Grabs all ASCII values for typing the message
	public void keyTyped(KeyEvent event){
		if(visible){
			char newCharacter = event.getKeyChar();
			if(newCharacter != 8 && newCharacter != 10 && newCharacter != 14) //ASCII code for Backspace/Enter/Shift - this prevents these keys from incrementing userMessage length
				userMessage = userMessage + newCharacter;
		}
	}

	//Paint the text entry window
	public void paint(Graphics2D graphics2D){
		graphics2D.setColor(Color.GRAY);
		graphics2D.fillRect(50, 0, 500, 250);

		graphics2D.setColor(Color.BLACK);
		graphics2D.drawLine(50, 170, 550, 170);

		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(65, 175, 470, 50);

		graphics2D.setColor(Color.BLACK);
		graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		graphics2D.drawString(inst, 70, 40);
		graphics2D.drawString(messageToType, 70, 140);
		graphics2D.drawString(userMessage, 70, 220);
	}

}
