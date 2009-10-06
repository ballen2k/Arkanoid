package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class PowerUp extends GameObject {
	private int x;
	private int y;
	private states.State powerUp;
	final private int height = 10;
	final private int width = 10;

	private Rectangle2D bounds;

	public PowerUp(states.State powerUp, int x, int y) {
		bounds = new Rectangle();
		bounds.setRect(x, y, width, height);
		this.powerUp = powerUp;
		

	}

	public Rectangle2D getBounds() {
		return bounds;
	}


	public void draw(Graphics g) {
		g.setColor(this.powerUp.getColor());
		g.fillRect((int) bounds.getX(), (int) bounds.getY(), width, height);

	}

	@Override
	public void setCoordinates(int x, int y) {
		bounds.setRect(x, y, width, height);

	}
	
	public states.State getPowerUp(){
		return powerUp;
		};

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return 0;
	}

	public int getWidth() {
		return 0;
	}

	@Override
	public boolean intersect(GameObject ob) {
		

		return bounds.intersects(ob.getBounds());
	}

	@Override
	public void hit(GameObject g) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHealth(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public void setSlope(int i) {
		// TODO Auto-generated method stub

	}
}
