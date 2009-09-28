package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Brick extends GameObject implements Serializable {
	
	private Rectangle2D bounds;
	private int health = 1;
	private states.State powerUp;
	private int x, y;
	final int width = 35;
	final int height = 15;
	private boolean hasPowerUp = false;
	
	public Brick(int x, int y) {
		
		this.x = x; 
		this.y = y;
		
		bounds = new Rectangle();
		bounds.setRect(x,y,width,height);
		
		
	}
	public boolean hasPowerUp(){
		
		return hasPowerUp;
	}
	
	public void setPowerUp(states.State powerUp){
		this.powerUp = powerUp;
		hasPowerUp = true;
	}
	

	public boolean isRemovable() {
		return true;
	}
	
	public Rectangle2D getBounds() {
		return bounds;
	}
	public states.State getPowerUp(){
		return powerUp;
	}
	
	public void setCoordinates(int x, int y) {
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
