package entity;

public class Tileset extends Entity{

    private String factory;
    private int x;
    private int y;


    public Tileset(final String factory, final int x, final int y) {
        this.factory = factory;
        this.x = x;
        this.y = y;

    }

    public String getFactory() {return this.factory;}

    public void setFactory() {

    }


    public void setFactory(final String Factory) {
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
