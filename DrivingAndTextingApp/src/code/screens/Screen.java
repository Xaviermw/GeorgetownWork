package code.screens;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


/*
 * Our Abstract Screen class that is root for GameScreen, GameOverScreen, InfoScreen, and InstructionScreen
 */

import code.Game;


public abstract class Screen extends JPanel implements Runnable{

	private static final long serialVersionUID = 0;

	protected Game game;

	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 400;

	public Screen(Game game){
		this.game = game;
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setDoubleBuffered(true);
	}

	@Override
	public void paint(Graphics graphic){
		super.paint(graphic);
	}

	@Override
	public void run(){
		while(true){
			repaint();
		}
	}

}
