package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorrectEntryIncrementTest {
	
	code.Game testGame = new code.Game();
	code.screens.GameScreen testScreen = new code.screens.GameScreen(testGame);

	@Test
	public void testTimer() {
		testScreen.timerIncrease();
		assertEquals(testScreen.getTimerValue(), 600);
	}

}
