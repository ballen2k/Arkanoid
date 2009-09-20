package controller;

import java.awt.Graphics;

public class PowerUp extends GameObject{
	private int x;
	private int y;
		
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean intersect(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCordinates(int x, int y) {
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
}
