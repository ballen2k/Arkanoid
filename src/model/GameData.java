package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;

import javax.swing.Timer;

import states.State;

import controller.Ball;
import controller.GameObjectFactory;
import controller.LevelManager;
import controller.Player;
import controller.Wall;
/*
 * Class containing all the data for the game. Including Levels, Power-ups, player(s) and other 
 * GameObjects i.e the ball.
 */
public class GameData extends Observable implements ActionListener {

	private LevelData levelData;
	private BallData ballData;
	private Timer timer;
	private Random random = new Random();
	private states.State activeState;
	private ArrayList<controller.GameObject> menuList;
	public int points = 0;
	private boolean clicked = false;
	private int clicked_x = 0;
	private int clicked_y = 0;
	
	private boolean rightClick = false;
	private int rightClicked_x = 0;
	private int rightClicked_y = 0;

	private int mousepos_x = 0;
	private int mousepos_y = 0;

	private boolean activeGame = false;
	private boolean changeLevel = false; 

	private LevelManager levelManager;
	private UserData userData;
	private HighscoreData highscoreData; 
	private PowerUpData powerUpData;
	private GunShotData gunShotData; 

	public GameData() {
		userData = new UserData(3, 0);

		timer = new Timer(35, this);
		timer.start();
		activeState = new states.StateMenu();

		levelManager = new LevelManager();
		levelManager.loadLevels("fil.f");
		
		highscoreData = new HighscoreData();
		highscoreData.loadHighscore("highscore.f");
	}
	
	/**
	 * @param active Set activeGame to active
	 */
	public void setActiveGame(boolean active) {
		activeGame = active;
	}
	
	public void setChangeLevel(boolean changeLevel) {
		this.changeLevel = changeLevel;
	}
	
	public boolean getChangeLevel() {
		return this.changeLevel; 
	}
	
	/**
	 * @return Returns true if there is a game active, else false
	 */
	public boolean getActiveGame() {
		return activeGame;
	}
	
	public HighscoreData getHighscoreData() {
		return highscoreData; 
	}
	
	public PowerUpData getPowerUpData() {
		return this.powerUpData;
	}
	
	public GunShotData getGunShotData() {
		return this.gunShotData;
	}
	
	public void changeState(states.State state) {
		activeState = state;
		setChanged();
		notifyObservers(state);
	}

	public LevelData getLevelData() {
		return levelData;
	}

	public Player getPlayer() {
		return userData.getPlayer();
	}

	public void click(int x, int y) {
		clicked = true;
		clicked_x = x;
		clicked_y = y;
	}
	
	public void rightClick(int x, int y) {
		rightClick = true; 
		rightClicked_x = x; 
		rightClicked_y = y;
	}

	public void mouseMove(int x, int y) {
		mousepos_x = x;
		mousepos_y = y;
	}

	public LevelManager getLevelManager() {
		return levelManager;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (clicked) {
			activeState.setClick(clicked_x, clicked_y);
			clicked=false;
		} else if(rightClick) {
			activeState.setRightClick(clicked_x, clicked_y);
			rightClick = false;
		}
		if(!activeGame) {
			userData = new UserData(3, 0);
			ballData = new BallData(this);
			powerUpData = new PowerUpData();
			gunShotData = new GunShotData();
		}
		
		if(changeLevel) {
			ballData = new BallData(this);
			powerUpData = new PowerUpData();
			gunShotData = new GunShotData();
			changeLevel = false; 
		}
		
		activeState.setMouse(mousepos_x, mousepos_y);
		activeState.update(this, userData);
		setChanged();
		notifyObservers(userData);
		setChanged();
		notifyObservers(activeState.getObjects());
	}

	public BallData getBallData() {
		return ballData;
	}

}
