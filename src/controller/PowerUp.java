package controller;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class PowerUp extends GameObject{
	private int x;
	private int y;
	
	private int height;
	private int width; 
	
	private Rectangle2D bounds;
	
	public PowerUp() {
		bounds.setRect(x,y,width,height);
	}

	public Rectangle2D getBounds() {
		return bounds;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void setCoordinates(int x, int y) {
		this.y = y;
		
	}

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
	public boolean intersect(GameObject gameObject) {
		// TODO Auto-generated method stub
		return false;
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
