package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import controller.AePlayWave;
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
		GameObject ball = GameObjectFactory.createBall(x, y, directionX, directionY);
		ball.setMoving();
		ballList.add(ball);
	}
	
	public void addBall() {
		ballList.add(GameObjectFactory.createBall(0, 0, 1, -1));
	}


	/**
	 * @return Returns a list of the balls
	 */
	public ArrayList<GameObject> getBallList() {
		return ballList;
	}
	
	/**
	 * Splits the balls
	 */
	public void splitBalls() {
		ArrayList<GameObject> temp = new ArrayList<GameObject>();
		for (GameObject ball : ballList) {
			temp.add(controller.GameObjectFactory
					.createBall(ball.getX(), ball.getY(), ball
							.getDirectionX(), ball.getDirectionY() * -1));
		}
		
		for (GameObject ball : temp) {
			addBall(ball.getX(), ball.getY(), ball
					.getDirectionX(), ball.getDirectionY());
		}
	}
	
	/**
	 * Activate all the balls so they start moving
	 */
	public void activateBall() {
		for(controller.GameObject ball : ballList) {
			if(!ball.isMoving()) {
				ball.setMoving();
			}
		}
	}

	/**
	 * Updates the balls
	 */
	public void update(GameData gameData, UserData userData, ArrayList<GameObject> objects) {
		GameObject player = userData.getPlayer();
		if (ballList.isEmpty()) {
			if (userData.getNumberOfLifes() > 0) {
				userData.decreaseNumberOfLifes();
				userData.getPlayer().setActiveState(new states.StatePlayerNormal());
			}
			if (userData.getNumberOfLifes() == 0) {
				gameData.setActiveGame(false);;
				gameData.changeState(controller.GameObjectFactory.createStateGameOver());
			} else {
				addBall();
			}
		}

		
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
		
		for (Iterator<controller.GameObject> itB = ballList.iterator(); itB.hasNext();) {
			controller.GameObject b = itB.next();

			if (b.getBounds().getY() >= player.getBounds().getY()) {
				// Ball is under the player
				itB.remove();
				continue;
			}

			// Loops through all the objects and check if there is a collision with the ball
			for (Iterator<controller.GameObject> it = objects.iterator(); it.hasNext(); ) {
				controller.GameObject ob = it.next();
				if (b.intersect(ob)) {
					
					// Notifies the object that it is hit
					ob.hit(b);
					
					// 
					if (b.intersectLeft(ob) || b.intersectRight(ob)) {
						b.changeDirectionX();
					} else {
						b.changeDirectionY();
					}
					
					
					if (ob.isDead()) {
						new AePlayWave("img\\exp.wav").start();
						if (ob.hasPowerUp()) {
							gameData.getPowerUpData().addPowerUp(ob.getPowerUp(), ob.getX(),
									ob.getY());
						}
						
						// Creates an explosion where the brick was
						//addExplosion(ob);

						userData.increasePoints(100);
						it.remove();
					} else {
						//addBounceSound();
					}
					break;
				}

			}

			if (b.intersect(player)) {
				
				// Special case when the balls hit the player far to the left or
				// right.
				if (b.getX() + b.getWidth() / 2 < player.getX() || b.getX() + b.getWidth() / 2 > player.getX() + player.getWidth()) {
					b.setSlope(b.getMAX_SLOPE());
					b.changeDirectionY();
				} else {
					b.changeDirectionY();
					b.setSlope((int) ((double) Math.abs((b.getX() + b.getWidth() / 2) - (player.getX() + player.getWidth() / 2))
							/ (player.getWidth() / 2) * b.getMAX_SLOPE()) + 1);
				}
			}
		}

	}
}
