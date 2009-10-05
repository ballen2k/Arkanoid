package states;
import java.awt.*;

public class StateChangeColor extends State {
	private Color color;
	
	public StateChangeColor(Color color) {
		this.color = color;
	}
	
	public void update(model.GameData gameData, model.UserData userData) {
		gameData.getLevelManager().setColor(color);
		gameData.changeState(controller.GameObjectFactory.createLevelEditorState());
	}
}
