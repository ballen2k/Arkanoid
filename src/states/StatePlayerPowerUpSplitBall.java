package states;

import java.awt.Color;
import java.io.Serializable;

public class StatePlayerPowerUpSplitBall extends State implements Serializable{

	private Color color;
	
	public StatePlayerPowerUpSplitBall(){
		this.color =Color.yellow;
	}

	public Color getColor() {
		return color;
	}
	
	public void update(model.GameData gameData, model.UserData userData) {
		if(gameData != null && gameData.getBallData() != null)
			gameData.getBallData().splitBalls();
	}
}
