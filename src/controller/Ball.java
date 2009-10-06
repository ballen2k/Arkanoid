package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
/**
 * The ball class. This is the object thats moving around and
 *         destroying the evil bricks
 * @author Jeremia 
 * 
 */
public class Ball extends GameObject {
	Rectangle2D outerBounds;
	Rectangle2D bounds;
	private int x;
	private int y;
	public static final int BALL_WIDTH = 10;
	public static final int BALL_HEIGHT = 10;
	private final int MAX_SLOPE = 8;
	private boolean isMoving = false;
	private ImageIcon image; 


	private int directionX;
	private int directionY;
	private int slope;

	public Ball(int x, int y, int directionX, int directionY) {
		this.x = x;
		this.y = y;
		this.directionX = directionX;
		this.directionY = directionY;
		this.slope = 1;
		image = new ImageIcon("img\\Ball.png");
		outerBounds = new Rectangle();
	}

	public boolean isMoving() {
		return isMoving; 
	}
	
	public void setMoving() {
		isMoving = true;
	}


	public int getMAX_SLOPE() {
		return MAX_SLOPE;
	}
	
	public Rectangle2D getBounds() {
		return outerBounds;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getSlope() {
		return slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	public int getDirectionX() {
		return directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void changeDirectionX() {
		this.directionX = directionX * -1;
	}

	public void changeDirectionY() {
		this.directionY = directionY * -1;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, null);

	}

	public boolean intersect(GameObject object) {
		bounds = new Rectangle();
		bounds.setRect(x,y,10,10);
		outerBounds.setRect(x + slope * getDirectionX(), y
				+ (5 * getDirectionY() + 3), 10, 10);
		Rectangle2D obBounds = object.getBounds();

		return outerBounds.intersects(obBounds);
	}

	public boolean intersectLeftRight(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		//Creates temporary Rectangle2d for the top/bottom collission check 
		Rectangle2D leftZone = new Rectangle();
		Rectangle2D rightZone = new Rectangle();
		
		leftZone.setRect(obBounds.getX() - 9, obBounds.getY() + 1, 9, obBounds
				.getHeight() - 2);
		rightZone.setRect(obBounds.getX() + obBounds.getWidth(), obBounds
				.getY() + 1, 9, obBounds.getHeight() - 2);

		return (outerBounds.intersects(leftZone) || outerBounds
				.intersects(rightZone)
				);

	}

	public boolean intersectTopBottom(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		//Creates temporary Rectangle2d for the top/bottom collission check 
		Rectangle2D topZone = new Rectangle();
		Rectangle2D bottomZone = new Rectangle();
		topZone.setRect(obBounds.getX(), obBounds.getY() - 9, obBounds
				.getWidth(), 9);
		bottomZone.setRect(obBounds.getX(), obBounds.getY()
				+ obBounds.getHeight(), obBounds.getWidth(), 9);

		return (outerBounds.intersects(bottomZone) || outerBounds
				.intersects(topZone));

	}

	public boolean intersectLeft(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		// Create a temp rectangle to the left of the object
		Rectangle2D leftZone = new Rectangle();
		leftZone.setRect(obBounds.getX() - 10, obBounds.getY(), 10, obBounds
				.getHeight());

		return (bounds.intersects(leftZone));
	}

	public boolean intersectRight(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		// Create a temp rectangle to the right of the object
		Rectangle2D rightZone = new Rectangle();
		rightZone.setRect(obBounds.getX() + obBounds.getWidth(), obBounds
				.getY(), 10, obBounds.getHeight());

		return (bounds.intersects(rightZone));
	}

	@Override
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
		outerBounds.setRect(x, y, 10, 10);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return BALL_HEIGHT;
	}

	public int getWidth() {
		return BALL_WIDTH;
	}

}
