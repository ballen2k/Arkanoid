package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.GameData;
/**
 * Class for handling the mouse input.
 * 
 * @author Jeremia
 * 
 */
public class MouseInputController implements MouseListener, MouseMotionListener {
	private Player player;
	private GameData gameData;
	
	public MouseInputController(GameData gameData) {
		this.gameData = gameData;
		this.player = gameData.getPlayer();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getButton() == 1) {
			this.gameData.click(arg0.getX(), arg0.getY());
		} else {
			this.gameData.rightClick(arg0.getX(), arg0.getY());
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		this.gameData.click(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		gameData.mouseMove(arg0.getX(), arg0.getY());

	}

	public void mouseMoved(MouseEvent arg0) {
		
		gameData.mouseMove(arg0.getX(), arg0.getY());
	}

}
