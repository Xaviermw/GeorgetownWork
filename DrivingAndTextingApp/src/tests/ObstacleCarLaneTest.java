package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ObstacleCarLaneTest {

	code.cars.ObstacleCar obsCar = new code.cars.ObstacleCar(0, 0);
	
	@Test
	public void testChooseLane() {
		int xValue = obsCar.getX();
		boolean result = false;
		if (xValue == 185 || xValue == 285 || xValue == 385)
			result = true;
		assertTrue(result);
	}

}
