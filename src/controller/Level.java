package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.*;

/**
 * Class for using and drawing the level
 */
public class Level implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<GameObject> level;
	private Color color;
	
	public Level() {
		this.level = new ArrayList<GameObject>();
	}
	
	public Level(ArrayList<GameObject> objects) {
		this.level = objects;
	}

	/**
	 * 
	 * @return Returns the level list
	 */
	public ArrayList<GameObject> getLevel() {
		return level;
	}
	
	/** 
	 * Set color to use when adding bricks
	 * @param color Specifies which color to use
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/** 
	 * 
	 * @return Returns the active color
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Load level from file
	 * @param filename 
	 */
	public void loadLevel(String filename){
		
		try {
			FileInputStream fs = new FileInputStream(filename);
			ObjectInputStream os = new ObjectInputStream(fs);
			this.level = (ArrayList<GameObject>)os.readObject();
			os.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
