package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import code.cars.ObstacleCar;

public class ObstacleCarTest{

	ObstacleCar obstacleCar;

	@Before
	public void setUp(){
		obstacleCar = new ObstacleCar(0, 0);
		obstacleCar.setX(185);
		obstacleCar.setY(300);
	}

	@Test
	public void moveTest(){
		obstacleCar.move();
		assertEquals(obstacleCar.getY(), 310, 0);

		obstacleCar.setY(500);
		obstacleCar.move();
		assertEquals(obstacleCar.getY(), -300, 0);
	}

}
