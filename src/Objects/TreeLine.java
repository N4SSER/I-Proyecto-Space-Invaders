package Objects;

import DataStructures.List;
import display.Timer;

public abstract class TreeLine  implements Drawable{
    private int posX,posY,speed;
    private Timer timer;
    private String treeClass;
    private Invader enemies;
    private boolean haveBoss;

    public TreeLine(int posX,int posY, int speed, int size,int lvl){
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.treeClass = "EnemyTree";
        this.timer = new Timer();
    }

    public Invader obtainEnemies(){
        return enemies;
    }

    public void SetEnemies(Invader enemies){
        this.enemies = enemies;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public int getSpeed(){
        return speed;
    }

    public Timer getTimer(){
        return timer;
    }

    public String getTreeClass(){
        return treeClass;
    }

    public void setTreeClass(String treeClass){
        this.treeClass = treeClass;
    }

    public boolean isHaveBoss(){
        return haveBoss;
    }

    public void setHaveBoss(boolean haveBoss){
        this.haveBoss = haveBoss;
    }

    public void arrangeTree(){

    }
}
