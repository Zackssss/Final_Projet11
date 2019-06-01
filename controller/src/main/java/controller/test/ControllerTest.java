package controller.test;
/**
import com.sun.javafx.scene.traversal.Direction;
import contract.IModel;
import contract.IView;
import contract.IUserOrder;
import controller.UserOrder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
 */
/**
@RunWith(Arquillian.class)
public class ControllerTest extends Object{

    private boolean isGameOver  = false;
    private IModel playerModel;
    private IViewSystem viewSystem;
    private static int TIME_SLEEP = 30;
    private UserOrder stackOrder;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(controller.Controller.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    public ControllerTest(final IModel playerModel, final IView view){
        this.setView(view);
        this.setPlayerModel(playerModel);
        this.clearStackOrder();
    }
/*
    public void orderPerform(final IUserOrder userOrder){
        if (userOrder != null){
            final IModel player = this.playerModel.getIModelByPlayer(userOrder.getPlayer()); // ask Zack method's name IModel and player
            if (player != null){
                Direction direction;
                switch (userOrder.getOrder()){
                    case UP:
                        direction = Direction.UP;
                        break;
                    case RIGHT:
                        direction = Direction.RIGHT;
                        break;
                    case DOWN:
                        direction = Direction.DOWN;
                        break;
                    case LEFT:
                        direction = Direction.LEFT;
                        break;
                    case NOP:
                    default:
                        direction = this.playerModel.getMobileByPlayer(userOrder.getPlayer()).getDirection; // ask Zack method's name
                        break;

                }
                player.setDirection(direction); // ask Zack method's name
            }
        }
    }

    public void play() {
        this.gameLoop();
        this.viewSystem.displayMessage("Game Over !");
        this.viewSystem.closeAll();
    }

    private void gameLoop(){
        while (!this.isGameOver){
            try {
                Thread.sleep(TIME_SLEEP);
            }
            catch (final InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            final ArrayList<IMobile> initialMobiles = new ArrayList<~>();
            for (final IMobile mobile : this.playerModel.getMobiles) {
                initialMobiles.add(mobile);
            }//IMobile ask Zack Mobile method
            this.playerModel.setMobilesHaveMoved();
        }


    }

    public void setViewSystem(final IViewSystem viewSystem) {
        this.viewSystem = viewSystem;
    }

    private IModel getModel(){
        return this.model;
    }

    private void setPlayerModel(final IModel model){
        this.playerModel = model;
    }

    private IView getView(){
        return this.view;
    }

    private void setView (final IView view) {
        this.view = view;
    }

    private UserOrder getStackOrder(){
        return this.stackOrder;
    }

    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    private void clearStackOrder(){
        this.stackOrder = UserOrder.NOP;
    }

    @org.junit.Test
    public void control() {
    }

    @org.junit.Test
    public void orderPerform() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void control1() {
    }

    @Test
    public void orderPerform1() {
    }
}
 */