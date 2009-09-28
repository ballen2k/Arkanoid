package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class LevelManager implements Serializable {
	private ArrayList<Level> levelList;
	private Level activeLevel;

	public LevelManager() {
		levelList = new ArrayList<Level>();
		activeLevel = null;
	}

	public void loadLevels(String filename) {
		
		try {
			FileInputStream fs = new FileInputStream(filename);
			ObjectInputStream os = new ObjectInputStream(fs);
			levelList = (ArrayList<Level>)os.readObject();
			os.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
