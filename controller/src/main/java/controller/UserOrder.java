package controller;

import contract.ControllerOrder;
import contract.IUserOrder;

/**
 * The Class UserOrder.
 *
 * Associates an order to the player.
 *
 * @author plbaillet &amp;&amp; Zachary Morello &amp;&amp; Hugo Bouillon
 */

public class UserOrder implements IUserOrder {

    /** The player. */
    private final int player;

    /** The order. */
    private final ControllerOrder order;

    /**
     * Instantiates a new UserOrder.
     *
     * @param player
     *             the player
     * @param order
     *            the order
     */

    public UserOrder(final int player, final ControllerOrder order) {
        this.player = player;
        this.order = order;
    }

    /**
     * Gets the player
     *
     * @return the player
     */
    public int getPlayer() {
        return this.player;
    }

    /**
     * Gets the order
     *
     * @return the order
     */

    public ControllerOrder getOrder() {
        return this.order;
    }

}
