package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import javax.swing.*;

/**
 * The Brick Class. This is the objects making up the map. Contains powerups
 * which will fall down when the brick is killed.
 * 
 * @author Jeremia
 * 
 */
public class Brick extends GameObject implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Rectangle2D bounds;
	private int health = 1;
	private states.State powerUp;
	private int x, y;
	private final int width = 35;
	private final int height = 15;
	private boolean hasPowerUp = false;
	private Color color;
	private ImageIcon image;

	public Brick(int x, int y) {
		this.color = Color.red;
		this.x = x;
		this.y = y;

		bounds = new Rectangle();
		bounds.setRect(x, y, width, height);

	}

	public Brick(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;

		bounds = new Rectangle();
		bounds.setRect(x, y, width, height);

		if (this.color == Color.pink) {
			this.health = 1;
			image = new ImageIcon("img\\Purple.png");
		} else if (this.color == Color.green) {
			this.health = 2;
			image = new ImageIcon("img\\Green.png");
		} else if (this.color == Color.orange) {
			this.health = 3;
			image = new ImageIcon("img\\Orange.png");
		} else {
			image = new ImageIcon("img\\Purple.png");
		}
	}

	public Color getColor() {
		return color;
	}

	public boolean hasPowerUp() {

		return hasPowerUp;
	}

	public void setPowerUp(states.State powerUp) {
		this.powerUp = powerUp;
		hasPowerUp = true;
	}

	public boolean isRemovable() {
		return true;
	}

	public Rectangle2D getBounds() {
		return bounds;
	}

	public states.State getPowerUp() {
		return powerUp;
	}

	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;

		bounds.setRect(x, y, width, height);

	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int) this.bounds.getX(),
				(int) this.bounds.getY(), null);
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

	public boolean intersect(GameObject gameObject) {
		return false;
	}

	public void hit(GameObject o) {
		health--;
	}

	public boolean isDead() {
		return (health == 0);
	}

	public int getHealth() {
		return health;
	}

}
