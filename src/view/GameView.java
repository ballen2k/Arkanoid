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
	private states.State activeState;
	private ArrayList<controller.GameObject> drawObjects;
	
	/*
	 * Here's where all the action is.
	 */
	public GameView(GameData gameData) {
		drawObjects = new ArrayList<controller.GameObject>();
		activeState = new states.StateMenu();
		this.gameData = gameData;
		this.setBackground(Color.black);

		this.addMouseListener(new MouseInputController(gameData));
		this.addMouseMotionListener(new MouseInputController(gameData));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (activeState instanceof states.StateMenu || activeState instanceof states.StateGameOver) {
			if(activeState instanceof states.StateGameOver) {
				g.setColor(Color.red);
				g.drawString("GAME OVER", 190, 150);
			}
			
			g.setColor(Color.orange);
		
			for(controller.GameObject ob :drawObjects) {
				ob.draw(g);
			}
		} else if(activeState instanceof states.StatePlay) {
			g.setColor(Color.green);
			for (GameObject go : drawObjects) {
				go.draw(g);
			}

			g.setColor(Color.black);
			g.fillRect(0, 445, 1000, 200);
			g.setColor(Color.green);
			g.drawLine(0, 445, 500, 445);
			g.drawString("Lives: "
					+ Integer.toString(gameData.getPlayer().getHealth()), 50,
					460);
			g.drawString("Points: "
					+ Integer.toString(gameData.points), 150, 460);

			gameData.getPlayer().draw(g);
		} else if(activeState instanceof states.StateExit) {
			System.exit(0);
		}
	}

	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof ArrayList<?>) {
			drawObjects = (ArrayList<controller.GameObject>)arg1;
		} else if(arg1 instanceof states.State) {
			activeState = (states.State)arg1;
		}
		repaint();
	}
}
