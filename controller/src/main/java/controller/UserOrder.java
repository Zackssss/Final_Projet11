package controller;

import contract.ControllerOrder;
import contract.IUserOrder;

public class UserOrder implements IUserOrder {
    private final int player;
    private final ControllerOrder order;

    public UserOrder(final int player, final ControllerOrder order) {
        this.player = player;
        this.order = order;
    }


    public int getPlayer() {
        return this.player;
    }


    public ControllerOrder getOrder() {
        return this.order;
    }

}
