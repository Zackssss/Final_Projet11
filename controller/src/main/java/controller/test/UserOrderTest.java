package controller.test;
/**
import contract.IUserOrder;
import contract.Order;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class UserOrderTest implements IUserOrder {

    private final int player;
    private final Order order;

    public UserOrderTest(int player, Order order) {
        this.player = player;
        this.order = order;
    }

    @Test
    public int getPlayer() {
        return this.player;
    }

    @Test
    public Order getOrder() {
        return this.order;
    }







    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(controller.UserOrder.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



}
*/