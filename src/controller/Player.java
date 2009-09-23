package controller;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	private int health = 3;



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

	public void setCoordinates(int x, int y) {
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





	@Override
	public void setSlope(int i) {
		// TODO Auto-generated method stub
		
	}


	
}
