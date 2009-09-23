package model;

import java.util.ArrayList;
import java.util.Random;

import controller.Ball;
import controller.GameObject;
import controller.GameObjectFactory;

public class BallData {

	private ArrayList<GameObject> ballList;
	private GameData gameData;
		public BallData(GameData gameData){
			this.gameData = gameData;
			ballList = new ArrayList<GameObject>();
			ballList.add(GameObjectFactory.createBall(50,150,1,1));
	
			
			
		}

	
	
	public void doYourStuff() {
		// TODO for every tick from timer, move ball(s) accordingly.
		
		
		
		
	}

	public void addBall(int x, int y, int directionX,int directionY){
		ballList.add(GameObjectFactory.createBall(x,y,directionX,directionY));
	}

	public ArrayList<GameObject> getBallList() {
		return ballList;
	}

}
