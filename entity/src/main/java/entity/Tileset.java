package entity;

public class Tileset extends Entity{

    private Factory factory;
    private int x;
    private int y;


    public Tileset(final Factory factory, final int x, final int y) {
        this.factory = factory;
        this.x = x;
        this.y = y;

    }

    public Factory getFactory() {return this.factory;}

    public void setFactory(final Factory factory) {
        this.factory = (factory);
    }

    public int getX() { return this.x;}

    public void setX() {

    }


    public void setX(final int x) {
        this.x = (x);
    }

    public int getY() {
        return this.y;
    }

    public void setY() {

    }


    public void setY(final int y) {
        this.y = (y);
    }
}
