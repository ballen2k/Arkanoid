package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.GameObject;
import controller.MouseInputController;

import model.GameData;
import model.LevelData;

public class GameView extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;

	private GameData gameData;
/*
 * Here's where all the action is.
 */
	public GameView(GameData gameData) {
		this.gameData = gameData;
		this.setBackground(Color.black);
		
		this.addMouseListener(new MouseInputController(gameData));
		this.addMouseMotionListener(new MouseInputController(gameData));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(GameObject go : gameData.getLevelData().getCurrentLevel().getLevel()){
			go.draw(g);
		}
		for(GameObject go : gameData.getBallData().getBallList()){
			go.draw(g);
		}
		gameData.getPlayer().draw(g);
		

	}


	public void update(Observable arg0, Object arg1) {
		repaint();
		
	}
}
