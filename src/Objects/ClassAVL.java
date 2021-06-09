package Objects;

import DataStructures.SimplyLinkedList;

import java.awt.*;

public class ClassAVL extends InvaderLine implements Drawable{

    public ClassAVL(int posX, int posY, int speed, int size, int lvl) {
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setEnemies(new SimplyLinkedList<Invader>());
        while(counter<size){
            if(counter == 0){
                String sprite = "Invader_1";

                Invader enemy = new Invader(posX=240,posY=130,50,50,lvl,speed,sprite);
                this.getEnemies().add(enemy);
            }
            if(counter == 1){
                String sprite = "Invader_1";

                Invader enemy = new Invader(posX=300,posY=70,50,50,lvl,speed,sprite);
                this.getEnemies().add(enemy);
            }
            if(counter == 2){
                String sprite = "Invader_1";

                Invader enemy = new Invader(posX=350,posY=130,50,50,lvl,speed,sprite);
                this.getEnemies().add(enemy);
            }
            if(counter == 3){
                String sprite = "Invader_1";

                Invader enemy = new Invader(posX=370,posY=10,50,50,lvl,speed,sprite);
                this.getEnemies().add(enemy);
            }
            if(counter == 4){
                String sprite = "Invader_1";

                Invader enemy = new Invader(posX=420,posY=130,50,50,lvl,speed,sprite);
                this.getEnemies().add(enemy);
            }
            if(counter == 5){
                String sprite = "Invader_1";

                Invader enemy = new Invader(posX=480,posY=70,50,50,lvl,speed,sprite);
                this.getEnemies().add(enemy);
            }
            if(counter == 6){
                String sprite = "Invader_1";

                Invader enemy = new Invader(posX=530,posY=130,50,50,lvl,speed,sprite);
                this.getEnemies().add(enemy);
            }
            counter++;
        }
        this.getEnemies().get(size/2).setBoss();
        this.setHaveBoss(true);
        this.setLineClass("Class AVL");
    }

    @ Override
    public void draw(Graphics2D g) {
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).draw(g);
        }
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void arrangeLine(){
        return;
    }
}
