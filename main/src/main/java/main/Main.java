/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.*;
import controller.Controller;
import model.Model;
import model.element.PlayerModel;
import view.View;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) throws IOException, SQLException {

        final PlayerModel playerModel= new PlayerModel();
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(playerModel , view);
        view.setController(controller);

        controller .orderPerform(ControllerOrder.STAND);
        controller.play();

    }
}
