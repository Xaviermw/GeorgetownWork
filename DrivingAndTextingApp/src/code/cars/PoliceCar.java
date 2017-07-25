package code.cars;
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * Police Car object that stems from Car class
 */

public class PoliceCar extends ObstacleCar{

	private final static int speed = 10;

	//Constructor
	public PoliceCar(int x, int y){
		super(x, y);
	}

	//Moves car down
	@Override
	public void move(){
		if(y == 500){
			y = -2200;
			chooseLane();
		}
		else
			y = y + speed;
	}

	@Override
	public void setPaintColor(Graphics2D graphic2D){
		graphic2D.setColor(Color.BLUE.darker());
	}

}
