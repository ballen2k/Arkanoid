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
		level.add(new controller.Brick(10,10));
		level.add(new controller.Brick(50,50));
	
		for(int i = 0; i < 5; i++) {
			level.add(new controller.Brick(i*60, 10));
		}
		
		Wall left = new Wall(-10, 0, 20, 480);
		Wall right = new Wall(475, 0, 10, 480);
		Wall up = new Wall(0,-10,480,20);
		Wall down = new Wall(0,200,200,10);

		level.add(left);
		level.add(right);
		level.add(up);
		level.add(down);
		
		try {
			FileOutputStream fs = new FileOutputStream("fil.f");
			ObjectOutputStream ob = new ObjectOutputStream(fs);
			ob.writeObject(level);
			ob.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
