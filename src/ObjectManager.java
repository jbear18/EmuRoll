import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JApplet;

public class ObjectManager implements ActionListener {
	Emu emu;
	public static AudioClip crowCaw;
	public static AudioClip endgame;
	int score = 0;
	long enemyTimer = 0;
	long slidingEnemyTimer = 0;
	int livesLeft;
//	int enemySpawnTime= 700;
	int enemySpawnTime = 1000000000;
	int slidingenemySpawnTime = 12000;
	ArrayList<MikesHead> heads = new ArrayList<MikesHead>();
	ArrayList<MikesHead> slidingheads = new ArrayList<MikesHead>();

	public ObjectManager(Emu emu) {
		this.emu = emu;
		loadSounds();
		livesLeft = 3;
	}

	void update() {

		emu.update();
		for (int i = 0; i < heads.size(); i++) {
			heads.get(i).update();

		}
		enemySpawnTime -= 0.0000000000000001;
		for (int i = 0; i < slidingheads.size(); i++) {
			slidingheads.get(i).update();

		}
		slidingenemySpawnTime -= 0.00000000000000001;
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

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			heads.add((new MikesHead(new Random().nextInt(MikeMackEmu.WIDTH), 0, 65, 65, 0)));

			enemyTimer = System.currentTimeMillis();
		} else if (System.currentTimeMillis() - slidingEnemyTimer >= slidingenemySpawnTime) {
			slidingheads.add((new MikesHead(MikeMackEmu.WIDTH, 600, 65, 65, 1)));

			slidingEnemyTimer = System.currentTimeMillis();
		}
		for (int i = 0; i < heads.size(); i++) {
			if (heads.get(i).y > MikeMackEmu.HEIGHT) {
				heads.get(i).isAlive = false;
				score++;
			}
		}
		for (int i = 0; i < slidingheads.size(); i++) {
			if (slidingheads.get(i).x > MikeMackEmu.WIDTH) {
				slidingheads.get(i).isAlive = false;
				score++;
			}
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < heads.size(); i++) {
			if (heads.get(i).y > MikeMackEmu.HEIGHT || heads.get(i).isAlive == false) {
				heads.remove(i);
				System.out.println(i);
			}
		}
		for (int i = 0; i < slidingheads.size(); i++) {
			if (slidingheads.get(i).x > MikeMackEmu.WIDTH || slidingheads.get(i).isAlive == false) {
				slidingheads.remove(i);
				System.out.println(i);
			}
		}
	}

	public void purgeAllObjects() {
		for (int i = 0; i < heads.size(); i++) {

			heads.remove(i);
			System.out.println(i);

		}
		for (int i = 0; i < slidingheads.size(); i++) {

			slidingheads.remove(i);
			System.out.println(i);

		}
	}

	public void checkCollision() {
		for (MikesHead mikeshead : heads) {
			
			if (emu.collidesWith(mikeshead.collisionBox)) {
				livesLeft--;
				mikeshead.isAlive = false;
				if (livesLeft < 1) {
					emu.isAlive = false;
				
					System.out.println("hi");
				}

			}

		}
		for (MikesHead mikeshead : slidingheads) {

			if (emu.collidesWith(mikeshead.collisionBox)) {

				livesLeft--;
				mikeshead.isAlive=false;
				if (livesLeft < 1) {
					emu.isAlive = false;
					
					System.out.println("hello");
				}

			}
		}
	}

	public int getScore() {
		return score;
	}

	public void loadSounds() {

		crowCaw = JApplet.newAudioClip(getClass().getResource("crow_caw.wav"));
		endgame = JApplet.newAudioClip(getClass().getResource("162800__timgormly__8-bit-flyby.wav"));

	}

	public static void playSound(String fileName) {
		if (fileName.equals("crow_caw.wav")) {
			crowCaw.play();
		}
		if (fileName.equals("162800__timgormly__8-bit-flyby.wav")) {
			endgame.play();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
