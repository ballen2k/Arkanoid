package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import controller.GameObjectFactory;

public class StateMenu extends State {
	private ArrayList<controller.GameObject> menuList;
	private int mousepos_x, mousepos_y;
	private int clicked_x, clicked_y;
	private boolean clicked = false;
	
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) {
		g.setColor(Color.orange);
		
		for(controller.GameObject ob :objectList) {
			ob.draw(g);
		}
	}
	
	public void update(model.GameData gameData) { 
		menuList = new ArrayList<controller.GameObject>();
		controller.MenuItem itemStart = new controller.MenuItem(gameData,
				controller.GameObjectFactory.createPlayState(), "Play!", 180, 180);
		menuList.add(itemStart);

		controller.MenuItem itemChooseLevel = new controller.MenuItem(gameData,
				GameObjectFactory.createPlayState(), "Choose level", 180,
				220);
		menuList.add(itemChooseLevel);
		controller.MenuItem itemSettings = new controller.MenuItem(gameData,
				GameObjectFactory.createMenuState(), "Settings", 180, 260);
		menuList.add(itemSettings);
		controller.MenuItem itemEditLevel = new controller.MenuItem(gameData,
				GameObjectFactory.createExitState(), "Create level", 180,
				340);
		menuList.add(itemEditLevel);

		controller.MenuItem itemExit = new controller.MenuItem(gameData,
				GameObjectFactory.createExitState(), "Exit", 180, 300);
		menuList.add(itemExit);
		
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
