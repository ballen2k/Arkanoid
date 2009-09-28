package model;

public class UserData {
	private int numberOfLifes = 0;
	private int points = 0;
	private controller.Player player;
	
	public UserData(int lifes, int points) {
		this.numberOfLifes = lifes;
		this.points = points;
		this.player = new controller.Player();
	}
	
	public controller.Player getPlayer() {
		return this.player;
	}
	
	public void decreaseNumberOfLifes() {
		this.numberOfLifes = this.numberOfLifes - 1;
	}
	
	public void increaseNumberOfLifes() {
		this.numberOfLifes += 1; 
	}
	
	public int getNumberOfLifes() {
		return this.numberOfLifes;
	}
	
	public void increasePoints(int increase) {
		this.points += increase;
	}
	
	public int getPoints() {
		return this.points;
	}
}
