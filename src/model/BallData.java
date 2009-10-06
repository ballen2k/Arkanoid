package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import controller.Ball;
import controller.GameObject;
import controller.GameObjectFactory;

public class BallData {

	private ArrayList<GameObject> ballList;
	private GameData gameData;

	public BallData(GameData gameData) {
		this.gameData = gameData;
		ballList = new ArrayList<GameObject>();
		ballList.add(GameObjectFactory.createBall(50, 150, 1, 1));
	}

	public void addBall(int x, int y, int directionX, int directionY) {
		ballList.add(GameObjectFactory.createBall(x, y, directionX, directionY));
	}

	public ArrayList<GameObject> getBallList() {
		return ballList;
	}
	
	
	public void activateBall() {
		for(controller.GameObject ball : ballList) {
			ball.setMoving();
		}
	}

	
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

			/*
			// Right
			if (ball.getX() >= 480) {
				ball.changeDirectionX();

			}
			 
			// Left
			if (ball.getX() <= 0) {
				ball.changeDirectionX();

			}
			
			// Up
			if (ball.getY() <= 0) {
				ball.changeDirectionY();
			}
			
			// Down
			if (ball.getY() >= 480) {
				it.remove();
			}	
			*/
		}
	}
}
