package states;

import java.awt.*;
import java.util.*;

public class StateExit extends State {
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) {
		System.exit(0);
	}
}
