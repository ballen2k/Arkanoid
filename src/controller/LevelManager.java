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
	
	public void setTempLevel(Level level) {
		tempLevel = level;
	}
	
	public Level getTempLevel() {
		return tempLevel;
	}
	
	public void setColor(Color color) {
		this.tempColor = color;
	}
	
	public Color getColor() {
		return this.tempColor;
	}
	
	public void setPowerUp(states.State powerup) {
		this.powerUp = powerup;
	}
	
	public states.State getPowerUp() {
		return this.powerUp;
	}
	
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

	public void loadLevels() {
		loadLevels("fil.f");
	}
	
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

	
	public void addLevel(Level level) {
		levelList.add(level);
	}

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
