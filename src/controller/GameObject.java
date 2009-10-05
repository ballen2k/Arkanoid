package controller;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/*
 * Abstract class for all the objects in the game. All of the objects used in Arkanoid will
 * inherit from this class.
 * 
 */
public abstract class GameObject {
	/*
	 * Sets the coordiantes for the object.
	 */
	public abstract void setCoordinates(int x, int y);
	/*
	 * Sets the way the object is supposed to be drawn.
	 */
	public abstract void draw(Graphics g);
	
	/*
	 *Checks if (x,y) belongs to the objects (x,y) 
	 *
	 * 
	 */
	public abstract boolean intersect(GameObject gameObject);
	public boolean intersectLeft(GameObject object) { return false; }
	public boolean intersectRight(GameObject object) { return false; }
	public boolean intersectLeftRight(GameObject object) {return false;}
	
	public void pushed() { return; }
	public void setActive() { return; }
	public void setNonActive() { return; }
	
	public abstract void hit(GameObject o);
	public abstract boolean isDead();
	public abstract int getX();
	public abstract int getY();
	public abstract int getHeight();
	public abstract int getWidth();
	public abstract void setHealth(int i);
	public abstract int getHealth();
	public abstract int getDirectionX();
	public abstract int getDirectionY();
	public abstract void changeDirectionY();
	public abstract void changeDirectionX();
	public abstract void setSlope(int i);
	public abstract int getSlope();
	//Detta verkar inteva så jävla bra???? låt stå sålänge.
	public states.State getPowerUp(){
		return new states.StatePlayerNormal();
		};
	public boolean hasPowerUp(){
		return false;
	};
	public void setPowerUp(states.State powerUp){
		
	}
	public int getMAX_SLOPE() {
		return 0;
	};
	public abstract Rectangle2D getBounds();

	public boolean isRemovable() { return false; }
}
