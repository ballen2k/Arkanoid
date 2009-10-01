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
//	private PowerUpData powerUpData;
//	private GunShotData gunShotdata;
	private Timer timer;
	private Random random = new Random();
	private states.State activeState;
	private ArrayList<controller.GameObject> menuList;
	public int points = 0;
	private boolean clicked = false;
	private int clicked_x = 0;
	private int clicked_y = 0;

	private int mousepos_x = 0;
	private int mousepos_y = 0;

	private boolean activeGame = false;

	private LevelManager levelManager;
	private UserData userData;

	public GameData() {
		userData = new UserData(3, 0);

//		setChanged();
//		notifyObservers(userData);

		timer = new Timer(25, this);
		timer.start();
		activeState = new states.StateMenu();

		levelManager = new LevelManager();
		levelManager.loadLevels("fil.f");
/*
		menuList = new ArrayList<controller.GameObject>();
		controller.MenuItem itemStart = new controller.MenuItem(this,
				GameObjectFactory.createPlayState(), "Play!", 180, 180);
		menuList.add(itemStart);

		controller.MenuItem itemChooseLevel = new controller.MenuItem(this,
				GameObjectFactory.createPlayState(), "Choose level", 180, 220);
		menuList.add(itemChooseLevel);
		controller.MenuItem itemSettings = new controller.MenuItem(this,
				GameObjectFactory.createMenuState(), "Settings", 180, 260);
		menuList.add(itemSettings);
		controller.MenuItem itemEditLevel = new controller.MenuItem(this,
				GameObjectFactory.createExitState(), "Create level", 180, 340);
		menuList.add(itemEditLevel);

		controller.MenuItem itemExit = new controller.MenuItem(this,
				GameObjectFactory.createExitState(), "Exit", 180, 300);
		menuList.add(itemExit);
		System.out.println("laddat");
*/
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
