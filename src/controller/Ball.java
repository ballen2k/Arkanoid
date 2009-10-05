package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Ball extends GameObject {
	Rectangle2D outerBounds;
	private int x;
	private int y;
	public static final int BALL_WIDTH = 10;
	public static final int BALL_HEIGHT = 10;
	private final int MAX_SLOPE = 8;

	public int getMAX_SLOPE() {
		return MAX_SLOPE;
	}

	private int directionX;
	private int directionY;
	private int slope;

	public Ball(int x, int y, int directionX, int directionY) {
		this.x = x;
		this.y = y;
		this.directionX = directionX;
		this.directionY = directionY;
		this.slope = 1;

		outerBounds = new Rectangle();
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
		g.setColor(Color.cyan);
		g.fillOval(x, y, BALL_WIDTH, BALL_HEIGHT);

	}

	public boolean intersect(GameObject object) {
		outerBounds.setRect(x + slope * getDirectionX(), y
				+ (5 * getDirectionY() + 3), 10, 10);
		Rectangle2D obBounds = object.getBounds();

		return outerBounds.intersects(obBounds);
	}

	public boolean intersectLeftRight(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		Rectangle2D leftZone = new Rectangle();
		Rectangle2D rightZone = new Rectangle();
		leftZone.setRect(obBounds.getX() - 5, obBounds.getY() + 3, 5, obBounds
				.getHeight() - 6);
		rightZone.setRect(obBounds.getX() + obBounds.getWidth(), obBounds
				.getY() + 3, 5, obBounds.getHeight() - 6);

		return (outerBounds.intersects(leftZone) || outerBounds
				.intersects(rightZone)
				&& !this.intersectTopBottom(object));

	}

	public boolean intersectTopBottom(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
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
		double whichHeight;
		// the check for right or left collision needs a thin bounds rect
		// when checking bricks,
		// or else it will collide with the top/bottom collission.
		if (object instanceof controller.Brick) {
			whichHeight = 1;
		} else {
			whichHeight = obBounds.getHeight() - 5;
		}
		// Create a temp rectangle to the left of the object
		Rectangle2D leftZone = new Rectangle();
		leftZone.setRect(obBounds.getX(), obBounds.getY() + 1, 1, obBounds
				.getHeight() - 2);

		return outerBounds.intersects(leftZone);
	}

	public boolean intersectRight(GameObject object) {
		Rectangle2D obBounds = object.getBounds();
		// the check for right or left collision needs a thin bounds rect
		// when checking bricks,
		// or else it will collide with the top/bottom collission.
		double whichHeight;
		if (object instanceof controller.Brick) {
			whichHeight = 1;
		} else {
			whichHeight = obBounds.getHeight() - 5;
		}

		// Create a temp rectangle to the right of the object
		Rectangle2D rightZone = new Rectangle();
		rightZone.setRect(obBounds.getX() + obBounds.getWidth(), obBounds
				.getY() + 1, 1, obBounds.getHeight() - 2);

		return outerBounds.intersects(rightZone);
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

	@Override
	public void hit(GameObject g) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHealth(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
