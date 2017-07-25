package code;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * This is our Road Object with a bunch of Stripes that add to visuals 
 */

public class Road{

		//Dimensions of Road
	private final static int ROAD_WIDTH = 300;
	private final static int ROAD_HEIGHT = 400;

		//Strips Y, will change and update
	private int stripY = -300;
		//Strip's distance from each other
	private final static int STRIP_DIST = 80;

	public void moveStrips(){
		if(stripY >= 0)
			stripY = -300;
		else
			stripY = stripY + 20;
	}

	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLACK);
		graphic2D.fillRect(150, 0, ROAD_WIDTH, ROAD_HEIGHT);

		//Create lane marks
		graphic2D.setColor(Color.YELLOW);
		graphic2D.fillRect(245, 0, 5, ROAD_HEIGHT); //should make these into constants at some point
		graphic2D.fillRect(345, 0, 5, ROAD_HEIGHT);

		graphic2D.setColor(Color.BLACK);
		
			//Strips that Partition the Lane Markers
		graphic2D.fillRect(245, stripY, 5, 40);
		graphic2D.fillRect(345, stripY, 5, 40);
		graphic2D.fillRect(245, stripY + STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + STRIP_DIST, 5, 40);
		graphic2D.fillRect(245, stripY + 2*STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + 2*STRIP_DIST, 5, 40);
		graphic2D.fillRect(245, stripY + 3*STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + 3*STRIP_DIST, 5, 40);
		graphic2D.fillRect(245, stripY + 4*STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + 4*STRIP_DIST, 5, 40);
		graphic2D.fillRect(245, stripY + 5*STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + 5*STRIP_DIST, 5, 40);
		graphic2D.fillRect(245, stripY + 6*STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + 6*STRIP_DIST, 5, 40);
		graphic2D.fillRect(245, stripY + 7*STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + 7*STRIP_DIST, 5, 40);
		graphic2D.fillRect(245, stripY + 8*STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + 8*STRIP_DIST, 5, 40);
		graphic2D.fillRect(245, stripY + 9*STRIP_DIST, 5, 40);
		graphic2D.fillRect(345, stripY + 9*STRIP_DIST, 5, 40);

			//Road Barriers
		graphic2D.setColor(Color.GRAY.darker());
		graphic2D.fillRect(135, 0, 15, ROAD_HEIGHT);
		graphic2D.fillRect(450, 0, 15, ROAD_HEIGHT);

			//Moves the Black Strips
		moveStrips();
	}

}
