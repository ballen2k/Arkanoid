package states;

import java.applet.AudioClip;
import java.awt.*;
import java.util.*;
import java.math.*;
import java.lang.Math;

import controller.AePlayWave;
import controller.GameObject;

public class StatePlay extends State {
	private boolean activeGame = false;
	private model.GameData gameData;
	private model.LevelData levelData;
	private model.BallData ballData;
	private model.PowerUpData powerUpData;
	private model.UserData userData;
	private model.GunShotData gunShotData;
	private controller.Explosion explosion;
	private int mousepos_x, mousepos_y;
	private int clicked_x, clicked_y;
	private boolean clicked = false;

	private ArrayList<controller.GameObject> result;

	public void draw(Graphics g, ArrayList<controller.GameObject> objectList,
			model.UserData userData) {
		if (explosion != null) {
			explosion.update(g);
		}
		
		g.setColor(Color.green);
		for (GameObject go : objectList) {
			go.draw(g);
		}

		Font font = new Font("Serif", Font.BOLD, 12);
		g.setFont(font);
		g.setColor(Color.orange);
		g.drawString("Lives: " + Integer.toString(userData.getNumberOfLifes()),
				0, 460);
		g.drawString("Points: " + Integer.toString(userData.getPoints()), 410,
				460);

		userData.getPlayer().draw(g);

	}
	
	public void movePlayer() {
		if(userData != null) 
			userData.getPlayer().setCoordinates(mousepos_x - (int) (userData.getPlayer().getBounds().getWidth() / 2), 123);
	}
	

	private void addExplosion(GameObject ob) {
		explosion = new controller.Explosion((int) ob.getBounds().getCenterX(), (int) ob.getBounds()
												.getCenterY(), ob.getColor());
	}
	
	private void addBounceSound() {
		new AePlayWave("img\\bounce.wav").start();
	}

	public void setMouse(int pos_x, int pos_y) {
		this.mousepos_x = pos_x;
		this.mousepos_y = pos_y;
	}

	public void setClick(int pos_x, int pos_y) {
		this.clicked_x = pos_x;
		this.clicked_y = pos_y;
		this.clicked = true;
	}

	public void update(model.GameData gameData, model.UserData userData) {
		if (!activeGame) {
			//levelData = gameData.getLevelData();
			ballData = gameData.getBallData();
			activeGame = true;
			powerUpData = gameData.getPowerUpData();
			gunShotData = gameData.getGunShotData();
		}

		if (!gameData.getActiveGame()) {
			this.gameData = gameData;
			gameData.setActiveGame(true);
			levelData = new model.LevelData();
			gameData.getLevelManager().loadLevels();
		}
		
		this.userData = userData; 
		controller.Player player = this.userData.getPlayer();
		ArrayList<controller.GameObject> ballList = ballData.getBallList();
		ArrayList<controller.GameObject> objects;
		controller.Level level = gameData.getLevelManager().getActiveLevel();

		
		if (level == null) {
			gameData.changeState(controller.GameObjectFactory.createStateGameComplete());
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
			gameData.changeState(controller.GameObjectFactory.createChangeLevelState());
			return;
		}

		// Move all the balls
		if (clicked) {
			ballData.activateBall();
		}
		
		ballData.update(gameData, userData, objects);

		// Move the player
		movePlayer(); 

		
		/*
		 * Move the powerUps
		 */
		powerUpData.update(gameData, userData);
		
		/*
		 * Moves the gunshots.
		 */
		if(clicked) {
			gunShotData.setClick(clicked_x, clicked_y);
		}
		gunShotData.update(gameData, userData, objects);

		clicked = false;
		
		
		result = new ArrayList<controller.GameObject>();
		for (controller.GameObject object : objects) {
			result.add(object);
		}
		for (controller.GameObject balls : ballList) {
			result.add(balls);
		}
		for (controller.GameObject powerUp : powerUpData.getPowerUpList()) {
			result.add(powerUp);
		}
		for (controller.GameObject gunShot : gunShotData.getGunShotList()) {
			result.add(gunShot);
		}

	}

	public ArrayList<controller.GameObject> getObjects() {
		return result;
	}
}
