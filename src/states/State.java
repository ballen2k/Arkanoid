package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class State {
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) { }
	public void update(model.GameData gameData, model.UserData userData) { }
	public void setMouse(int pos_x, int pos_y) { }
	public void setClick(int pos_x, int pos_y) { }
	public void setRightClick(int pos_x, int pos_y)  { }
	public Color getColor(){return Color.gray;}
	public ArrayList<controller.GameObject> getObjects() { 
		return new ArrayList<controller.GameObject>();
	}
}
