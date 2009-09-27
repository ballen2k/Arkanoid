package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Wall extends GameObject implements Serializable {
	private Rectangle2D bounds; 
	
	public Wall(int x, int y, int w, int h) {
		bounds = new Rectangle();
		bounds.setRect(x, y, w, h);
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
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GRAY);
		g.fillRect((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
	}

	@Override
	public Rectangle2D getBounds() {
		return bounds;
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
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSlope() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void hit(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean intersect(GameObject gameObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCoordinates(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHealth(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSlope(int i) {
		// TODO Auto-generated method stub
		
	}

}
