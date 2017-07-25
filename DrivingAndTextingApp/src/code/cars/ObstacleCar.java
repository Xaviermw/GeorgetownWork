package code.cars;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * This is our Obstacle Car, we have 5 that choose lanes and travel along the highway. If the user collides, he or she loses
 */

public class ObstacleCar extends Car{

	private final static int laneOne = 183;
	private final static int laneTwo = 283;
	private final static int laneThree = 383;
	private final static int speed = 10;

	public ObstacleCar(int x, int y){
		super(x, y);
		chooseLane();
	}

	//Chooses which lane the car will spawn in
	protected void chooseLane(){
		//Generate lane number
		lane = (int)(Math.random() * 3);
		switch(lane){
		case 0:
			x = laneOne;
			break;
		case 1:
			x = laneTwo;
			break;
		case 2:
			x = laneThree;
			break;
		default:
			break;
		}
	}

	//Moves car down
	public void move(){
		if(y == 500){
			y = -300;
			chooseLane();
		}
		else
			y = y + speed;
	}

	@Override
	public void setPaintColor(Graphics2D graphic2D){
		graphic2D.setColor(Color.RED);
	}

}
