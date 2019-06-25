import java.awt.Color;
import java.awt.Graphics;

public class MikesHead extends GameObject{

int type=0;
	public MikesHead(int x, int y, int width, int height, int type) {
		super(x, y, width, height);
		this.type=type;
		
		// TODO Auto-generated constructor stub
		
	}
void update() {
	super.update();
	if(type==0) {
		x--;
		y+=8;
	}
if(type==1) {
	x--;
}
	
}
void draw(Graphics g) {
	 g.drawImage(GamePanel.evilguyImg, x, y, 70, 90, null);
//	 g.setColor(Color.red);
//	 g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
}
}
