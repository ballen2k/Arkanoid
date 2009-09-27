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
	
	public static states.State createMenuState() {
		return new states.StateMenu();
	}
	
	public static states.State createPlayState() {
		return new states.StatePlay();
	}
	
	public static states.State createExitState() {
		return new states.StateExit();
	}
}
