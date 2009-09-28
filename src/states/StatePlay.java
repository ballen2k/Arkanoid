package states;

import java.awt.Color;
import java.awt.*;
import java.util.*;

import controller.GameObject;

public class StatePlay extends State {
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) {
		g.setColor(Color.green);
		for (GameObject go : objectList) {
			go.draw(g);
		}

		g.setColor(Color.black);
		g.fillRect(0, 445, 1000, 200);
		g.setColor(Color.green);
		g.drawLine(0, 445, 500, 445);
		g.drawString("Lives: "
				+ Integer.toString(userData.getNumberOfLifes()), 50,
				460);
		g.drawString("Points: "
				+ Integer.toString(userData.getPoints()), 150, 460);

		userData.getPlayer().draw(g);

	}
}
