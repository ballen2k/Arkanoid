package states;

import java.awt.Color;
import java.io.Serializable;

public class StatePlayerPowerUpExtraLife extends State implements Serializable{
private Color color;
	
	
	public StatePlayerPowerUpExtraLife(){
		this.color = Color.cyan;
	}


	public Color getColor() {
		return color;
	}
	
	public void update(model.GameData gameData, model.UserData userData) {
		userData.increaseNumberOfLifes();
	}
}
