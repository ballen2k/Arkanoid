package states;

import java.awt.*;
import java.util.*;
import java.math.*;
import java.lang.Math;
import controller.GameObject;

public class StatePlay extends State {
	private boolean activeGame = false;
	private model.LevelData levelData;
	private model.BallData ballData;
	private model.PowerUpData powerUpData;
	private model.UserData userData;
	private model.GunShotData gunShotData;
	private controller.Explosion explosion;

	private int mousepos_x, mousepos_y;
	private int clicked_x, clicked_y;
	private boolean clicked = false;

	private ArrayList<controller.GameObject> result;

	public void draw(Graphics g, ArrayList<controller.GameObject> objectList,
			model.UserData userData) {
		if (explosion == null) {
			explosion = new controller.Explosion(180, 180);
		} else {
			explosion.update(g);
		}
		g.setColor(Color.green);
		for (GameObject go : objectList) {
			go.draw(g);
		}

		g.setColor(Color.black);
		g.fillRect(0, 445, 1000, 200);
		g.setColor(Color.green);
		g.drawLine(0, 445, 500, 445);
		g.drawString("Lives: " + Integer.toString(userData.getNumberOfLifes()),
				50, 460);
		g.drawString("Points: " + Integer.toString(userData.getPoints()), 150,
				460);

		userData.getPlayer().draw(g);

	}

	public void setMouse(int pos_x, int pos_y) {
		this.mousepos_x = pos_x;
		this.mousepos_y = pos_y;
	}

	public void setClick(int pos_x, int pos_y) {
		this.clicked_x = pos_x;
		this.clicked_y = pos_y;
		this.clicked = true;
	}

	public void update(model.GameData gameData, model.UserData userData) {
		if (!activeGame) {
			levelData = new model.LevelData();
			ballData = new model.BallData(gameData);
			activeGame = true;
			powerUpData = new model.PowerUpData();
			gunShotData = new model.GunShotData();
		}

		controller.Player player = userData.getPlayer();
		ArrayList<controller.GameObject> ballList = ballData.getBallList();
		ArrayList<controller.GameObject> objects;
		controller.Level level = gameData.getLevelManager().getActiveLevel();

		if (level == null) {
			gameData.changeState(controller.GameObjectFactory
					.createStateGameComplete());
			return;
		}
		objects = level.getLevel();

		// Check if level is complete =)
		boolean complete = true;
		for (controller.GameObject ob : objects) {
			if (ob.isRemovable() == true) {
				complete = false;
				break;
			}
		}
		if (complete) {
			gameData.changeState(controller.GameObjectFactory
					.createStateLevelComplete());
			return;
		}

		// Move all the balls
		ballData.update();

		// Move the player
		userData.getPlayer().setCoordinates(
				mousepos_x - (int) (player.getBounds().getWidth() / 2), 123);

		// Check if one of the balls have hit a brick and handle it
		// appropriately
		for (Iterator<controller.GameObject> itB = ballList.iterator(); itB
				.hasNext();) {
			controller.GameObject b = itB.next();

			if (b.getBounds().getY() >= player.getBounds().getMaxY()) {
				// Ball is under the player
				itB.remove();
				continue;
			}

			for (Iterator<controller.GameObject> it = objects.iterator(); it
					.hasNext();) {
				controller.GameObject ob = it.next();
				if (b.intersect(ob)) {
					ob.hit(b);

					
					
					
					if (b.intersectLeft(ob)) {
						// b.setSlope(random.nextInt(5) + 5);
						b.changeDirectionX();
						System.out.println("IntersectLeft");
					
						
					} else if (b.intersectRight(ob)) {
						// b.setSlope(random.nextInt(5) + 5);
						b.changeDirectionX();
						System.out.println("Intersectright");
				
					
					} else {
						//System.out.println("intersectar inte med kanterna");
						// b.setSlope(random.nextInt(5) + 5);
						b.changeDirectionY();
						System.out.println("IntersectVanligt");
						
					}

					if (ob.isDead()) {
						if (ob.hasPowerUp()) {
							powerUpData.addPowerUp(ob.getPowerUp(), ob.getX(),
									ob.getY());
						}
						ob.setHealth(1);
						explosion = new controller.Explosion((int) ob
								.getBounds().getCenterX(), (int) ob.getBounds()
								.getCenterY());
						it.remove();
						userData.increasePoints(100);
						
					}
					break;
				}

			}

			if (b.intersect(player)) {
				if (b.intersectLeft(player)) {
					
					b.changeDirectionX();

				} else if (b.intersectRight(player)) {
					b.changeDirectionX();
				} else {
					int slope;
					//special case when the balls hit the player far to the left or right. 
					if (b.getX()+b.getWidth()/2<player.getX() || b.getX()+b.getWidth()/2 > player.getX()+player.getWidth()){
						b.setSlope(b.getMAX_SLOPE());
						
					}
					
					//ball = (b.getX()+b.getWidth()/2-player.getX());
					//System.out.println(ball);
				//	b.setSlope((int)(b.getX()/(player.getX()+(player.getWidth()/2)))*10);
					System.out.println((double)Math.abs((b.getX()+b.getWidth()/2)-(player.getX()+player.getWidth()/2))/(player.getWidth()/2));
					b.changeDirectionY();
					b.setSlope((int)((double)Math.abs((b.getX()+b.getWidth()/2)-(player.getX()+player.getWidth()/2))/(player.getWidth()/2)*b.getMAX_SLOPE()));
				}
			}
		}

		if (ballList.isEmpty()) {
			if (userData.getNumberOfLifes() > 0) {
				userData.decreaseNumberOfLifes();
				player.setActiveState(new states.StatePlayerNormal());
			}
			if (userData.getNumberOfLifes() == 0) {
				System.out.println("GAME OVER NOOB");
				activeGame = false;
				gameData.changeState(controller.GameObjectFactory
						.createStateGameOver());
			} else {
				ballData.addBall(player.getX() + 25, player.getY()
						- controller.Ball.BALL_HEIGHT, 1, -1);
			}
		}
		/*
		 * Collision handling for the powerUps
		 */
		for (Iterator<controller.GameObject> itPower = powerUpData
				.getPowerUpList().iterator(); itPower.hasNext();) {
			controller.GameObject pu = itPower.next();
			if (pu.intersect(userData.getPlayer())) {
				player.setActiveState(pu.getPowerUp());
				itPower.remove();
			}

		}
		/*
		 * Move the powerUps
		 */
		powerUpData.update();

		/*
		 * Adds gunshots
		 */
		if (clicked) {

			if (player.getPowerUp() instanceof states.StatePlayerPowerUpGun) {

				this.gunShotData.addGunShot(player.getX(), player.getY());
			}
			clicked = false;
		}
		/*
		 * Moves the gunshots.
		 */
		gunShotData.update();

		/*
		 * Collision handling for the gunshots
		 */
		for (Iterator<controller.GameObject> itG = gunShotData.getGunShotList()
				.iterator(); itG.hasNext();) {
			controller.GameObject g = itG.next();

			for (Iterator<controller.GameObject> it = objects.iterator(); it
					.hasNext();) {
				controller.GameObject ob = it.next();
				if (g.intersect(ob)) {
					ob.hit(g);
					itG.remove();
					if (ob.isDead()) {
						if (ob.hasPowerUp()) {
							powerUpData.addPowerUp(ob.getPowerUp(), ob.getX(),
									ob.getY());
						}
						ob.setHealth(1);
						explosion = new controller.Explosion((int) ob
								.getBounds().getCenterX(), (int) ob.getBounds()
								.getCenterY());
						it.remove();
						userData.increasePoints(100);

					}
					return;
				}
			}
		}

		result = new ArrayList<controller.GameObject>();
		for (controller.GameObject object : objects) {
			result.add(object);
		}
		for (controller.GameObject balls : ballList) {
			result.add(balls);
		}
		for (controller.GameObject powerUp : powerUpData.getPowerUpList()) {
			result.add(powerUp);
		}
		for (controller.GameObject gunShot : gunShotData.getGunShotList()) {
			result.add(gunShot);
		}

	}

	public ArrayList<controller.GameObject> getObjects() {
		return result;
	}
}
