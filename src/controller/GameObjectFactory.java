package controller;

public class GameObjectFactory {

	public static GameObject createBrick() {
		return new Brick(0,0);
	}
	
	public static GameObject createPowerUp(states.State powerUp, int x, int y) {
		
		return new PowerUp(powerUp, x, y);
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
	
	public static states.State createStateGameOver() {
		return new states.StateGameOver();
	}
	
	public static states.State createStateGameComplete() {
		return new states.StateGameComplete();
	}
	
	public static states.State createStateLevelComplete() {
		return new states.StateLevelComplete();
	}
	
	public static states.State createExitState() {
		return new states.StateExit();
	}
}
