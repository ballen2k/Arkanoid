package states;
import java.awt.*;
import java.util.*;

public class StateGameOver extends State{
	public void draw(Graphics g, ArrayList<controller.GameObject> objectList, model.UserData userData) {
		g.setColor(Color.red);
		g.drawString("GAME OVER", 190, 150);
	}
}
