package controller;

import org.junit.Before;

public class UserOrderTest {

    private UserOrder userOrderUnderTest;

    @Before
    public void setUp() {
        userOrderUnderTest = new UserOrder(0, null);
    }
}
