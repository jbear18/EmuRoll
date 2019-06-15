import java.awt.Graphics;

public class MikesHead extends GameObject{

	public MikesHead(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
	}
void update() {
	x--;
	y+=8;
	
}
void draw(Graphics g) {
	 g.drawImage(GamePanel.evilguyImg, x, y, 70, 90, null);
}
}
