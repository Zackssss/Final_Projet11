package view;

import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IView;
import contract.*;

/**
 * The Class View.
 *
 * Takes care of the graphic interface and the Key detection.
 *
 * @author Zachary Morello &amp;&amp; Hugo Bouillon
 *
 */
public final class View implements IView, Runnable {

	/** The frame. **/
	private final ViewFrame viewFrame;

	/** Instantiates a new View.
	 *
	 * @param model
	 *          the model
	 * @throws IOException
	 * 				the IOException
	 */

	public View(final IModel model) throws IOException {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Sends an order when key pressed
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 * @throws InterruptedException
	 * 					the InterruptedException
	 */

	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) throws InterruptedException {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return ControllerOrder.UP;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RIGHT;
			default:
				return ControllerOrder.STAND;
		}
	}

	/** Shows the ViewFrame */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller
	 *
	 * @param controller
	 * 				the controller
	 */

	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}