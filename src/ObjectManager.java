import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Emu emu;
	ArrayList <MikesHead> heads= new ArrayList <MikesHead>();
public ObjectManager(Emu emu) {
	this.emu= emu;
}
void update() {
	
	emu.update();
}
void draw(Graphics g) {
	emu.draw(g);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	heads.add(new MikesHead(600,400,10,10));
}

}
