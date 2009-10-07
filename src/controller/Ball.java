package controller;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

/**
 * The ball class. This is the object thats moving around and destroying the
 * evil bricks. Its in this's class almost all the collision handling is done.
 * 
 * @author Jeremia
 * 
 */
public class Ball extends GameObject {
	private Rectangle2D outerBounds;
	private Rectangle2D bounds;
	private int x;
	private int y;
	private final int BALL_WIDTH = 10;
	private final int BALL_HEIGHT = 10;
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

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, null);

	}

	public boolean intersect(GameObject object) {
		bounds = new Rectangle();
		// sets the bounds variable to the balls coordinates.
		bounds.setRect(x, y, BALL_WIDTH, BALL_HEIGHT);
		// Creates a temporary Rectangle2D thats one tick in front
		// of the actual ball. This is to prevent the ball from
		// sticking inside objects when they collide.
		outerBounds.setRect(x + slope * getDirectionX(), y
				+ (5 * getDirectionY() + 3), 10, 10);
		Rectangle2D obBounds = object.getBounds();

		return outerBounds.intersects(obBounds);
	}

	public boolean intersectLeft(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		// Create a temp rectangle to the left of the object
		Rectangle2D leftZone = new Rectangle();
		leftZone.setRect(obBounds.getX() - 10, obBounds.getY(), 10, obBounds
				.getHeight());
		// Checks if the ball intersects with the newly created temp
		// rectangle.
		return (bounds.intersects(leftZone));
	}

	public boolean intersectRight(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		// Create a temp rectangle to the right of the object
		Rectangle2D rightZone = new Rectangle();
		rightZone.setRect(obBounds.getX() + obBounds.getWidth(), obBounds
				.getY(), 10, obBounds.getHeight());
		// Checks if the ball intersects with the newly created temp
		// rectangle.
		return (bounds.intersects(rightZone));
	}

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
