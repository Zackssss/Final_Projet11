package entity;

/**
 * The Class Tileset.
 *
 * Sets the Factory objects infos from the DAOs GetMAP stocked procedure
 *
 * @author Zachary Morello &amp;&amp; Hugo Bouillon
 */

public class Tileset{

    /** The factory */

    private Factory factory;

    /** The x */

    private int x;

    /** The y */
    private int y;

    /**
     *Instantiates a new Tileset
     *
     * @param factory
     *             the object
     * @param x
     *      its x
     * @param y
     *      its y
     */

    public Tileset(final Factory factory, final int x, final int y) {
        this.factory = factory;
        this.x = x;
        this.y = y;

    }

    /**
     * Gets the factory
     *
     * @return the factory
     */

    public Factory getFactory() {return this.factory;}

    /**
     * Sets the factory
     * @param factory
     *              the factory
     */

    public void setFactory(final Factory factory) {
        this.factory = (factory);
    }

    /**
     * Gets the x
     *
     * @return the x
     */

    public int getX() { return this.x;}

    /**
     * Sets the x
     *
     * @param x
     *      the x
     */
    public void setX(final int x) {
        this.x = (x);
    }

    /**
     * Gets the y
     *
     * @return the y
     */

    public int getY() {
        return this.y;
    }

    /** Sets the y
     *
     * @param y
     *      the y
     */

    public void setY(final int y) {
        this.y = (y);
    }
}
