package view;

import java.awt.Cursor;

import javax.swing.JFrame;

import model.GameData;

public class Interface extends JFrame {
	private static final long serialVersionUID = 1L;

	GameView gameView;
	GameData gameData;

	/*
	 * Creates the interface on which the game will be shown
	 */
	public Interface() {
		gameData = new GameData();
		this.setTitle("OMG ARKANÖID");
		gameView = new GameView(gameData);
		this.setVisible(true);
		this.setSize(500, 500);
		this.add(gameView);
		gameData.addObserver(gameView);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
