package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class State {
	/** 
	 * @param g Graphics-object that will be used to paint 
	 * @param objectList List of objects that will be painted
	 * @param userData Userdata to get score, life etc
	 */
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) { }
	
	/**
	 * @param gameData Gamedata-instance to be able to retrieve info about the game
	 * @param userData Userdata to get score, life etc
	 */
	public void update(model.GameData gameData, model.UserData userData) { }
	
	/**
	 * @param pos_x X-position
	 * @param pos_y Y-position 
	 */
	public void setMouse(int pos_x, int pos_y) { }
	
	/**
	 * @param pos_x X-position
	 * @param pos_y Y-position 
	 */
	public void setClick(int pos_x, int pos_y) { }
	
	/**
	 * @param pos_x X-position
	 * @param pos_y Y-position 
	 */
	public void setRightClick(int pos_x, int pos_y)  { }
	public Color getColor(){return Color.gray;}
	
	/**
	 * @return Returns the object that the state wants the game to paint
	 */
	public ArrayList<controller.GameObject> getObjects() { 
		return new ArrayList<controller.GameObject>();
	}

}
