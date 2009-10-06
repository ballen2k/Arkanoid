package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
/**
 * A wall. For the balls to bounce on.
 * 
 * @author Madelene
 * 
 */
public class Wall extends GameObject implements Serializable {
	private Rectangle2D bounds; 
	
	public Wall(int x, int y, int w, int h) {
		bounds = new Rectangle();
		bounds.setRect(x, y, w, h);
	}
	
	public void changeDirectionX() {
		// TODO Auto-generated method stub
		
	}
	

	public void changeDirectionY() {
		// TODO Auto-generated method stub
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
	}

	public Rectangle2D getBounds() {
		return bounds;
	}

	public int getDirectionX() {
		return 0;
	}

	public int getDirectionY() {
		return 0;
	}

	public int getHealth() {
		return 0;
	}

	public int getHeight() {
		return 0;
	}

	public int getSlope() {
		return 0;
	}

	public int getWidth() {
		return 0;
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	public boolean intersect(GameObject gameObject) {
		return false;
	}

	public void setCoordinates(int x, int y) {
		return;
	}



}
