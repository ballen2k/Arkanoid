package states;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

public class StateGameComplete extends State {
	private ArrayList<controller.GameObject> menuList;
	private int mousepos_x, mousepos_y;
	private int clicked_x, clicked_y;
	private boolean clicked = false;

	public void update(model.GameData gameData, model.UserData userData) {
		//gameData.getLevelManager().loadLevels();
		gameData.setActiveGame(false);

		menuList = new ArrayList<controller.GameObject>();
		controller.MenuItem itemStart = new controller.MenuItem(gameData,
				controller.GameObjectFactory.createMenuState(), "Main menu",
				180, 220);
		menuList.add(itemStart);

		for (controller.GameObject mi : menuList) {
			if (mi.getBounds().contains(new Point(mousepos_x, mousepos_y))) {
				mi.setActive();
			} else {
				mi.setNonActive();
			}
		}

		if (clicked) {
			for (controller.GameObject mi : menuList) {
				if (mi.getBounds().contains(new Point(clicked_x, clicked_y))) {
					mi.pushed();
				}
			}
		}
		clicked = false;

	}

	public void setMouse(int pos_x, int pos_y) {
		this.mousepos_x = pos_x;
		this.mousepos_y = pos_y;
	}

	public void setClick(int pos_x, int pos_y) {
		this.clicked_x = pos_x;
		this.clicked_y = pos_y;
		this.clicked = true;
	}

	public ArrayList<controller.GameObject> getObjects() {
		return menuList;
	}

	public void draw(Graphics g, ArrayList<controller.GameObject> objectList,
			model.UserData userData) {
		g.setColor(Color.orange);
		g.drawString("Game Completed =======================|=|>", 180, 180);

		for (controller.GameObject o : objectList) {
			o.draw(g);
		}
	}
}
