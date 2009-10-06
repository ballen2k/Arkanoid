package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import states.State;

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

	public Player() {
		activeState = new states.StatePlayerNormal();
		bounds = new Rectangle();
		bounds.setRect(x, y, width, height);

	}

	public Rectangle2D getBounds() {
		return bounds;

	}

	public void draw(Graphics g) {
		
		g.setColor(Color.green);

		if (activeState instanceof states.StatePlayerPowerUpBigger) {
			g.fillRect(x, y, widthBigger, height);
		} else if (activeState instanceof states.StatePlayerPowerUpSmaller) {
			g.fillRect(x, y, widthSmaller, height);
		} else if (activeState instanceof states.StatePlayerPowerUpGun){
			g.fillRect(x, y, width, height);
			g.setColor(Color.black);
			g.fillRect(x+5, y, 3, 5);
			g.fillRect(x+width-6, y, 3, 5);
		}else {
			g.fillRect(x, y, width, height);
		}

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
