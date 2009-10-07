package states;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

public class StateGameComplete extends State {
	private ArrayList<controller.GameObject> menuList;
	private ArrayList<controller.HighscoreItem> highscoreItems;
	private int mousepos_x, mousepos_y;
	private int clicked_x, clicked_y;
	private boolean clicked = false;
	private boolean savedHighscore = false;

	public void update(model.GameData gameData, model.UserData userData) {
		gameData.setActiveGame(false);

		if(!savedHighscore) {
			java.util.Date date = new java.util.Date();
			String dateString = new String(); 
			dateString += Integer.toString(date.getYear()+1900);
			dateString += " - "; 
			dateString += Integer.toString(date.getMonth());
			dateString += " - "; 
			dateString+= Integer.toString(date.getDay());
			dateString += " "; 
			dateString += Integer.toString(date.getHours());
			dateString += ":";
			dateString += Integer.toString(date.getMinutes());
			dateString += ":";
			dateString += Integer.toString(date.getSeconds());
			
			gameData.getHighscoreData().addHighscore(new controller.HighscoreItem(dateString, userData.getPoints()));
			savedHighscore = true; 
		}
		
		highscoreItems = gameData.getHighscoreData().getHighscore();
		
		menuList = new ArrayList<controller.GameObject>();
		controller.MenuItem itemStart = new controller.MenuItem(gameData,
				controller.GameObjectFactory.createMenuState(), "Main menu",
				180, 420);
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
		if(highscoreItems != null)
		for(int i = 0; i < Math.min(10, highscoreItems.size()); i++) {
			controller.HighscoreItem hi = highscoreItems.get(i);
			hi.setX(120);
			hi.setY((i+10)*20);
			menuList.add(hi);
		}
		return menuList;
	}

	public void draw(Graphics g, ArrayList<controller.GameObject> objectList,
			model.UserData userData) {
		g.setColor(Color.orange);
		g.drawString("Game Completed", 180, 180);

		for (controller.GameObject o : objectList) {
			o.draw(g);
		}
	}
}
