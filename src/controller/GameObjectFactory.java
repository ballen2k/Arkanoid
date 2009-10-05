package controller;

public class GameObjectFactory {

	public static GameObject createBrick() {
		return new Brick(0,0);
	}
	
	public static GameObject createPowerUp(states.State powerUp, int x, int y) {
		
		return new PowerUp(powerUp, x, y);
	}
	public static GameObject createGunShot(int x, int y) {
		
		return new GunShot(x, y);
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

	public static states.State createChangeLevelState() {
		return new states.StateChangeLevel();
	}
	
	public static states.State createSaveLevelState() {
		return new states.StateSaveLevel();
	}
	
	public static states.State createLevelEditorState() {
		return new states.StateLevelEditor();
	}
	
	public static states.State createChangeLevelColor(java.awt.Color color) {
		return new states.StateChangeColor(color);
	}
	
	public static states.State createSetPowerUp(states.State powerUp) {
		return new states.StateSetPowerUp(powerUp);
	}
}
