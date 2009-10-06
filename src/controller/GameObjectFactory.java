package controller;

/**
 * This is the Factory class for all the GameObjects.
 * 
 * @author Jeremia
 * 
 */
public class GameObjectFactory {

	/**
	 * Returns a new brick.
	 * 
	 * @return Brick
	 */
	public static GameObject createBrick() {
		return new Brick(0, 0);
	}

	/**
	 * Returns a new powerUp
	 * 
	 * @param powerUp
	 *            Which type of powerUp this this should be.
	 * @param x
	 *            The X coordinate where the powerUp should be spawned
	 * @param y
	 *            The Y coordinate where the powerUp should be spawned
	 * @return PowerUp
	 */
	public static GameObject createPowerUp(states.State powerUp, int x, int y) {

		return new PowerUp(powerUp, x, y);
	}

	/**
	 * Creates a new gunshot
	 * 
	 * @param x
	 *            The X coordinate where the gunShot should be spawned
	 * @param y
	 *            The Y coordinate where the gunShot should be spawned
	 * @return GunShot
	 */
	public static GameObject createGunShot(int x, int y) {

		return new GunShot(x, y);
	}

	/**
	 * Creates a new shiny ball
	 * 
	 * @param x
	 *            The X coordinate where the gunShot should be spawned
	 * @param y
	 *            The Y coordinate where the gunShot should be spawned
	 * @param directionX
	 *            The left/right direction of the ball.
	 * @param directionY
	 *            The up/down direction of the ball.
	 * @return Ball
	 */
	public static GameObject createBall(int x, int y, int directionX,
			int directionY) {
		return new Ball(x, y, directionX, directionY);
	}

	/**
	 * Creates a MenuState
	 * 
	 * @return StateMenu
	 */
	public static states.State createMenuState() {
		return new states.StateMenu();
	}

	/**
	 * Creates a PlayState
	 * 
	 * @return StatePlay
	 */
	public static states.State createPlayState() {
		return new states.StatePlay();
	}

	/**
	 * Creates a GameOver state
	 * 
	 * @return StateGameOver
	 */
	public static states.State createStateGameOver() {
		return new states.StateGameOver();
	}

	/**
	 * Creates a GameComplete state
	 * 
	 * @return StateGameComplete
	 */
	public static states.State createStateGameComplete() {
		return new states.StateGameComplete();
	}

	/**
	 * Creates a LevelComplete state
	 * 
	 * @return StateLevelComplete
	 */
	public static states.State createStateLevelComplete() {
		return new states.StateLevelComplete();
	}

	/**
	 * Creates an Exit state
	 * 
	 * @return StateExit.
	 */
	public static states.State createExitState() {
		return new states.StateExit();
	}

	/**
	 * Creates a ChangeLevel state
	 * @return StateChangeLevel
	 */
	public static states.State createChangeLevelState() {
		return new states.StateChangeLevel();
	}
	
/**
 * Creates a SaveLevel state
 * @return StateSaveLevel
 */
	public static states.State createSaveLevelState() {
		return new states.StateSaveLevel();
	}
/**
 * Creates a LevelEditor state
 * @return StateLevelEditor
 */
	public static states.State createLevelEditorState() {
		return new states.StateLevelEditor();
	}
/**
 * Creates a ChangeLevelColor state
 * @param color Color
 * @return StateChangeColor
 */
	public static states.State createChangeLevelColor(java.awt.Color color) {
		return new states.StateChangeColor(color);
	}
/**
 * Creates a SetPowerUp State
 * @param State
 * @return StateSetPowerUp
 */
	public static states.State createSetPowerUp(states.State powerUp) {
		return new states.StateSetPowerUp(powerUp);
	}
}
