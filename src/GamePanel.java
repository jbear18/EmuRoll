import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	repaint();
	}
	public GamePanel() {
		timer = new Timer(1000/60, this);
	}
	public void startGame() {
		timer.start();
	}
	@Override

	public void paintComponent(Graphics g){
	    g.fillRect(10, 10, 100, 100);
	                

	        }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("jump");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("emu");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hi");
	}
}



	


