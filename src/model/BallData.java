package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import controller.Ball;
import controller.GameObject;
import controller.GameObjectFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import controller.Ball;
import controller.GameObject;
import controller.GameObjectFactory;
/**
 * Model object that takes care of all the
 * balls in the game. 
 */
public class BallData {

	private ArrayList<GameObject> ballList;
	private GameData gameData;

	/**
	 * @param gameData Information about the game
	 */
	public BallData(GameData gameData) {
		this.gameData = gameData;
		ballList = new ArrayList<GameObject>();
		ballList.add(GameObjectFactory.createBall(50, 150, 1, 1));
	}

	/**
	 * Adds a new ball to the game 
	 * @param x X-position
	 * @param y Y-position
	 * @param directionX Velocity in X
	 * @param directionY Velocity in Y
	 */
	public void addBall(int x, int y, int directionX, int directionY) {
		ballList.add(GameObjectFactory.createBall(x, y, directionX, directionY));
	}

	/**
	 * @return Returns a list of the balls
	 */
	public ArrayList<GameObject> getBallList() {
		return ballList;
	}
	
	/**
	 * Activate all the balls so they start moving
	 */
	public void activateBall() {
		for(controller.GameObject ball : ballList) {
			ball.setMoving();
		}
	}

	/**
	 * Updates the balls
	 */
	public void update() {
		for (Iterator<controller.GameObject> it = ballList.iterator(); it.hasNext();) {
			controller.GameObject ball = it.next();
			
			if(ball.isMoving()) {
				ball.setCoordinates(ball.getX()
					+ (ball.getSlope() * ball.getDirectionX()), ball.getY()
					+ (5 * ball.getDirectionY()));
			} else {
				ball.setCoordinates((int)gameData.getPlayer().getBounds().getX()+20, 
				(int)gameData.getPlayer().getBounds().getY()-20);
			}
		}
	}
}
