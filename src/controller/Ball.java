package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Ball extends GameObject {
	Rectangle2D outerBounds;
	private int x;
	private int y;
	public static final int BALL_WIDTH = 10;
	public static final int BALL_HEIGHT = 10;

	private int directionX;
	private int directionY;
	private int slope;
	
	public Ball(int x, int y, int directionX, int directionY) {
		this.x = x;
		this.y = y;
		this.directionX = directionX;
		this.directionY = directionY;
		this.slope=5;
		
		outerBounds = new Rectangle();
	}

	public Rectangle2D getBounds() {
		return outerBounds;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getSlope() {
		return slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}



	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	public int getDirectionX() {
		return directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void changeDirectionX() {
		this.directionX = directionX * -1;
	}

	public void changeDirectionY() {
		this.directionY = directionY * -1;
	}

	

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval(x, y, BALL_WIDTH, BALL_HEIGHT);

	}
	
	public boolean intersect(GameObject object) {
		outerBounds.setRect(x + slope * getDirectionX(),
							y + (5 * getDirectionY()), 10, 10);
		Rectangle2D obBounds = object.getBounds();
		
		return outerBounds.intersects(obBounds);
	}
	
	public boolean intersectLeft(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		
		// Create a temp rectangle to the left of the object
		Rectangle2D leftZone = new Rectangle();
		leftZone.setRect(obBounds.getX()-5, obBounds.getY()+5, 5, obBounds.getHeight()-5);
		
		return outerBounds.intersects(leftZone);
	}
	
	public boolean intersectRight(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		
		// Create a temp rectangle to the right of the object
		Rectangle2D rightZone = new Rectangle();
		rightZone.setRect(obBounds.getX()+obBounds.getWidth(), 
						 obBounds.getY()+5, 5, 
						 obBounds.getHeight()-5);
		
		return outerBounds.intersects(rightZone);
	}
	
	@Override
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
		outerBounds.setRect(x,y,10,10);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return BALL_HEIGHT;
	}

	public int getWidth() {
		return BALL_WIDTH;
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
}
