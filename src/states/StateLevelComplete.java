package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

import controller.GameObjectFactory;

public class StateLevelComplete extends State {
	ArrayList<controller.GameObject> menuList;
	private int mousepos_x, mousepos_y;
	private int clicked_x, clicked_y;
	private boolean clicked = false;
	
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) {
		g.setColor(Color.orange);
		g.drawString("Level is complete!", 180, 180);
		
		for(controller.GameObject ob :objectList) {
			ob.draw(g);
		}
	}
	
	public void update(model.GameData gameData, model.UserData userData) {

		menuList = new ArrayList<controller.GameObject>();
		controller.MenuItem itemNextLevel = new controller.MenuItem(gameData,
				GameObjectFactory.createChangeLevelState(), "Continue", 180, 220);
		menuList.add(itemNextLevel);
		controller.MenuItem itemGoMenu  = new controller.MenuItem(gameData,
				GameObjectFactory.createMenuState(), "Back to menu", 180,
				260);
		menuList.add(itemGoMenu);
		

		for (controller.GameObject mi : menuList) {
			if (mi.getBounds().contains(new Point(mousepos_x, mousepos_y))) {
				mi.setActive();
			} else {
				mi.setNonActive();
			}
		}

		if (clicked) {
			for (controller.GameObject mi : menuList) {
				if (mi.getBounds()
						.contains(new Point(clicked_x, clicked_y))) {
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
}
