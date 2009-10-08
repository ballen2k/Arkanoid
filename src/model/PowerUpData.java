package model;

import java.util.ArrayList;
import java.util.Iterator;

import controller.GameObject;
import controller.GameObjectFactory;
/**
 * Manages powerups
 */
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

	public void update(GameData gameData, UserData userData) {
		// TODO for every tick from timer, move accordingly.
		// *
		
		for (Iterator<controller.GameObject> itPower = getPowerUpList().iterator(); itPower.hasNext();) {
			controller.GameObject pu = itPower.next();
			if (pu.intersect(userData.getPlayer())) {
				pu.getPowerUp().update(gameData, userData);
				itPower.remove();
				userData.increasePoints(100);
			}
		}
		
		for (Iterator<controller.GameObject> it = powerUpList.iterator();it.hasNext();){
			controller.GameObject pu = it.next();
			pu.setCoordinates((int) pu.getBounds().getX(), (int) pu.getBounds()
					.getY() + 2);
			if (pu.getBounds().getY()>500){
			it.remove();
			}
			
		}
		

	}

	public ArrayList<GameObject> getPowerUpList() {
		return powerUpList;
	}

}
