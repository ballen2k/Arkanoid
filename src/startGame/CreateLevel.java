package startGame;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CreateLevel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<controller.GameObject> level = new ArrayList<controller.GameObject>();
		level.add(new controller.Brick(10,10));
		level.add(new controller.Brick(50,50));
		
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
