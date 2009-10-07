package controller;

/**
 * Class Powerup. This is the object displayd when an powerup is dropped
 * Contains wich powerup the player will get.
 * @author Jeremia
 *
 */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
public class PowerUp extends GameObject {
	private int x;
	private int y;
	private states.State powerUp;
	final private int height = 10;
	final private int width = 10;

	private Rectangle2D bounds;

	private ImageIcon image; 
	public PowerUp(states.State powerUp, int x, int y) {
		bounds = new Rectangle();
		bounds.setRect(x, y, width, height);
		if (!(powerUp instanceof states.StatePlayerNormal)){
			this.powerUp = powerUp;
		}
		
		
		if(powerUp instanceof states.StatePlayerPowerUpSplitBall) {
			image = new ImageIcon("img\\2.png");
		} else if(powerUp instanceof states.StatePlayerPowerUpExtraLife) {
			image = new ImageIcon("img\\E.png");
		} else  if(powerUp instanceof states.StatePlayerPowerUpBigger) {
			image = new ImageIcon("img\\B.png");
		} else if(powerUp instanceof states.StatePlayerPowerUpSmaller) {
			image = new ImageIcon("img\\S.png");
		} else if(powerUp instanceof states.StatePlayerPowerUpGun) {
			image = new ImageIcon("img\\G.png");
		} 

	}

	public Rectangle2D getBounds() {
		return bounds;
	}


	public void draw(Graphics g) {
		g.drawImage(image.getImage(), (int)this.bounds.getX(), (int)this.bounds.getY(), null);
		
	}

	@Override
	public void setCoordinates(int x, int y) {
		bounds.setRect(x, y, width, height);

	}
	
	public states.State getPowerUp(){
		return powerUp;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return 0;
	}

	public int getWidth() {
		return 0;
	}

	public boolean intersect(GameObject ob) {
		

		return bounds.intersects(ob.getBounds());
	}

	
}
