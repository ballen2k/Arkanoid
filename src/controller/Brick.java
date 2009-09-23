package controller;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends GameObject {
	private int health = 1;

	private int x, y;
	final int width = 35;
	final int height = 15;

	public void setCordinates(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.x, this.y, this.width, this.height);

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
	public boolean intersect(GameObject gameObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void hit(GameObject o) {
		health--;
	}

	@Override
	public boolean isDead() {
		return (health==0);
}
}
