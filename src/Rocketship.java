import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {
	
}
void draw(Graphics g) {
	 g.setColor(Color.BLACK);
g.fillRect(x, y, 50, 100);
}
}
