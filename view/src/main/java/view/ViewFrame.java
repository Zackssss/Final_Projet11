package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import contract.*;

import javax.swing.*;

import contract.IController;

/**
 * The Class ViewFrame.
 *
 * Creates the graphic interface and catches the key pressure.
 *
 * @author Zachary Morello &amp;&amp; Hugo Bouillon
 */

class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel model;

	/** The controller. */
	private IController controller;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;

	/**
	 * Instantiates a new ViewFrame.
	 *
	 * @param model the model
	 * @throws HeadlessException the headless exception
	 * @throws IOException
	 * 					the IOException
	 */
	public ViewFrame(final IModel model) throws HeadlessException, IOException {
		this.buildViewFrame(model);
	}

	/** Gets the controller.
	 *
	 * @return the controller
	 */

	private IController getController() {
		return this.controller;
	}

	/** Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */

	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/** Gets the model.
	 *
	 * @return the model
	 */

	protected IModel getModel() {
		return this.model;
	}

	/** Sets the model.
	 *
	 * @param model
	 *          the new model
	 */

	private void setModel(final IModel model) {
		this.model = model;
	}

	/** Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */

	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(1280 + this.getInsets().left + this.getInsets().right, 730 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(final KeyEvent e) {
		try {
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}


	public void keyReleased(final KeyEvent e) {

	}
}