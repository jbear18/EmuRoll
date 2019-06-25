import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Emu emu;
long enemyTimer=0;
long slidingEnemyTimer= 0;
	int enemySpawnTime= 700;
	int slidingenemySpawnTime= 12000;
	ArrayList <MikesHead> heads= new ArrayList <MikesHead>();
	ArrayList<MikesHead>slidingheads= new ArrayList <MikesHead>();
public ObjectManager(Emu emu) {
	this.emu= emu;
}
void update() {
	
	emu.update();
	for (int i = 0; i < heads.size(); i++) {
	heads.get(i).update();	
	}
	for (int i = 0; i < slidingheads.size(); i++) {
	slidingheads.get(i).update();	
	}
}
void draw(Graphics g) {
	emu.draw(g);
	for (int i = 0; i < heads.size(); i++) {
	heads.get(i).draw(g);

	}
	for (int i = 0; i < slidingheads.size(); i++) {
		slidingheads.get(i).draw(g);

		}
}
public void manageEnemies(){
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            heads.add((new MikesHead(new Random().nextInt(MikeMackEmu.WIDTH), 0, 5, 5, 0)));
           

enemyTimer = System.currentTimeMillis();
    }
    else  if(System.currentTimeMillis() - slidingEnemyTimer >= slidingenemySpawnTime){ 
        slidingheads.add((new MikesHead(MikeMackEmu.WIDTH, 600, 5, 5, 1)));

slidingEnemyTimer = System.currentTimeMillis();
}
for (int i = 0; i < heads.size(); i++) {
	if(heads.get(i).y>MikeMackEmu.HEIGHT) {
heads.get(i).isAlive=false;
	}
}
for (int i = 0; i < slidingheads.size(); i++) {
	if(slidingheads.get(i).x>MikeMackEmu.WIDTH) {
slidingheads.get(i).isAlive=false;
	}
}
}
public void purgeObjects() {
for (int i = 0; i < heads.size(); i++) {
	if(heads.get(i).y>MikeMackEmu.HEIGHT) {
		heads.remove(i);
		System.out.println(i);
	}
}	
for (int i = 0; i < slidingheads.size(); i++) {
	if(slidingheads.get(i).x>MikeMackEmu.WIDTH) {
		slidingheads.remove(i);
		System.out.println(i);
	}
}	
}
public void checkCollision() {
	for(MikesHead mikeshead : heads){

        if(emu.collisionBox.intersects(mikeshead.collisionBox)){

                emu.isAlive = false;
System.out.println("hi");
        }
    

}
	for(MikesHead mikeshead : slidingheads){

        if(emu.collisionBox.intersects(mikeshead.collisionBox)){

                emu.isAlive = false;
System.out.println("hello");
        }
	}
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

}
