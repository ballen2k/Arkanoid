package model;

import java.util.ArrayList;
import java.util.Random;

import controller.Ball;
import controller.GameObject;

public class BallData {
	private Random random;
	private int rnd;
	private ArrayList<Ball> ballList;
	private GameData gameData;
		public BallData(GameData gameData){
			this.gameData = gameData;
			ballList = new ArrayList<Ball>();
			ballList.add(new Ball(50,150,1,1));
			ballList.add(new Ball(150,150,1,1));
			random = new Random();
			
		}

	
	
	public void doYourStuff() {
		// TODO for every tick from timer, move ball(s) accordingly.
		
		for (Ball ball : ballList){
			ball.setCordinates(
					ball.getX()+(ball.getSlope()*ball.getDirectionX()), 
					ball.getY()+(5*ball.getDirectionY()));
			if (ball.getX()>=480){
				ball.changeDirectionX();
				
			}
			if (ball.getX() <= 0){
				ball.changeDirectionX();
			
				
			}
			if (ball.getY() <= 0){
				ball.changeDirectionY();
			}
			if(ball.getY() >= 480){
				ball.changeDirectionY();
			}
			
			
			if (gameData.getPlayer().intersect(ball)){
				ball.setSlope(random.nextInt(5)+5);
				ball.changeDirectionY();
					
				
			}
		}
		
		
	}



	public ArrayList<Ball> getBallList() {
		return ballList;
	}

}
