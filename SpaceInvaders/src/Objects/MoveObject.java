package Objects;

import java.awt.*;

public class MoveObject extends GameObject{
    private int speed;
    private boolean collide;
    private Rectangle rect;

    public MoveObject(int posX, int posY, int width, int height, int speed, String spriteName) {
        super(posX, posY, width, height, spriteName);
        this.speed = speed;
        this.collide = false;
        this.rect = new Rectangle(posX, posY, width, height);
    }

    public int getSpeed() {
        return speed;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect() {
        this.rect = new Rectangle(this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
    }

    public boolean isColliding(MoveObject other) {
        collide = other.getRect().intersects(this.getRect());
        return collide;
    }
}
