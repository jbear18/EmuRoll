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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	Timer headSpawn;
	ObjectManager objectmanager;

	public static BufferedImage cloudImg;
	public static BufferedImage emuImg;
	public static BufferedImage evilguyImg;
	public static BufferedImage pixelheartImg;
	public static BufferedImage noColorPixelHeartImg;
	public static BufferedImage animatedEmuImg;
	public static BufferedImage ostrichImg;
	public static BufferedImage mikeImg;

	Emu emu = new Emu(250, 400, 249, 300);

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
		objectmanager.playSound("162800__timgormly__8-bit-flyby.wav");
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Courier", Font.PLAIN, 50);
		emuFont = new Font("Courier New", Font.ITALIC, 40);
		regularFont = new Font("Courier New", Font.PLAIN, 30);
		try {
			cloudImg = ImageIO.read(this.getClass().getResourceAsStream("cloud.png"));
			emuImg = ImageIO.read(this.getClass().getResourceAsStream("emu.png"));
			evilguyImg = ImageIO.read(this.getClass().getResourceAsStream("evilguy.gif"));
			pixelheartImg = ImageIO.read(this.getClass().getResourceAsStream("pixelheart.png"));
			noColorPixelHeartImg = ImageIO.read(this.getClass().getResourceAsStream("noColorPixelHeart.png"));
			animatedEmuImg = ImageIO.read(this.getClass().getResourceAsStream("animatedEmu.animated.gif"));
			ostrichImg = ImageIO.read(this.getClass().getResourceAsStream("sadostrich.jpg"));
			mikeImg = ImageIO.read(this.getClass().getResourceAsStream("mike-2.png"));
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	public void startGame() {
		objectmanager.purgeAllObjects();
		objectmanager.emu.isAlive = true;
		objectmanager.livesLeft = 3;
		objectmanager.emu.x = 250;
		headSpawn = new Timer(1000, objectmanager);
		objectmanager.enemySpawnTime=800;
		objectmanager.slidingenemySpawnTime=12000;
		headSpawn.start();
		timer.start();
		objectmanager.score = 0;

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

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);
		g.drawImage(animatedEmuImg, 30, 500, 300, 290, null);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("Emu Roll", 900, 200);
		g.setFont(emuFont);
		g.drawString("emu vs mike", 900, 250);
		g.setFont(regularFont);
		g.drawString("Press SPACE for instructions", 800, 500);
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

		if (objectmanager.emu.isAlive) {
			if (objectmanager.livesLeft > 0) {
				g.drawImage(pixelheartImg, 70, 70, 90, 85, null);
			}
			if (objectmanager.livesLeft > 1) {
				g.drawImage(pixelheartImg, 150, 70, 90, 85, null);
			}
			if (objectmanager.livesLeft > 2) {
				g.drawImage(pixelheartImg, 230, 70, 90, 85, null);
			}
		}
g.setColor(Color.black);
g.drawString(objectmanager.score+ "", 200,50);
//		if (objectmanager.emu.isAlive == false) {
//			g.drawImage(noColorPixelHeartImg, 230, 70, 90, 85, null);
//		}
		objectmanager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(new Color(130, 9, 31));
		g.fillRect(0, 0, MikeMackEmu.WIDTH, MikeMackEmu.HEIGHT);
		g.drawImage(ostrichImg, 100, 300, 400, 400, null);
		g.setColor(Color.white);
		g.setFont(titleFont);
		g.drawString("༼ つ ಥ_ಥ ༽つ", 900, 200);
		g.setFont(emuFont);
		g.drawString("...death", 900, 250);
		g.setFont(regularFont);
		g.drawString("Press ENTER to restart", 700, 500);
		g.drawString("-You earned " + objectmanager.score + " points-", 750, 700);

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
			objectmanager.playSound("crow_caw.wav");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			emu.right = true;
			objectmanager.playSound("crow_caw.wav");
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (CURRENT_STATE == MENU_STATE) {

				CURRENT_STATE = GAME_STATE;
				startGame();
				objectmanager.playSound("crow_caw.wav");
			}

			else if (CURRENT_STATE == GAME_STATE) {

				CURRENT_STATE = END_STATE;
				objectmanager.playSound("162800__timgormly__8-bit-flyby.wav");
			}

			else if (CURRENT_STATE == END_STATE) {

				CURRENT_STATE = MENU_STATE;
				startGame();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			emu.jump();

		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null,
					"You are the emu.\n"
					+ "Dodge the rolling heads, and the heads that are coming from the sky.\n"
							+ "Use the left and right arrow keys to move, and the up arrow key with the left or right to jump.\n"
							+ "You will get 3 lives, which are kept track as hearts. Have fun (If you lasts long enough, there is a crazy SURPRISE)!!");

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

	}
}
