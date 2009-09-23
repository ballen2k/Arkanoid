package model;

import java.util.ArrayList;

import controller.PowerUp;

public class PowerUpData {
 int x;
 int y;
 
 private ArrayList<PowerUp> powerUpList;
 
 
 
 
	public void doYourStuff() {
		// TODO for every tick from timer, move accordingly.
		//*
		for(PowerUp pu : powerUpList){
			pu.setCoordinates(x, y+10);
		}
		
		
		
		
	}

}
