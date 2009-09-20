package controller;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends GameObject{

	private int x,y;
	final int width = 35;
	final int height = 15;
	
	public void setCordinates(int x, int y) {
		this.x = x;
		this.y = y;
		
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.x, this.y, this.width, this.height);
		
	}


	public boolean intersect(int x, int y) {
		if(this.x >= x && x <=this.x + width && this.y >= y && y <= this.y+height){
			return true;
		}
		System.out.println("Intersect");

		return false;
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
