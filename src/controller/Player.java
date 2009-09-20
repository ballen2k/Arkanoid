package controller;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	
	private int y = 400;
	private int x = 200;

	final int width = 60;
	final int height = 15;
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x,y, width, height);
		
	}

	@Override
	public boolean intersect(int x, int y) {
		if(this.getX()<= x && x-60 <this.getX() &&
				this.y <= y && y-5 <= this.y ){
			return true;
		}

		return false;
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
}
