package states;

import java.awt.Graphics;
import java.util.ArrayList;

public class State {
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) { }
	public void update(model.GameData gameData) { }
	public void setMouse(int pos_x, int pos_y) { }
	public void setClick(int pos_x, int pos_y) { }
	public ArrayList<controller.GameObject> getObjects() { 
		return new ArrayList<controller.GameObject>();
	}
}
