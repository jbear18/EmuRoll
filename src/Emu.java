import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Emu extends GameObject{
	int speed;
	boolean left;
	boolean right;
	int velocity=0;
	boolean isJumping= false;
	Rectangle head;
	Rectangle body;
	Rectangle neck;
	Rectangle legs;


	public Emu(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		head=new Rectangle();
		neck=new Rectangle();
		body=new Rectangle();
		legs=new Rectangle();
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
//	head.setBounds(x+7/11*width,y+2/11*width,width/8,height/10);
//	body.setBounds(x,y,width,height);
//	legs.setBounds(x,y,width,height);
//	neck.setBounds(x,y,width,height);

}
public void jump() {
	isJumping=true;
	velocity=15 ;


}
void draw(Graphics g) {
    g.drawImage(GamePanel.emuImg, x, y, width, height, null);
    super.draw(g);
//    g.setColor(Color.red);
//g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
}
}
