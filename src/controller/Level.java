package controller;

import java.util.ArrayList;

/*
 * class for using and drawing the level
 */
public class Level {
	private ArrayList<GameObject> level;
	private GameObject brick;
	
	public Level() {
		this.level = new ArrayList<GameObject>();
		for (int i = 10; i <450; i = i+36){
			brick = GameObjectFactory.createBrick();
			brick.setCordinates(i, 10);
			level.add(brick);
		}
			for (int i = 10; i <450; i = i+36){
				brick = GameObjectFactory.createBrick();
				brick.setCordinates(i, 26);
				level.add(brick);
		}
			for (int i = 10; i <450; i = i+36){
				brick = GameObjectFactory.createBrick();
				brick.setCordinates(i, 42);
				level.add(brick);
		}
		
		
	}

	public ArrayList<GameObject> getLevel() {
		return level;
	}



	
	
	
	
	
}
