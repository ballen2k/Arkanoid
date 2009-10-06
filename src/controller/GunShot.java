package controller;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
/**
 * The GunShot class. When the player picks up a gun powerup, he is
 * able to shoot down the bricks aswell. This is the class for the projectiles.
 * 
 * 
 * 
 * @author Madelene
 *
 */
public class GunShot extends GameObject {
	private int x;
	private int y;
	
	final private int HEIGHT = 5;
	final private int WIDTH = 3;

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

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean intersect(GameObject ob) {
		return bounds.intersects(ob.getBounds());
	}

	
}
