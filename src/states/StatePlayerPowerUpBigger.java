package states;

import java.awt.Color;
import java.io.Serializable;

public class StatePlayerPowerUpBigger extends State implements Serializable{
	private Color color;
	
	

	public StatePlayerPowerUpBigger(){
		this.color = Color.green;
	}
	
	
	public Color getColor() {
		return color;
	}
	
}
