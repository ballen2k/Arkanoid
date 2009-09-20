package controller;

public class GameObjectFactory {

	public static GameObject createBrick() {
		return new Brick();
	}
	
	public static GameObject createPowerUp() {
		return new PowerUp();
	}
	
	public static GameObject createBall(int x, int y, int directionY, int directionX) {
		return new Ball(x,y,directionX,directionY);
	}
	
	
	
	
}
