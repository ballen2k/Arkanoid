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
	private PowerUpData powerUpData;
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

		setChanged();
		notifyObservers(userData);

		timer = new Timer(25, this);
		timer.start();
		activeState = new states.StateMenu();

		levelManager = new LevelManager();
		levelManager.loadLevels("fil.f");

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

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (activeState instanceof states.StateLevelComplete) {
			controller.Level level = levelManager.nextLevel();
			if (level == null) {
				changeState(new states.StateGameComplete());
			} else {
				changeState(new states.StatePlay());
			}
		} else if (activeState instanceof states.StatePlay) {
			// Start new game =)
			if (!activeGame) {
				levelData = new LevelData();
				ballData = new BallData(this);
				activeGame = true;

				userData = new UserData(3, 0);

				setChanged();
				notifyObservers(userData);
			}

			Player player = userData.getPlayer();
			ArrayList<controller.GameObject> ballList = ballData.getBallList();
			ArrayList<controller.GameObject> objects;
			controller.Level level = levelManager.getActiveLevel();

			if (level == null) {
				changeState(GameObjectFactory.createStateGameComplete());
				return;
			}
			objects = level.getLevel();

			// Check if level is complete =)
			boolean complete = true;
			for (controller.GameObject ob : objects) {
				if (ob.isRemovable() == true) {
					complete = false;
					break;
				}
			}
			if (complete) {
				changeState(GameObjectFactory.createStateLevelComplete());
				return;
			}

			// Move all the balls
			ballData.update();

			// Move the player
			userData.getPlayer().setCoordinates(mousepos_x - 25, 123);
			setChanged();
			notifyObservers(userData);

			// Check if one of the balls have hit a brick and handle it
			// appropriately
			for (Iterator<controller.GameObject> itB = ballList.iterator(); itB
					.hasNext();) {
				controller.GameObject b = itB.next();

				if (b.getBounds().getY() >= player.getBounds().getMaxY()) {
					// Ball is under the player
					itB.remove();
					continue;
				}

				for (Iterator<controller.GameObject> it = objects.iterator(); it
						.hasNext();) {
					controller.GameObject ob = it.next();
					if (b.intersect(ob)) {
						ob.hit(b);

						if (b.intersectLeft(ob)) {
							// b.setSlope(random.nextInt(5) + 5);
							b.changeDirectionX();
						} else if (b.intersectRight(ob)) {
							// b.setSlope(random.nextInt(5) + 5);
							b.changeDirectionX();
						} else {
							// b.setSlope(random.nextInt(5) + 5);
							b.changeDirectionY();
						}

						if (ob.isDead()) {
							it.remove();
							userData.increasePoints(100);
						}
					}
				}

				if (b.intersect(player)) {
					if (b.intersectLeft(player)) {
						b.changeDirectionX();
					} else if (b.intersectRight(player)) {
						b.changeDirectionX();
					} else {
						// b.setSlope(random.nextInt(5) + 5);
						b.changeDirectionY();
					}
				}
			}

			if (ballList.isEmpty()) {
				if (userData.getNumberOfLifes() > 0) {
					userData.decreaseNumberOfLifes();
					setChanged();
					notifyObservers(userData);
				}
				if (userData.getNumberOfLifes() == 0) {
					System.out.println("GAME OVER NOOB");
					activeGame = false;
					this.changeState(GameObjectFactory.createStateGameOver());
				} else {
					ballData.addBall(player.getX() + 25, player.getY()
							- controller.Ball.BALL_HEIGHT, 1, -1);
				}
			}

			ArrayList<controller.GameObject> result = new ArrayList<controller.GameObject>();
			for (controller.GameObject object : objects) {
				result.add(object);
			}
			for (controller.GameObject balls : ballList) {
				result.add(balls);
			}
			setChanged();
			notifyObservers(result);
		} else {
			if (clicked) {
				activeState.setClick(clicked_x, clicked_y);
			}
			activeState.setMouse(mousepos_x, mousepos_y);
			activeState.update(this);
			setChanged();
			notifyObservers(activeState.getObjects());
		}

	}

	public BallData getBallData() {
		return ballData;
	}

}
