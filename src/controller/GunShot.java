package controller;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class GunShot extends GameObject {
	private int x;
	private int y;
	
	final private int HEIGHT = 5;
	final private int WIDTH = 3;
	final private int PLAYER_WIDTH = 60;

	private Rectangle2D bounds;
	
	private ImageIcon image; 

	public GunShot(int x, int y) {
		bounds = new Rectangle();
		bounds.setRect(x, y, WIDTH, HEIGHT);
		
		image = new ImageIcon("img\\Projectile.png");
	}

	public Rectangle2D getBounds() {
		return bounds;
	}


	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fill3DRect((int) bounds.getX(), (int) bounds.getY(), WIDTH, HEIGHT,true);
		
		g.drawImage(image.getImage(), (int)this.bounds.getX(), (int)this.bounds.getY(), null);
	}

	@Override
	public void setCoordinates(int x, int y) {
		bounds.setRect(x, y, WIDTH, HEIGHT);

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

	@Override
	public boolean intersect(GameObject ob) {
		

		return bounds.intersects(ob.getBounds());
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

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
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
