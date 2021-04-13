package Objects;

import java.awt.Graphics2D;
import java.util.Random;

import DataStructures.DoubleLinkedList;


public class ClassB extends InvaderLine implements Drawable {
	private boolean change;
	private int bossIndex;
	
	public ClassB(int posX, int posY, int speed, int size, int lvl) {
		super(posX, posY, speed, size, lvl);
		int counter = 0;
		this.setEnemies(new DoubleLinkedList<>());
		while(counter < size) {

			String sprite = "Invader_1";

			Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
			this.getEnemies().add(enemy);
			counter++;
		}
		this.change = false;
		Random rand = new Random();
		int randBoss = rand.nextInt(this.getEnemies().size()-1);
		this.getEnemies().get(randBoss).setBoss();
		this.setHaveBoss(true);
		this.bossIndex = randBoss;
		this.setLineClass("ClassB");
	}
	
	@ Override
	public void draw(Graphics2D g) {
		try {
			for(int c = 0; c < this.getEnemies().size(); c++) {
				this.getEnemies().get(c).draw(g);
			}
		} catch(Exception e) {
			this.draw(g);
		}
	}
	
	@ Override
	public void update(double delta) {
		this.setHaveBoss(false);
		for(int c = 0; c < this.getEnemies().size(); c++) {
			this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY()+this.getSpeed());
			this.getEnemies().get(c).update(delta);
			if(this.getEnemies().get(c).isBoss()) {
				this.setHaveBoss(true);
			}
		}


		if(this.getTimer().timerEvent(2000)) {
			if (change && this.getEnemies().size() > 2) {
				Random rand = new Random();
				int newPos = rand.nextInt(this.getEnemies().size() - 1);
				this.getEnemies().swap(bossIndex, newPos);
				bossIndex = newPos;
				change = false;
			} else {
				change = true;
			}
		}
	}
}
