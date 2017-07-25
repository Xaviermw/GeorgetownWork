package code;
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * This is our Dirt Class, which gives the illusion of traveling at fast speeds
 */

public class Dirt{

		//Coordinates
	private int x;
	private int y;
		//How fast the block moves during Game
	private final static int speed = 60;

		//Constructor with Parameters
	public Dirt(int x, int y){
		this.x = x;
		this.y = y;
	}

		//Paint Method
	public void paint(Graphics2D graphic2D){
		graphic2D.setColor(new Color(156, 93, 82));
		graphic2D.fillRect(x, y, 5, 40);
	}

		//Moves the block downwards
	public void move(){
		if(y >= 400)
			y = -10;
		else
			y = y + speed;
	}

}
