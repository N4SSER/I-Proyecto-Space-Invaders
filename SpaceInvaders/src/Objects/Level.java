package Objects;

import java.awt.Graphics2D;
import java.util.Random;


public class Level implements Drawable {
	private InvaderLine current;
	private InvaderLine next;
	private int speed, lvl;
	
	public Level(int lvl) {
		current = new Basic(280*3/2, -60, 1, 7, lvl);
		next = this.createNewLine();
		speed = 0;
		this.lvl = lvl;
	}
	
	public InvaderLine createNewLine() {
		Random rand = new Random();
		int index = rand.nextInt(6);
		int size = 6;
		++speed;
		if(index == 0) {
			return new Basic(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 1) {
			return new ClassA(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 2) {
			return new ClassB(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 3) {
			return new ClassC(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 4) {
			return new ClassD(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 5) {
			return new ClassE(280*3/2, -60, speed, size, this.lvl);
		} else {
			return new Basic(280*3/2, -60, speed, size, this.lvl);
		}
	}

	public InvaderLine getCurrent() {
		return current;
	}
	
	public void nextLine() {
		current = next;
		next = this.createNewLine();
	}

	public int getSpeed() {
		return speed;
	}

	public InvaderLine getNext() {
		return next;
	}

	@Override
	public void draw(Graphics2D g) {
		this.current.draw(g);
	}

	@Override
	public void update(double delta) {
		if((current.getLineClass() == "ClassA" || current.getLineClass() == "ClassB" || current.getLineClass() == "ClassE") && !current.isHaveBoss()) {
			this.nextLine();
			return;
		} else if(current.getEnemies().size() == 0) {
			this.nextLine();
			return;
		}
		for(int i = 0; i < this.current.getEnemies().size(); i++) {
			if(current.getEnemies().get(i).getPosY() > 600) {
				this.nextLine();
				return;
			}
		}
		if(current.getEnemies().size() == 0) {
			this.nextLine();
		}
		this.current.update(delta);
	}
}
