package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

import controller.GameObject;
import controller.Wall;

public class StateLevelEditor extends State {
	private ArrayList<controller.GameObject> hiddenObjects;
	private ArrayList<controller.GameObject> levelObjects;
	private ArrayList<controller.GameObject> menuList;
	private int mousepos_x, mousepos_y;
	private int clicked_x, clicked_y;
	private boolean clicked = false;
	private boolean rightClick = false;
	private int rightClicked_x, rightClicked_y;
	
	private java.awt.Color activeColor;
	private State activePowerUp = null;

	public StateLevelEditor() {
		levelObjects = new ArrayList<controller.GameObject>();

		controller.Wall left = new controller.Wall(-20, 0, 20, 480);
		controller.Wall right = new controller.Wall(485, 0, 10, 480);
		controller.Wall up = new controller.Wall(0, -20, 480, 20);
		
		levelObjects.add(left);
		levelObjects.add(right);
		levelObjects.add(up);

		activeColor = Color.red;
	}

	public void update(model.GameData gameData, model.UserData userData) {

		if(gameData.getLevelManager().getTempLevel() != null) {
			levelObjects = gameData.getLevelManager().getTempLevel().getLevel();
			
		}
		activeColor = gameData.getLevelManager().getColor();
		activePowerUp = gameData.getLevelManager().getPowerUp();
		
		menuList = new ArrayList<controller.GameObject>();
		controller.MenuItem itemStart = new controller.MenuItem(gameData,
				controller.GameObjectFactory.createSaveLevelState(), "Save", 20, 400);
		menuList.add(itemStart);
		
		controller.MenuItem itemColorPurple = new controller.MenuItem(gameData, 
				controller.GameObjectFactory.createChangeLevelColor(java.awt.Color.pink), "Color: Pink", 120, 400);
		menuList.add(itemColorPurple);

		controller.MenuItem itemColorOrange = new controller.MenuItem(gameData, 
				controller.GameObjectFactory.createChangeLevelColor(java.awt.Color.orange), "Color: Orange", 220, 400);
		menuList.add(itemColorOrange);


		controller.MenuItem itemColorGreen = new controller.MenuItem(gameData, 
				controller.GameObjectFactory.createChangeLevelColor(java.awt.Color.green), "Color: Green", 320, 400);
		menuList.add(itemColorGreen);
		
		controller.MenuItem itemPowerUpGun = new controller.MenuItem(gameData, 
				controller.GameObjectFactory.createSetPowerUp(new StatePlayerPowerUpGun()), "Gun", 20, 360);
		menuList.add(itemPowerUpGun);

		controller.MenuItem itemPowerUpBigger = new controller.MenuItem(gameData, 
				controller.GameObjectFactory.createSetPowerUp(new StatePlayerPowerUpBigger()), "Bigger", 120, 360);
		menuList.add(itemPowerUpBigger);
		

		controller.MenuItem itemPowerUpSplit = new controller.MenuItem(gameData, 
				controller.GameObjectFactory.createSetPowerUp(new StatePlayerPowerUpSplitBall()), "Splitball", 220, 360);
		menuList.add(itemPowerUpSplit);

		controller.MenuItem itemPowerUpSmaller = new controller.MenuItem(gameData, 
				controller.GameObjectFactory.createSetPowerUp(new StatePlayerPowerUpSmaller()), "Smaller", 320, 360);
		menuList.add(itemPowerUpSmaller);

		controller.MenuItem itemPowerUpExtraLife = new controller.MenuItem(gameData, 
				controller.GameObjectFactory.createSetPowerUp(new StatePlayerPowerUpExtraLife()), "Extra life", 20, 320);
		menuList.add(itemPowerUpExtraLife);

		
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
					clicked = false;
				}
			}
			
		} 

		
		hiddenObjects = new ArrayList<controller.GameObject>();
		controller.GameObject temp;
		for (int j = 1; j < 25; j++) {
			for (int i = 1; i < 13; i++) {
				temp = controller.GameObjectFactory.createBrick();
				temp.setCoordinates(i * 35, j * 15);
				hiddenObjects.add(temp);
			}
		}
		
		if(rightClick) {
			for(Iterator it = levelObjects.iterator(); it.hasNext(); ) {
				controller.GameObject ob = (controller.GameObject)it.next();
				if(ob.getBounds().contains(new Point(rightClicked_x, rightClicked_y))) {
					it.remove();
					
				}
			}
		}
		rightClick = false;

		
		if(clicked) {

			for(Iterator it = levelObjects.iterator(); it.hasNext(); ) {
				controller.GameObject ob = (controller.GameObject)it.next();
				if(ob.getBounds().contains(new Point(clicked_x, clicked_y))) {
					it.remove();
					clicked = false;
				}
			}
			
			for(controller.GameObject o : hiddenObjects) {			
				if(o.getBounds().contains(new Point(clicked_x, clicked_y))) {
					controller.Brick tempBrick = new controller.Brick(o.getX(), o.getY(), activeColor);
					if(activePowerUp != null) {
						tempBrick.setPowerUp(activePowerUp);
					}
					levelObjects.add(tempBrick);
				}
			}
		}
		
		controller.Level level = new controller.Level(levelObjects);
		gameData.getLevelManager().setTempLevel(level);
		
		for(controller.GameObject o : levelObjects) {
			menuList.add(o);
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

	public void setRightClick(int pos_x, int pos_y) {
		this.rightClicked_x = pos_x;
		this.rightClicked_y = pos_y;
		this.rightClick = true;
	}

	public ArrayList<controller.GameObject> getObjects() {
		return menuList;
	}

	public void draw(Graphics g, ArrayList<controller.GameObject> objectList,
			model.UserData userData) {
		for (controller.GameObject o : objectList) {
			o.draw(g);
		}
	}
}