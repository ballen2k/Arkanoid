package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
/**
 * 
 * @author Jeremia
 * 
 * A nifty explosion class. Epic gfx.
 *
 */
public class Explosion {
	class Pixel {
		private int pos_x, pos_y;
		private int lifetime;
		private int gravity;
		private double velocity_x;
		private double velocity_y;
		private Random random; 
		private double angle;
		private int frameCount; 
		private int start_x; 
		private Color color;
		
		public Pixel(double angle, int gravity, int velocity_x, int velocity_y, int pos_x,
				int pos_y, int lifetime, Color color) {
			this.pos_x = pos_x;
			this.pos_y = pos_y;
			start_x = pos_x;
			this.lifetime = lifetime;
			this.gravity = gravity;
			
			
			this.random = new Random();
			this.velocity_x = (random.nextInt(6))*Math.pow(-1, random.nextInt(2));
			this.velocity_y = (random.nextInt(3)+1)*Math.pow(-1, random.nextInt(2)); 
			frameCount = 0;
		}

		public void update() {
			frameCount += 1; 
			lifetime--;
			pos_x += (int)velocity_x;
			pos_y += (int)velocity_y;
		}

		public void draw(Graphics g) {
			if (lifetime >= 0) {
				g.setColor(Color.pink);
				g.fillRect(pos_x, pos_y, 2, 2);
			}
		}
		
		public boolean isDead() {
			return(lifetime <= 0);
		}
	}
	
	ArrayList<Pixel> pixelList;
	
	public Explosion(int start_x, int start_y, Color color) {
		pixelList = new ArrayList<Pixel>();
		Random random = new Random();
		for(int i = 0; i < 100; i++) {
			pixelList.add(new Pixel(
					(double)random.nextInt(180),
					random.nextInt(2), 
					random.nextInt(2)*(int)Math.pow(-1,random.nextInt(2)), 
					random.nextInt(2),
					start_x, start_y, 50, color));
		}
	}
	
	public void update(Graphics g) {
		for(Pixel pi :pixelList) {
			pi.update();
			pi.draw(g);
		}
	}

}
