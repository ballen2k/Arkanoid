package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;

import javax.swing.Timer;

import controller.Ball;
import controller.Player;

/*
 * Class containing all the data for the game. Including Levels, Power-ups, player(s) and other 
 * GameObjects i.e the ball.
 */
public class GameData extends Observable implements ActionListener {

	private LevelData levelData;
	private Player player;
	private BallData ballData;
	private PowerUpData powerUpData;
	Timer timer;
	Random random = new Random();

	public GameData() {
		levelData = new LevelData();
		player = new Player();
		player.setHealth(3);
		ballData = new BallData(this);
		timer = new Timer(25, this);
		timer.start();

	}

	public LevelData getLevelData() {
		return levelData;
	}

	public Player getPlayer() {
		return player;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ballData.doYourStuff();
		Player player = getPlayer();
		ArrayList<controller.GameObject> ballList = ballData.getBallList();
		ArrayList<controller.GameObject> objects = levelData.getCurrentLevel()
				.getLevel();

		for (controller.GameObject b : ballList) {
			for (Iterator<controller.GameObject> it = objects.iterator(); it
					.hasNext();) {
				controller.GameObject ob = it.next();
				if (b.intersect(ob)) {
					ob.hit(b);
					if (ob.isDead()) {
						it.remove();
					}

					b.changeDirectionY();
				}
			}
		}
		for (Iterator<controller.GameObject> it = ballList.iterator(); it .hasNext();) {
			controller.GameObject ball = it.next();

			ball.setCoordinates(ball.getX()
					+ (ball.getSlope() * ball.getDirectionX()), ball.getY()
					+ (5 * ball.getDirectionY()));
			if (ball.getX() >= 480) {
				ball.changeDirectionX();

			}
			if (ball.getX() <= 0) {
				ball.changeDirectionX();

			}
			if (ball.getY() <= 0) {
				ball.changeDirectionY();
			}
			if (ball.getY() >= 480) {
				it.remove();
			}

			if (ball.intersect(player)) {
				ball.setSlope(random.nextInt(5) + 5);
				ball.changeDirectionY();

			}
		}
		if (ballList.isEmpty()){
			if(player.getHealth() != 0) {
				player.setHealth(player.getHealth()-1);
			}
			if (player.isDead()){
				System.out.println("GAME OVER NOOB");
				timer.stop();
				
			}else{
				ballData.addBall(player.getX()+25, player.getY()-controller.Ball.BALL_HEIGHT, 1, -1);
			}
		}
		// powerUpData.doYourStuff();
		setChanged();
		notifyObservers();

	}

	public BallData getBallData() {
		return ballData;
	}

}
