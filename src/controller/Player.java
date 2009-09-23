package controller;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	
	private int y = 400;
	private int x = 200;

	final int width = 60;
	final int height = 15;
	
	

	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x,y, width, height);
		
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

	public void setCordinates(int x, int y) {
		this.x =x;
	}
	
	public int getX(){
		return x;
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
