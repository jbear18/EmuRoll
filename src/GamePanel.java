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
	Timer headSpawn;
	ObjectManager objectmanager;
	public static BufferedImage cloudImg;
	public static BufferedImage emuImg;
	public static BufferedImage evilguyImg;
	Emu emu = new Emu(250, 300, 349, 400);

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
		objectmanager = new ObjectManager(emu);
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Courier", Font.PLAIN, 50);
		emuFont = new Font("Courier New", Font.ITALIC, 40);
		regularFont = new Font("Courier New", Font.PLAIN, 30);
		try {
			cloudImg = ImageIO.read(this.getClass().getResourceAsStream("cloud.png"));
			emuImg = ImageIO.read(this.getClass().getResourceAsStream("emu.png"));
			evilguyImg = ImageIO.read(this.getClass().getResourceAsStream("evilguy.gif"));
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	public void startGame() {
	objectmanager.emu.isAlive= true;
		headSpawn = new Timer(1000, objectmanager);
		headSpawn.start();
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
		objectmanager.update();
		objectmanager.manageEnemies();
		objectmanager.checkCollision();
		objectmanager.purgeObjects();
		if (emu.isAlive == false) {
			CURRENT_STATE = END_STATE;
		}
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
		g.drawString("Instructions: Use arrow keys to go up, left, and right.Avoid obstacles and jump over them", 300,
				500);
		g.drawString("Game created by Jessie Shen", 800, 380);
		g.drawString("Press ENTER to start the war!!", 750, 700);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.green);

		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);
		g.setColor(new Color(141, 255, 2));
		g.fillRect(0, 0, MikeMackEmu.WIDTH, 500);
		g.setColor(new Color(186, 212, 255));
		g.fillRect(0, 0, MikeMackEmu.WIDTH, 400);
		g.drawImage(cloudImg, 1000, 100, 200, 100, null);
		objectmanager.draw(g);

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
		g.drawString("-You earned "+ objectmanager.score+ " points-", 750, 700);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			emu.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			emu.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (CURRENT_STATE == MENU_STATE) {

				CURRENT_STATE = GAME_STATE;
				startGame();
			}
		

			else if (CURRENT_STATE == GAME_STATE) {

				CURRENT_STATE = END_STATE;

			}

			else if (CURRENT_STATE == END_STATE) {

				CURRENT_STATE = MENU_STATE;
				startGame();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			emu.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			emu.right = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			emu.jump();

		}
	}
}
