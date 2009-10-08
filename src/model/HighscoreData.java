package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import controller.HighscoreItem;
import controller.Level;
/**
 * Class for managing highscore data
 */
public class HighscoreData {
	ArrayList<controller.HighscoreItem> highscoreList;

	public HighscoreData() {
		highscoreList = new ArrayList<controller.HighscoreItem>();
	}

	/**
	 * Returns a list of highscores
	 * @return highscoreList
	 */
	public ArrayList<controller.HighscoreItem> getHighscore() {
		return highscoreList;
	}

	/**
	 * Adds a new highscore to the list
	 * @param highscoreItem New highcsore
	 */
	public void addHighscore(controller.HighscoreItem highscoreItem) {
		highscoreList.add(highscoreItem);
		controller.HighscoreItem[] itemsArray = new controller.HighscoreItem[highscoreList.size()];

		for(int i = 0; i < highscoreList.size(); i++) {
			itemsArray[i] = highscoreList.get(i);
		}
		
		Arrays.sort(itemsArray);
		
		highscoreList = new ArrayList<controller.HighscoreItem>();
		for(int i = 0; i < itemsArray.length; i++) {
			highscoreList.add(itemsArray[i]);
		}
		
		try {
			File f = new File("highscore.f");
			if (!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream fs = new FileOutputStream("highscore.f");
			ObjectOutputStream ob = new ObjectOutputStream(fs);
			ob.writeObject(highscoreList);
			ob.close();
			fs.close();
		} catch (IOException e) {

		}
	}

	/**
	 * Loads highscore from filename
	 * 
	 * @param filename
	 */
	public void loadHighscore(String filename) {

		try {
			FileInputStream fs = new FileInputStream(filename);
			ObjectInputStream os = new ObjectInputStream(fs);
			highscoreList = (ArrayList<controller.HighscoreItem>) os
					.readObject();
			os.close();
			fs.close();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {

		}
	}
}
