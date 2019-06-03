package controller;

import org.junit.Before;
/**
 *@author jbschmitt
 *@author plbaillet
 */
public class UserOrderTest {

    private UserOrder userOrderUnderTest;

    @Before
    public void setUp() {
        userOrderUnderTest = new UserOrder(0, null);
    }
}
