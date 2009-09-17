package controller;

import java.awt.Graphics;

/*
 * Abstract class for all the objects in the game. All of the objects used in Arkanoid will
 * inherit from this class.
 * 
 */
public abstract class GameObject {
	/*
	 * Sets the coordiantes for the object.
	 */
	public abstract void setCordinates(int x, int y);
	/*
	 * Sets the way the object is supposed to be drawn.
	 */
	public abstract void draw(Graphics g);
	
	/*
	 *Checks if (x,y) belongs to the objects (x,y) 
	 *
	 * 
	 */
	public abstract boolean intersect(int x, int y);
	
	public abstract int getX();
	public abstract int getY();
}
