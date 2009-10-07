package model;

import java.util.ArrayList;
import java.util.Iterator;

import controller.AePlayWave;
import controller.GameObject;
import controller.GameObjectFactory;

public class GunShotData {
	private int x;
	private int y;

	private ArrayList<GameObject> gunShotList;
	private final int PLAYER_WIDTH = 60; 
	
	private boolean clicked = false; 
	private int pos_x, pos_y;

	public GunShotData() {
		this.gunShotList = new ArrayList<GameObject>();
	}

	public void addGunShot(int x, int y) {

		gunShotList.add(controller.GameObjectFactory.createGunShot(x+3,y));
		gunShotList.add(controller.GameObjectFactory.createGunShot(x+PLAYER_WIDTH-4,y));

	}
	
	public void setClick(int pos_x, int pos_y) {
		this.clicked = true; 
		this.pos_x = pos_x;
		this.pos_y = pos_y; 
	}

	public void update(GameData gameData, UserData userData, ArrayList<GameObject> objects) {
		// TODO for every tick from timer, move accordingly.
		// *
		if(clicked) {
			if (userData.getPlayer().getPowerUp() instanceof states.StatePlayerPowerUpGun) {
				//new AePlayWave("img\\test.wav").start();

				addGunShot(userData.getPlayer().getX(), userData.getPlayer().getY());
			}
			clicked = false;
		}
		
		for (Iterator<controller.GameObject> it = gunShotList.iterator();it.hasNext();){
			controller.GameObject pu = it.next();
			pu.setCoordinates((int) pu.getBounds().getX(), (int) pu.getBounds()
					.getY() - 4);
			if (pu.getBounds().getY()<0){
			it.remove();
			}
			
		}
		
		for (Iterator<controller.GameObject> itG = getGunShotList()
				.iterator(); itG.hasNext();) {
			controller.GameObject g = itG.next();

			for (Iterator<controller.GameObject> it = objects.iterator(); it
					.hasNext();) {
				controller.GameObject ob = it.next();
				if (g.intersect(ob)) {
					ob.hit(g);

					itG.remove();
					if (ob.isDead()) {
						new AePlayWave("img\\exp.wav").start();
						if (ob.hasPowerUp()) {
							gameData.getPowerUpData().addPowerUp(ob.getPowerUp(), ob.getX(),
									ob.getY());
						}
						ob.setHealth(1);
						it.remove();
						userData.increasePoints(100);

					} else {
						new AePlayWave("img\\hit.wav").start();
					}
					return;
				}
			}
		}
		

	}

	public ArrayList<GameObject> getGunShotList() {
		return gunShotList;
	}

}
