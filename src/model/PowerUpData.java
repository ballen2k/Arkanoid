package model;

import java.util.ArrayList;

import controller.GameObject;
import controller.GameObjectFactory;

public class PowerUpData {
	int x;
	int y;

	private ArrayList<GameObject> powerUpList;

	public PowerUpData() {
		this.powerUpList = new ArrayList<GameObject>();
	}

	public void addPowerUp(states.State powerUp, int x, int y) {

		powerUpList.add(controller.GameObjectFactory.createPowerUp(powerUp, x,
				y));

	}

	public void update() {
		// TODO for every tick from timer, move accordingly.
		// *

		for (GameObject pu : powerUpList) {
			pu.setCoordinates((int) pu.getBounds().getX(), (int) pu.getBounds()
					.getY() + 2);

		}

	}

	public ArrayList<GameObject> getPowerUpList() {
		return powerUpList;
	}

}
