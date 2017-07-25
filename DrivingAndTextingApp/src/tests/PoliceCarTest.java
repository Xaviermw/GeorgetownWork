package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.cars.PoliceCar;

public class PoliceCarTest{

	PoliceCar policeCar;
	
	@Before
	public void setUp(){
		policeCar = new PoliceCar(0, 0);
		policeCar.setX(185);
		policeCar.setY(300);
	}
	
	@Test
	public void moveTest(){
		policeCar.move();
		assertEquals(policeCar.getY(), 310, 0);
		
		policeCar.setY(500);
		policeCar.move();
		assertEquals(policeCar.getY(), -2200, 0);
	}

}
