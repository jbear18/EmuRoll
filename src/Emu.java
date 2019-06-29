import java.awt.Color;
import java.awt.Graphics;

public class Emu extends GameObject{
	int speed;
	boolean left;
	boolean right;
	int velocity=0;
	boolean isJumping= false;


	public Emu(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		// TODO Auto-generated constructor stub
	}
void update() {
	super.update();
	if(left==true) {
	x-=speed;	
	}
	if( right==true) {
		x+=speed;
	}
	if(isJumping) {
		velocity--;
		y=y-velocity;
		if(y>300) {
		y=300;
		isJumping=false;
		}
	}

}
public void jump() {
	isJumping=true;
	velocity=15 ;


}
void draw(Graphics g) {
    g.drawImage(GamePanel.emuImg, x, y, 400, 400, null);
//    g.setColor(Color.red);
//g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
}
}
