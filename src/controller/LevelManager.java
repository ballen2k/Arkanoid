package controller;

import java.io.File;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
/**
 * Handles all the levels. Loads levels from file and saves to file.
 *
 */
public class LevelManager implements Serializable {
	private ArrayList<Level> levelList;
	private Level activeLevel;
	private Level tempLevel;
	private Color tempColor = Color.red;
	private states.State powerUp;

	public LevelManager() {
		levelList = new ArrayList<Level>();
		activeLevel = null;
	}
	
	/** 
	 * Set temporary level, used in leveleditor
	 * @param level
	 */
	public void setTempLevel(Level level) {
		tempLevel = level;
	}
	
	/** 
	 * Get temporary level, used in leveleditor
	 * @return
	 */
	public Level getTempLevel() {
		return tempLevel;
	}
	
	/**
	 * Set active color
	 * @param color
	 */
	public void setColor(Color color) {
		this.tempColor = color;
	}
	
	/**
	 * Get active color
	 * @return color
	 */
	public Color getColor() {
		return this.tempColor;
	}
	
	/** 
	 * Set temporary powerup, used by leveleditor
	 * @param powerup
	 */
	public void setPowerUp(states.State powerup) {
		this.powerUp = powerup;
	}
	
	/**
	 * 
	 * @return powerup
	 */
	public states.State getPowerUp() {
		return this.powerUp;
	}
	
	/** 
	 * Save temporary level to file
	 */
	public void saveTempLevel() {
		levelList.add(tempLevel);
		

		try {
			File f = new File("fil.f");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream fs = new FileOutputStream("fil.f");
			ObjectOutputStream ob = new ObjectOutputStream(fs);
			ob.writeObject(levelList);
			ob.close();
			fs.close();
		} catch (IOException e) {
			
		}
		tempLevel = null;
	}

	/**
	 * Loads levels from "fil.f"
	 */
	public void loadLevels() {
		loadLevels("fil.f");
	}

	/**
	 * Loads levels from filename
	 * @param filename
	 */
	public void loadLevels(String filename)  {
		
		try {
			FileInputStream fs = new FileInputStream(filename);
			ObjectInputStream os = new ObjectInputStream(fs);
			levelList = (ArrayList<Level>)os.readObject();
			os.close();
			fs.close();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
		}
	}	

	/**
	 * Add level to list
	 * @param level
	 */
	public void addLevel(Level level) {
		levelList.add(level);
	}

	/** 
	 * Returns active level
	 * @return level
	 */
	public Level getActiveLevel() {
		if (activeLevel == null) {
			if (!levelList.isEmpty()) {
				activeLevel = levelList.get(0);
				levelList.remove(0);
			} else {
				return null;
			}
		}

		return activeLevel;
	}

	/**
	 * Changes to next level
	 * @return next level
	 */
	public Level nextLevel() {
		if(!levelList.isEmpty()) {
			activeLevel = levelList.get(0);
			levelList.remove(0);
		} else {
			return null; 
		}
		
		return activeLevel;
	}
}
