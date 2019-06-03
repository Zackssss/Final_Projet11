package contract;

/**
 * The Interface IController.
 *
 * Shows methods other package need from UserOrder
 *
 * @author Zachary Morello &amp;&amp; Hugo Bouillon
 */

public interface IUserOrder {

    /**
     * Gets the player
     *
     * @return the player
     */

    int getPlayer();

    /**
     * Gets the order
     *
     * @return the order
     */

    ControllerOrder getOrder();
}