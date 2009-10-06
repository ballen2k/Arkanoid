package states;

import java.awt.Color;
import java.io.Serializable;

public class StatePlayerPowerUpGun extends State implements Serializable{
	private Color color;
	 
	public StatePlayerPowerUpGun(){
		this.color = Color.RED;
		
	}
	
	public Color getColor() {
		return color;
	}
	
	
	
}
