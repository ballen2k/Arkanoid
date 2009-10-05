package states;


public class StateSetPowerUp extends State {
	private State powerUp;
	
	public StateSetPowerUp(State powerUp) {
		this.powerUp = powerUp;
	}
	
	public void update(model.GameData gameData, model.UserData userData) {
		gameData.getLevelManager().setPowerUp(powerUp);
		gameData.changeState(controller.GameObjectFactory.createLevelEditorState());
	}
	
}
