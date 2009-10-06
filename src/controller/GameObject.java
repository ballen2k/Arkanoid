package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/*
 * Abstract class for all the objects in the game. 
 * All of the objects used in Arkanoid gameplay 
 * will inherit from this class.
 * 
 */
public abstract class GameObject {
	/**
	 * Sets the x & y coordinates for the object.
	 * 
	 * @param x Int
	 * @param y Int
	 */
	public abstract void setCoordinates(int x, int y);
	/**
	 * Draws the GameObject
	 * 
	 * @param g GameObject
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * Checks if the Object intersects with the other object 
	 * @param gameObject GameObject
	 * @return Boolean
	 */
	public abstract boolean intersect(GameObject gameObject);
	/**
	 * Returns the objects X-Coordinate
	 * 
	 * @return Int
	 */
	public abstract int getX();
	/**
	 * Returns the objects Y-Coordinate
	 * 
	 * @return Int
	 */
	public abstract int getY();
	/**
	 * Returns the objects Height
	 * 
	 * @return Int
	 */
	public abstract int getHeight();
	/**
	 * Returns the objects Width.
	 * 
	 * @return Int
	 */
	public abstract int getWidth();
	/**
	 * Returns the objects bounds.
	 * 
	 * @return Rectangle2D
	 */
	public abstract Rectangle2D getBounds();
	
	/**
	 * Returns true if the object is dead, health = 0.
	 * @return Boolean
	 */
	public  boolean isDead() {return false;}
	/**
	 * Sets the slope of an object.
	 * @param i Int
	 */
	public  void setSlope(int i) {return;}
	/**
	 * Returns the current slope of an object.
	 * 
	 * @return Int
	 */
	public  int getSlope() {return 0;}
	/**
	 * Changes the objects up/down Direction. If the object is going down, this will
	 * cause the object to go up. And vice versa.
	 * 
	 * 
	 */
	public  void changeDirectionY(){return;}
	/**
	 * Changes the objects left/right Direction. If the object is going left, this will
	 * cause the object to go right. And vice versa.
	 * 
	 * 
	 */
	public  void changeDirectionX() {return;}
	/**
	 * Sets the health of an object.
	 * @param i Int
	 */
	public  void setHealth(int i) {return;}
	/**
	 * returns the health of an object
	 * @return Int
	 */
	public  int getHealth(){return 0;}
	/**
	 * If the object gets hit, do what needs to be done.
	 * For example decrease the health of a brick if it gets hit;
	 * 
	 * @param o GameObject
	 */
	public  void hit(GameObject o){return;}
	/**
	 * Returns true if the object o hits this on the left side
	 * 
	 * @param object GameObject
	 * @return Boolean
	 */
	public boolean intersectLeft(GameObject object) { return false; }
	/**
	 * Returns true if the object o hits this on the right side
	 * @param object GameObject
	 * @return Boolean
	 */
	public boolean intersectRight(GameObject object) { return false; }
	/**
	 * Returns true if the object o hits this on the left or right side
	 * @param object GameObject
	 * @return boolean
	 */
	public boolean intersectLeftRight(GameObject object) {return false;}
	/**
	 * Tells the object that something has happened.
	 * 
	 */
	public void pushed() { return; }
	/**
	 * Sets the active Flag of an object to active.
	 */
	public void setActive() { return; }
	/**
	 * sets the active flag of an object to inactive.
	 */
	public void setNonActive() { return; }
	/**
	 * Returns the left/right direction for an object. -1 for left, 1 for right.
	 * @return Int
	 */
	public  int getDirectionX(){return 0;}
	/**
	 * Returns the up/down direction of an object. -1 for up, 1 for down.
	 * @return
	 */
	public  int getDirectionY() {return 0;}
	/**
	 * Returns the objects powerUp
	 * @return State
	 */
	public states.State getPowerUp(){
		return new states.StatePlayerNormal();
		};
		/**
		 * Returns true if the object has an powerUp.
		 * @return boolean
		 */
	public boolean hasPowerUp(){return false;};
	/**
	 * Sets the objects powerUp
	 * @param powerUp State
	 */
	public void setPowerUp(states.State powerUp){}
	/**
	 * Returns the maximum slope of an object.
	 * @return Int
	 */
	public int getMAX_SLOPE() {return 0;};
	/**
	 * returns true if the object is removable.
	 * @return
	 */
	public boolean isRemovable() { return false; }
	/**
	 * Starts the objects movement
	 */
	public void setMoving() {}
	/**
	 * Returns true if the object is moving
	 * @return
	 */
	public boolean isMoving() { return true; }
	/**
	 * Returns the color of the object
	 * @return
	 */
	public Color getColor(){return Color.yellow;}
}
