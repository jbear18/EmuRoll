import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	public static BufferedImage cloudImg;
	public static BufferedImage emuImg;
	Rocketship rocket = new Rocketship(250, 300, 50, 50);

	Font titleFont;

	Font emuFont;

	Font regularFont;

	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	int CURRENT_STATE = MENU_STATE;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (CURRENT_STATE == MENU_STATE) {

			updateMenuState();

		} else if (CURRENT_STATE == GAME_STATE) {

			updateGameState();

		} else if (CURRENT_STATE == END_STATE) {

			updateEndState();

		}

	}

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Courier", Font.PLAIN, 50);
		emuFont = new Font("Courier New", Font.ITALIC, 40);
		regularFont = new Font("Courier New", Font.PLAIN, 30);
		 try {
             cloudImg = ImageIO.read(this.getClass().getResourceAsStream("cloud.png"));
             emuImg = ImageIO.read(this.getClass().getResourceAsStream("emu.png"));
     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     }
	}

	public void startGame() {
		timer.start();
	}

	@Override

	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		if (CURRENT_STATE == MENU_STATE) {

			drawMenuState(g);

		} else if (CURRENT_STATE == GAME_STATE) {

			drawGameState(g);

		} else if (CURRENT_STATE == END_STATE) {

			drawEndState(g);
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {
		rocket.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.yellow);

		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Emu Roll", 900, 200);
		g.setFont(emuFont);
		g.drawString("emu vs mike", 900, 250);
		g.setFont(regularFont);
		g.drawString("Instructions: Use arrow keys to go up, left, right.Jump over obstacles", 300, 500);
		g.drawString("Game created by Jessie Shen", 800, 380);
		g.drawString("Press ENTER to start the war!!", 750, 700);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.green);

		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);
		g.setColor(new Color (141, 255, 2));
g.fillRect(0, 0, MikeMackEmu.WIDTH, 500);
		g.setColor(new Color (186,212,255));
		g.fillRect(0, 0, MikeMackEmu.WIDTH, 400);
		 g.drawImage(cloudImg, 1000, 100, 200, 100, null);
		rocket.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);

		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("༼ つ ಥ_ಥ ༽つ", 900, 200);
		g.setFont(emuFont);
		g.drawString("...death", 900, 250);
		g.setFont(regularFont);
		g.drawString("mike has won. his head shall haunt you forever", 700, 380);
		g.drawString("-You earned 0 points-", 750, 700);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("jump");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
if(e.getKeyCode()==37) {
	rocket.left=true;
}
if(e.getKeyCode()==39) {
	rocket.right=true;
}
if(e.getKeyCode()==10) {
	if (CURRENT_STATE == MENU_STATE) {

		CURRENT_STATE = GAME_STATE;

	}

	else if (CURRENT_STATE == GAME_STATE) {

		CURRENT_STATE = END_STATE;

	}

	else if (CURRENT_STATE == END_STATE) {

		CURRENT_STATE = MENU_STATE;

	}
}


}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==37) {
			rocket.left=false;
		}
		if(e.getKeyCode()==39) {
			rocket.right=false;
		}
	}
}
