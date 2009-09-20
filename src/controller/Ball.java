package controller;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	int x;
	int y;
	int width;
	int height;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		width = 10;
		height = 10;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval(x, y, width, height);

	}

	@Override
	public boolean intersect(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean intersect(GameObject object) {
	    int x1 = x + width;
	    int y1 = y + height;

	    int x3 = object.getX() + object.getWidth();
	    int y3 = object.getY() + object.getHeight();

	    return !(x1< object.getX() || x3<x || y1< object.getY() || y3<y);
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
}
