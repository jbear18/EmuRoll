import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;

	int y;

	int width;

	int height;

	boolean isAlive = true;
	Rectangle collisionBox;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
	}

	void update() {
		collisionBox = new Rectangle(x, y, width, height);
		x+=5;
		y+=5;
	}

	void draw(Graphics g) {
	    g.fillRect(x, y, width, height);
	}
}
