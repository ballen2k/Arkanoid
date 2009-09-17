package model;

import java.util.ArrayList;

import controller.Ball;
import controller.GameObject;

public class BallData {
	
	private int x;
	private int y;
	private int directionX = 1;
	private int directionY =1;
	private ArrayList<Ball> ballList;
	private GameData gameData;
		public BallData(GameData gameData){
			this.gameData = gameData;
			ballList = new ArrayList<Ball>();
			ballList.add(new Ball(50,50));
			
		}

	
	
	public void doYourStuff() {
		// TODO for every tick from timer, move ball(s) accordingly.
		
		for (GameObject go : ballList){
			go.setCordinates(go.getX()+(5*directionX), go.getY()+(5*directionY));
			if (go.getX()>=480){
				directionX = -1;
			}
			if (go.getX() <= 0){
				directionX = 1;
				
			}
			if (go.getY() <= 0){
				directionY = 1;
			}
			if(go.getY() >= 480){
				directionY = -1;
			}
			
			
			if (gameData.getPlayer().intersect(go.getX(), go.getY())){
				System.out.println("INTERSECT");
				directionY = -1;
					
				
			}
		}
		
		
	}



	public ArrayList<Ball> getBallList() {
		return ballList;
	}

}
