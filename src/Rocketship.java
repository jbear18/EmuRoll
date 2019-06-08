import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	boolean left;
	boolean right;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=5;
		// TODO Auto-generated constructor stub
	}
void update() {
	if(left==true) {
	x-=speed;	
	}
	if( right==true) {
		x+=speed;
	}
}
void draw(Graphics g) {
    g.drawImage(GamePanel.emuImg, x, y, 400, 400, null);

}
}
