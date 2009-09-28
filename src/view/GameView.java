package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.GameObject;
import controller.MouseInputController;

import model.GameData;
import model.LevelData;

public class GameView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	private GameData gameData;
	private states.State activeState = new states.StateMenu();
	private ArrayList<controller.GameObject> drawObjects;
	
	private model.UserData userData;
	
	/*
	 * Here's where all the action is.
	 */
	public GameView(GameData gameData) {
		drawObjects = new ArrayList<controller.GameObject>();
		activeState = new states.StateMenu();
		userData = new model.UserData(0,0);
		this.gameData = gameData;
		this.setBackground(Color.black);

		this.addMouseListener(new MouseInputController(gameData));
		this.addMouseMotionListener(new MouseInputController(gameData));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		activeState.draw(g, drawObjects, userData);
	}

	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof ArrayList<?>) {
			drawObjects = (ArrayList<controller.GameObject>)arg1;
		} else if(arg1 instanceof states.State) {
			activeState = (states.State)arg1;
		} else if(arg1 instanceof model.UserData) {
			userData = (model.UserData)arg1;
		}
		repaint();
	}
}
