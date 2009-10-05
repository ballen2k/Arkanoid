package states;

public class StateSaveLevel extends State {

	public void update(model.GameData gameData, model.UserData userData) {
		gameData.getLevelManager().saveTempLevel();
		gameData.changeState(controller.GameObjectFactory.createMenuState());
	}
}
