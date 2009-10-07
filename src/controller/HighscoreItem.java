package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

/*
 * Class used for saving highScores.
 * Contains the Player ID and the points he/she has.
 */
public class HighscoreItem extends GameObject implements Serializable, Comparable<HighscoreItem> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private int points;
	private int x, y;

	public HighscoreItem(String id, int points) {
		this.id = id;
		this.points = points;
	}

	public String getId() {
		return id;
	}

	public int getPoints() {
		return points;
	}

	public void draw(java.awt.Graphics g) {
		Font font = new Font("Serif", Font.BOLD, 12);
		g.setFont(font);
		g.setColor(Color.black);
		g.fillRect(x - 10, y - 12, 300, 20);
		g.setColor(Color.red);
		g.drawString(id, x, y);
		String points_str = new String();
		points_str += points;
		g.drawString(points_str, x + 200, y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public Rectangle2D getBounds() {
		return null;
	}

	public int getHeight() {
		return 0;
	}

	public int getWidth() {
		return 0;
	}

	public boolean intersect(GameObject gameObject) {
		return false;
	}

	public void setCoordinates(int x, int y) {

	}

	@Override
	public int compareTo(HighscoreItem arg0) {
		if(arg0 != null) {
			return arg0.getPoints() -  this.getPoints();
		} else {
			return 0; 
		}
	}
}
