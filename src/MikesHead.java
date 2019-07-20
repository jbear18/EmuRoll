import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MikesHead extends GameObject {

	float angle = 0;
	int type = 0;

	public MikesHead(int x, int y, int width, int height, int type) {
		super(x, y, width, height);
		this.type = type;

		// TODO Auto-generated constructor stub

	}

	void update() {
		super.update();
		if (type == 0) {
			x--;
			y += 8;	
		}
		if (type == 1) {
			x--;
		}
angle -=0.04;
	}

	void draw(Graphics g) {
		if (type == 0) {
			g.drawImage(GamePanel.mikeImg, x, y, width, height, null);	
		}
		if (type == 1) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.rotate(angle,x+width/2,y+height/2);
			g2d.drawImage(GamePanel.mikeImg, x, y, width, height, null);
			g2d.rotate(-angle,x+width/2,y+height/2);
			g2d.dispose();
	
		}

		
		super.draw(g);
//	 g.setColor(Color.red);
//	 g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
}
