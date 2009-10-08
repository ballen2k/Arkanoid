package model;

/**
 * Class for managing users data, points, lifes 
 */
public class UserData {
	private int numberOfLifes = 0;
	private int points = 0;
	private controller.Player player;
	
	public UserData(int lifes, int points) {
		this.numberOfLifes = lifes;
		this.points = points;
		this.player = new controller.Player();
	}
	
	/**
	 * Returns active player
	 * @return player
	 */
	public controller.Player getPlayer() {
		return this.player;
	}
	
	/**
	 * Decrease lifes
	 */
	public void decreaseNumberOfLifes() {
		this.numberOfLifes = this.numberOfLifes - 1;
	}
	
	/**
	 * Increase number of lifes
	 */
	public void increaseNumberOfLifes() {
		this.numberOfLifes += 1; 
	}
	
	/**
	 * Returns number of lifes
	 * @return numberOfLifes
	 */
	public int getNumberOfLifes() {
		return this.numberOfLifes;
	}
	
	/**
	 * Increase points with increase
	 * @param increase number of points
	 */
	public void increasePoints(int increase) {
		this.points += increase;
	}
	

	/** 
	 * Returns points
	 * @return
	 */
	public int getPoints() {
		return this.points;
	}
}
