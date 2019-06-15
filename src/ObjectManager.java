import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Emu emu;
long enemyTimer=0;
	int enemySpawnTime= 700;
	ArrayList <MikesHead> heads= new ArrayList <MikesHead>();
public ObjectManager(Emu emu) {
	this.emu= emu;
}
void update() {
	
	emu.update();
	for (int i = 0; i < heads.size(); i++) {
	heads.get(i).update();	
	}
}
void draw(Graphics g) {
	emu.draw(g);
	for (int i = 0; i < heads.size(); i++) {
	heads.get(i).draw(g);
	emu.update();
	}
}
public void manageEnemies(){
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            heads.add((new MikesHead(new Random().nextInt(MikeMackEmu.WIDTH), 0, 5, 5)));

enemyTimer = System.currentTimeMillis();
    }
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

}
