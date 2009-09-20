package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.Timer;

import controller.Player;

/*
 * Class containing all the data for the game. Including Levels, Power-ups, player(s) and other 
 * GameObjects i.e the ball.
 */
public class GameData extends Observable implements ActionListener {
	
	private LevelData levelData;
	private Player player;
	private BallData ballData;
	private PowerUpData powerUpData;
	Timer timer;
	
	
	public GameData() {
		levelData = new LevelData();
		player = new Player();
		ballData = new BallData(this);
		timer = new Timer(25, this);
		timer.start();
		
	}

	public LevelData getLevelData() {
		return levelData;
	}
	
	public Player getPlayer(){
		return player;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ballData.doYourStuff();
		Player player = getPlayer();
		ArrayList<controller.Ball> ballList = ballData.getBallList();
		ArrayList<controller.GameObject> objects = levelData.getCurrentLevel().getLevel();
		
		for(controller.Ball b : ballList) {
			for(Iterator<controller.GameObject> it = objects.iterator(); it.hasNext(); ) {
				controller.GameObject ob = it.next();
				if(b.intersect(ob)) {
					it.remove();
					b.changeDirectionY();
				}
			}
		}
		//powerUpData.doYourStuff();
		setChanged();
		notifyObservers();
		
	}

	public BallData getBallData() {
		return ballData;
	}
	

	


}
