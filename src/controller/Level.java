package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/*
 * class for using and drawing the level
 */
public class Level {
	private ArrayList<GameObject> level;
	private GameObject brick;
	
	public Level() {
		this.level = new ArrayList<GameObject>();
	}

	public ArrayList<GameObject> getLevel() {
		return level;
	}
	
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
