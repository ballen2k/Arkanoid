package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class MenuItem extends GameObject {
	private String text;
	private Rectangle2D bounds;
	private model.GameData gameData;
	private states.State setState;
	private Color color;

	public MenuItem(model.GameData gameData, states.State state, String string,
			int x, int y) {
		bounds = new Rectangle();
		bounds.setRect(x, y, 100, 38);
		this.gameData = gameData;
		this.setState = state;
		text = string;
		color = color.orange;
	}

	public void setActive() {
		color = color.yellow;
	}

	public void setNonActive() {
		color = color.orange;
	}

	public void pushed() {
		this.gameData.changeState(setState);
	}

	public void changeDirectionY() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds
				.getWidth(), (int) bounds.getHeight());
		g.setColor(color);
		g.drawRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds
				.getWidth(), (int) bounds.getHeight());
		g.drawString(text, (int) bounds.getX() + 10, (int) bounds.getY() + 23);
	}

	public Rectangle2D getBounds() {
		return bounds;
	}

	public int getHeight() {
		return 0;
	}

	public int getSlope() {
		return 0;
	}

	public int getWidth() {
		return 0;
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	public boolean intersect(GameObject gameObject) {
		return false;
	}

	public void setCoordinates(int x, int y) {
		return;
	}

}
