package controller;

public class GameObjectFactory {

	public static GameObject createBrick() {
		return new Brick(0,0);
	}
	
	public static GameObject createPowerUp() {
		return new PowerUp();
	}
	
	public static GameObject createBall(int x, int y, int directionX, int directionY) {
		return new Ball(x,y,directionX,directionY);
	}
	
	
	
	
}
