import java.awt.Graphics;

public class MikesHead extends GameObject{

	public MikesHead(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
	}
void update() {
	x--;
}
void draw(Graphics g) {
	 g.drawImage(GamePanel.headImg, x, y, 900, 400, null);
}
}
