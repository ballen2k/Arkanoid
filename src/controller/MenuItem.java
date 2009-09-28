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
	
	public MenuItem(model.GameData gameData, states.State state, String string, int x, int y) {
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
	
	@Override
	public void changeDirectionX() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeDirectionY() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.drawRect((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
		g.drawString(text, (int)bounds.getX()+10, (int)bounds.getY()+23);
	}

	@Override
	public Rectangle2D getBounds() {
		return bounds;
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
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSlope() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void hit(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean intersect(GameObject gameObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCoordinates(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHealth(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSlope(int i) {
		// TODO Auto-generated method stub
		
	}

}
