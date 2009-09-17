package controller;

public class GameObjectFactory {

	public static GameObject createBrick() {
		return new Brick();
	}
	
	public static GameObject createPowerUp() {
		return new PowerUp();
	}
	
	
	
	
}
