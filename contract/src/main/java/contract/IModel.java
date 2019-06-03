package contract;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * Shows methods other package need from Model
 *
 * @author Zachary Morello &amp;&amp; Hugo Bouillon
 */

public interface IModel{

    /**
     * The move.
     * @param order
     *          the order
     */
    void move(ControllerOrder order);

    /**
     * The death.
     * @throws InterruptedException
     *                      the InterruptedException
     */

    void death() throws InterruptedException;

    /** The isFalling. */

    void isFalling();

    /** The monsterOrder. */

    void monsterOrder();

    /**
     * The slip.
     *
     * @throws InterruptedException
     *                      the InterruptedException
     */

    void slip() throws InterruptedException;

    /**
     * The win.
     *
     * @throws InterruptedException
     *                      the InterruptedException
     */

    void win() throws InterruptedException;

    /**
     * Sets the ID(of the map).
     *
     * @param inte
     * 			the inte
     */

    void setID(int inte);

    /**
     * Gets the ID(of the map).
     *
     * @return the ID
     */

    int getID();

    /**
     * Gets the size(of the map).
     *
     * @return the size
     *
     * @throws SQLException
     * 					the SQL exception
     */

    int[] getSize()throws SQLException;

    /**
     * Gets the map(in an ArrayList).
     *
     * @return the map
     */

    ArrayList<entity.Tileset> getMap();

    /**
     * Sets the map(in an ArrayList).
     *
     * @param ID
     *			the ID
     *
     * @throws SQLException
     * 					the SQLException
     */

    void setMap(int ID) throws SQLException;

    /**
     * Gets the observable.
     *
     * @return this
     */

    Observable getObservable();
}