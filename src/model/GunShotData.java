package model;

import java.util.ArrayList;
import java.util.Iterator;

import controller.GameObject;
import controller.GameObjectFactory;

public class GunShotData {
	private int x;
	private int y;

	private ArrayList<GameObject> gunShotList;
	private final int PLAYER_WIDTH = 60; 

	public GunShotData() {
		this.gunShotList = new ArrayList<GameObject>();
	}

	public void addGunShot(int x, int y) {

		gunShotList.add(controller.GameObjectFactory.createGunShot(x+3,y));
		gunShotList.add(controller.GameObjectFactory.createGunShot(x+PLAYER_WIDTH-4,y));

	}

	public void update() {
		// TODO for every tick from timer, move accordingly.
		// *

		
		for (Iterator<controller.GameObject> it = gunShotList.iterator();it.hasNext();){
			controller.GameObject pu = it.next();
			pu.setCoordinates((int) pu.getBounds().getX(), (int) pu.getBounds()
					.getY() - 4);
			if (pu.getBounds().getY()<0){
			it.remove();
			}
			
		}
		

	}

	public ArrayList<GameObject> getGunShotList() {
		return gunShotList;
	}

}
