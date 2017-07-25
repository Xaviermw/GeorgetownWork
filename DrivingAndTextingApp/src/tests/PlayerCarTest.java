package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Game;
import code.TextEntry;
import code.cars.ObstacleCar;
import code.cars.PlayerCar;
import code.cars.PoliceCar;
import code.screens.GameScreen;

public class PlayerCarTest{

	PlayerCar playerCar;
	ObstacleCar obstacleCar;
	PoliceCar policeCar;
	
	TextEntry textEntry;
	
	@Before
	public void setUp(){
		playerCar = new PlayerCar();
		textEntry = new TextEntry(new GameScreen(new Game()));
	}
	
	@Test
	public void moveTest(){
		assertEquals(playerCar.getX(), 285, 0);
		assertEquals(playerCar.getVelocity(), 0, 0);
		
		playerCar.setVelocity(-1);
		playerCar.move();
		assertEquals(playerCar.getX(), 275, 0);
	}
	
	@Test
	public void checkCollisionTest(){
		obstacleCar = new ObstacleCar(0, 0);
		obstacleCar.setX(185);
		obstacleCar.setY(310);
		assertFalse(playerCar.checkCollision(obstacleCar));
		
		obstacleCar.setX(285);
		assertTrue(playerCar.checkCollision(obstacleCar));
		
		policeCar = new PoliceCar(0, 0);
		policeCar.setX(285);
		policeCar.setY(350);
		assertTrue(playerCar.checkCollision(policeCar));
	}
	
	@Test
	public void checkPoliceDetectionTest(){
		policeCar = new PoliceCar(0, 0);
		textEntry.setVisible(true);
		assertFalse(playerCar.checkPoliceDetection(policeCar, textEntry));
		
		policeCar.setX(185);
		policeCar.setY(310);
		textEntry.setVisible(false);
		assertFalse(playerCar.checkPoliceDetection(policeCar, textEntry));
		
		textEntry.setVisible(true);
		assertTrue(playerCar.checkPoliceDetection(policeCar, textEntry));
	}

}
