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
	
	/**
	 * Set changeLevel when changing level so GameData can reload
	 * the different models.
	 * @param changeLevel
	 */
	public void setChangeLevel(boolean changeLevel) {
		this.changeLevel = changeLevel;
	}
	
	/**
	 * Returns true it is time to change level
	 * @return changeLevel
	 */
	public boolean getChangeLevel() {
		return this.changeLevel; 
	}
	
	/**
	 * @return Returns true if there is a game active, else false
	 */
	public boolean getActiveGame() {
		return activeGame;
	}
	
	/** 
	 * 
	 * @return highscoreData
	 */
	public HighscoreData getHighscoreData() {
		return highscoreData; 
	}
	/**
	 * 
	 * @return powerUpData
	 */
	public PowerUpData getPowerUpData() {
		return this.powerUpData;
	}
	
	/**
	 * @return gunShotData
	 */
	public GunShotData getGunShotData() {
		return this.gunShotData;
	}
	
	/**
	 * Changes gamestate
	 * @param state
	 */
	public void changeState(states.State state) {
		activeState = state;
		setChanged();
		notifyObservers(state);
	}

	/**
	 * Getter for LevelData
	 * @return
	 */
	public LevelData getLevelData() {
		return levelData;
	}

	/**
	 * Returns player
	 * @return player
	 */
	public Player getPlayer() {
		return userData.getPlayer();
	}

	/**
	 * Gets set when user clicks
	 * @param x MouseCoordX
	 * @param y	 MouseCoordY
	 */
	public void click(int x, int y) {
		clicked = true;
		clicked_x = x;
		clicked_y = y;
	}
	
	/**
	 * Gets set when user right clicks with mouse
	 * @param x MouseCoordX
	 * @param y	 MouseCoordY
	 */
	public void rightClick(int x, int y) {
		rightClick = true; 
		rightClicked_x = x; 
		rightClicked_y = y;
	}

	/** 
	 * Gets set by MouseInputController when the mouse moves
	 * @param x MouseCoordX
	 * @param y MouseCoordY
	 */
	public void mouseMove(int x, int y) {
		mousepos_x = x;
		mousepos_y = y;
	}

	/**
	 * Returns active LevelManager
	 * @return levelManager
	 */
	public LevelManager getLevelManager() {
		return levelManager;
	}

	/**
	 * Gets called when the timer updates
	 */
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
	
	/**
	 * 
	 * @return ballData
	 */
	public BallData getBallData() {
		return ballData;
	}

}
