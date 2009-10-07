package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import controller.Level;

public class HighscoreData {
	ArrayList<controller.HighscoreItem> highscoreList;

	public HighscoreData() {
		highscoreList = new ArrayList<controller.HighscoreItem>();
	}

	public ArrayList<controller.HighscoreItem> getHighscore() {
		return highscoreList;
	}

	public void addHighscore(controller.HighscoreItem highscoreItem) {
		highscoreList.add(highscoreItem);

		/*controller.HighscoreItem array[] = new controller.HighscoreItem[highscoreList.size()]; 
		for(int i = 0; i < highscoreList.size(); i++) {
			array[i] = highscoreList.get(i);
		}
		int j = 0;

		for (int i =1;i<highscoreList.size()+1;i++){
			controller.HighscoreItem value = array[i];
			j = i-1;
			while (j>= 0 &&array[j].getPoints()> value.getPoints() ){
				//highscoreList.add(j+1, highscoreList.get(j--));
				controller.HighscoreItem temp = array[j+1];
				
				array[j+1] = array[j];
				array[j] = temp; 
				j--;
			}
			//highscoreList.add(j+1,value);
			controller.HighscoreItem temp = array[j+1];
			array[j+1] = value; 
			value = temp; 
		}
	
		highscoreList = new ArrayList<controller.HighscoreItem>();
		for(int i = 0; i < array.length; i++) {
			highscoreList.add(array[i]);
		}*/
		
		
		controller.HighscoreItem array[] = new controller.HighscoreItem[highscoreList.size()]; 

		//System.out.println(highscoreList.size());
		controller.HighscoreItem array1[] = new controller.HighscoreItem[highscoreList.size()]; 
		for(int i = 0; i < highscoreList.size(); i++) {
			array1[i] = highscoreList.get(i);
		}
		int j = 0;
		//System.out.println(j);
		for (int i = 1;i <array1.length;i++){
			System.out.println(i);
			controller.HighscoreItem  value = array1[i];
			j = i-1;
			while (j>=0 && array1[j].getPoints()> value.getPoints()){
				array[j+1] = array1[j--];
				
			}
			//System.out.println(j);
			array1[j+1] = value;
			//highscoreList.add(j+1, value);
			
			
			}
		highscoreList = new ArrayList<controller.HighscoreItem>();
		for(int i = 0; i < array1.length; i++) {
			highscoreList.add(array1[i]);
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
		System.out.println("Sparar ner highscore, antal: " + highscoreList.size());
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
		
		System.out.println("Laddat highscore, antal: " + highscoreList.size());
	}

}
