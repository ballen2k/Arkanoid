package startGame;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import controller.Wall;

public class CreateLevel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<controller.GameObject> level = new ArrayList<controller.GameObject>();
		ArrayList<controller.GameObject> level2 = new ArrayList<controller.GameObject>();
		level2.add(new controller.Brick(180,180));
		
		for (int j = 1; j < 6; j++) {
			for (int i = 0; i < 12; i++) {
				level.add(new controller.Brick(i * 40, 20*j));
			}
		}

		Wall left = new Wall(-10, 0, 20, 480);
		Wall right = new Wall(475, 0, 10, 480);
		Wall up = new Wall(0, -10, 480, 20);
//		Wall down = new Wall(0, 200, 200, 10);

		level.add(left);
		level.add(right);
		level.add(up);
//		level.add(down);
		
		level2.add(left);
		level2.add(right);
		level2.add(up);
		
		ArrayList<controller.Level> levelList = new ArrayList<controller.Level>();
		levelList.add(new controller.Level(level2));
		levelList.add(new controller.Level(level));
		try {
			FileOutputStream fs = new FileOutputStream("fil.f");
			ObjectOutputStream ob = new ObjectOutputStream(fs);
			ob.writeObject(levelList);
			ob.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}