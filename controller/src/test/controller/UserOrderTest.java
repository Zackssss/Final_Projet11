package controller;

import org.junit.Before;

/**
 * The TestClass of UserOrder
 *
 * @author Team11
 */

public class UserOrderTest {

    /** The userOrderUnderTest */
    private UserOrder userOrderUnderTest;

    @Before
    public void setUp() {
        userOrderUnderTest = new UserOrder(0, null);
    }
}
