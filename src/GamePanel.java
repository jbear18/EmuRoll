import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	
	int CURRENT_STATE= MENU_STATE;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	repaint();
	  if(CURRENT_STATE == MENU_STATE){

          updateMenuState();

  }else if(CURRENT_STATE == GAME_STATE){

          updateGameState();

  }else if(CURRENT_STATE == END_STATE){

          updateEndState();

  }


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
		  if(CURRENT_STATE == MENU_STATE){

	        drawMenuState(g);

	  }else if(CURRENT_STATE == GAME_STATE){

	        drawGameState(g);

	  }else if(CURRENT_STATE == END_STATE){

	          drawEndState(g);
	  }

  

	        }
	void updateMenuState() {
		
	}
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.yellow);

		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);    
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.green);

		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);    
}
	void drawEndState(Graphics g) {
		g.setColor(Color.red);

		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);    
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("jump");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if(CURRENT_STATE == MENU_STATE){

            CURRENT_STATE = GAME_STATE;

    }

		else if(CURRENT_STATE == GAME_STATE){

            CURRENT_STATE = END_STATE;

    }

		else if(CURRENT_STATE == END_STATE){

            CURRENT_STATE = MENU_STATE;

    }


	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hi");
	}
}



	


