package states;

import java.awt.Color;
import java.io.Serializable;

public class StatePlayerPowerUpSmaller extends State implements Serializable{

	private Color color;
	
	public StatePlayerPowerUpSmaller(){
		this.color = Color.blue;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void update(model.GameData gameData, model.UserData userData) {
		userData.getPlayer().setActiveState(this);
	}
}
