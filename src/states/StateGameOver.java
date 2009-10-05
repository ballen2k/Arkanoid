package states;
import java.awt.*;
import java.util.*;

public class StateGameOver extends State{
	
	public void update(model.GameData gameData, model.UserData userData) {
		gameData.getLevelManager().loadLevels();
	}
	
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) {
		g.setColor(Color.red);
		g.drawString("GAME OVER", 190, 150);
	}
}
