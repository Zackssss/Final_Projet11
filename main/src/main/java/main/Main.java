/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.*;
import controller.Controller;
import model.Model;
import view.View;

import java.io.IOException;
import java.sql.SQLException;


public abstract class Main {

    public static void main(final String[] args) throws IOException, SQLException, InterruptedException {

        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.orderPerform(ControllerOrder.STAND);
        controller.play();

    }
}