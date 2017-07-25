package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerCarVelocityTest {

	code.cars.PlayerCar playCar = new code.cars.PlayerCar();
	
	@Before
	public void setUp(){
		playCar.setVelocity(1);
	}
	
	@Test
	public void testGetVelocity(){
		assertEquals(playCar.getVelocity(), 1);
	}

}
