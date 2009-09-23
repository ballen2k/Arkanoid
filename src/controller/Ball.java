package controller;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	private int x;
	private int y;
	private int width;
	private int height;
	private int directionX;
	private int directionY;
	private int slope;
	
	public Ball(int x, int y, int directionX, int directionY) {
		this.x = x;
		this.y = y;
		this.directionX = directionX;
		this.directionY = directionY;
		this.slope=5;
		width = 10;
		height = 10;
		
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
		g.fillOval(x, y, width, height);

	}


	public boolean intersect(GameObject object) {
		int x1 = x + width;
		int y1 = y + height;

		int x3 = object.getX() + object.getWidth();
		int y3 = object.getY() + object.getHeight();

		return !(x1 < object.getX() || x3 < x || y1 < object.getY() || y3 < y);
	}

	@Override
	public void setCordinates(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
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
}
