package controller;

import java.awt.Color;
/**
 * Class player. The user controller actor in the game.
 * 
 * @author Jeremia
 * 
 */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import states.State;
import javax.swing.*;
public class Player extends GameObject {

	private int health = 3;
	private Rectangle2D bounds;
	private states.State activeState;

	private int y = 400;
	private int x = 200;

	final int width = 60;
	final int height = 15;

	final int widthBigger = 80;
	final int widthSmaller = 40;
	
	private ImageIcon image; 
	
	public Player() {
		activeState = new states.StatePlayerNormal();
		bounds = new Rectangle();
		bounds.setRect(x, y, width, height);
		
		image = new ImageIcon("img\\Hitter60x15.png");
	}

	public Rectangle2D getBounds() {
		return bounds;

	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int)this.bounds.getX(), (int)this.bounds.getY(), null);
	}

	public boolean intersect(GameObject object) {
		int x1 = x + width;
		int y1 = y + height;

		int x3 = object.getX() + object.getWidth();
		int y3 = object.getY() + object.getHeight();

		return !(x1 < object.getX() || x3 < x || y1 < object.getY() || y3 < y);

	}

	public int getY() {
		return y;
	}

	public void setActiveState(states.State activeState) {
		this.activeState = activeState;
		if(activeState instanceof states.StatePlayerPowerUpBigger) {
			image = new ImageIcon("img\\Hitter80x15.png");
		} else if(activeState instanceof states.StatePlayerPowerUpSmaller) {
			image = new ImageIcon("img\\Hitter40x15.png");
		} else if(activeState instanceof states.StatePlayerPowerUpGun) {
			image = new ImageIcon("img\\Hitter_Wep.png");
		} else {
			image = new ImageIcon("img\\Hitter60x15.png");
		}	
	}

	public void setCoordinates(int x, int y) {
		y = 400;
		this.x = x;
		if (activeState instanceof states.StatePlayerPowerUpBigger) {
			bounds.setRect(x, y, widthBigger, height);
		} else if (activeState instanceof states.StatePlayerPowerUpSmaller) {
			bounds.setRect(x, y, widthSmaller, height);
		} else {

			bounds.setRect(x, y, width, height);
		}
	}

	public int getX() {
		return x;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		//returns width depending on which PowerUp the player has.
		if (activeState instanceof states.StatePlayerPowerUpBigger) {
			return widthBigger;
		} else if (activeState instanceof states.StatePlayerPowerUpSmaller) {
			return widthSmaller;
		} else {
			return width;
		}

	}
	public states.State getPowerUp(){
		return activeState;
		};

	@Override
	public void hit(GameObject g) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDead() {
		return (health == 0);
	}

	@Override
	public void setHealth(int i) {
		this.health = i;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public void changeDirectionX() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeDirectionY() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDirectionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDirectionY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSlope() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSlope(int i) {

	}

}
