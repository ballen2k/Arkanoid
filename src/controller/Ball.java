package controller;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{
	int x;
	int y;
	
	
		public Ball(int x, int y){
			this.x = x;
			this.y = y;
			
		}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval(x, y, 10, 10);
		
	}

	@Override
	public boolean intersect(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCordinates(int x, int y) {
		this.x =x;
		this.y = y;
		
		
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

}
