package Objects;

import java.awt.Graphics2D;
import java.util.Random;

/**
 * Construye la base del nivel que se mostrará en pantalla
 */

public class Level implements Drawable {
	private InvaderLine current;
	private InvaderLine next;
	private int speed, lvl;
	
	public Level(int lvl) {
		current = this.createNewLine();
		next = this.createNewLine();
		speed = 0;
		this.lvl = lvl;
	}

	/**
	 * Crea la clase enemiga a mostrar
	 * @return retornauna hilera de forma aleatoria
	 */
	public InvaderLine createNewLine() {
		Random rand = new Random();
		int index = rand.nextInt(7);
		int size = 7;
		++speed;
		if(index == 0) {
			//Basic
			return new ClassAVL(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 1) {
			//A
			return new ClassAVL(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 2) {
			//B
			return new ClassAVL(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 3) {
			//C
			return new ClassAVL(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 4) {
			//D
			return new ClassAVL(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 5) {
			//E
			return new ClassAVL(280*3/2, -60, speed, size, this.lvl);
		} else if(index == 6){
			//AVL
			return new ClassAVL(280*3/2,-60,speed,size,this.lvl);
		} else {
			//Basic
			return new ClassAVL(280*3/2, -60, speed, size, this.lvl);
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


	@Override
	public void draw(Graphics2D g) {
		this.current.draw(g);
	}

	@Override
	public void update(double delta) {
		// Si las siguientes clases no poseen ya el jefe, continue con la siguiente hilera
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

		this.current.update(delta);
	}
}
