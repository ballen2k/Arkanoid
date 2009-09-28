package states;

import controller.GameObjectFactory;

public class StateChangeLevel extends State {
	public void update(model.GameData gameData, model.UserData userData) {
		if (gameData.getLevelManager().nextLevel() != null)
			gameData.changeState(GameObjectFactory.createPlayState());
		else 
			gameData.changeState(GameObjectFactory.createStateGameComplete());
	}
}
