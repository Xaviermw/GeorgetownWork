package code;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * This is our class for our Notification Icon, it blinks when the User has a message
 */

import code.screens.GameScreen;

public class Notification{

	//The screen to which the Icon belongs to
	private GameScreen gameScreen;
	//Is there an available Message?
	private boolean availableMessage;

	private int tick = 0;
	
	// Constructor
	public Notification(GameScreen gameScreen){
		this.gameScreen = gameScreen;
	}

	//This method methodically paints the Icon depending on how long it has been displaced for
	public void paint(Graphics2D graphic2D){

		if(tick < 10 && tick < 20)
		{
			graphic2D.setColor(Color.WHITE);
			graphic2D.fillOval(12, 4, 50, 50);
			graphic2D.setColor(Color.RED);
			graphic2D.fillOval(17, 9, 40, 40);
			tick++;
		}
		else if(tick >= 10 && tick < 20)
			tick++;
		else if(tick >= 20)
			tick = 0;
	}

}
