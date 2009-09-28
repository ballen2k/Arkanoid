package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class StateGameComplete extends State {
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) {
		g.setColor(Color.orange);
		g.drawString("Game Completed =======================|=|>", 180,180);
	}
}
