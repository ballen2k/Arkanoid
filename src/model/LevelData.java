package model;

import java.util.ArrayList;

/*/
 * Class containing the levels, and methods for changing, adding and removing levels
 */

public class LevelData {

	private ArrayList<controller.Level> levelList;
	private controller.Level currentLevel;
	private int whichLevel = 0;
	
	
	public LevelData() {
	levelList = new ArrayList<controller.Level>();
	levelList.add(new controller.Level());
	currentLevel = levelList.get(whichLevel);
	}
	
	public void getLevelsFromFile(){
		
	/* todo
	 * Reads a file containing the levels
	 *  levelList = läs in filen med levels;
	 *  
	 */
		
	}
	public void setNextLevel(int i){
		whichLevel = whichLevel +1;
		if (levelList.get(whichLevel)!= null){
			currentLevel = levelList.get(whichLevel);
		}
	}

	public controller.Level getCurrentLevel() {
		return currentLevel;
	}
	
	
	
}
