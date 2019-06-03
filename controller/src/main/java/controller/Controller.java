package controller;

import contract.*;


/**
 * The Class Controller.
 *
 * Makes the loop permitting the game to play,
 *
 *
 * @author plbaillet &amp;&amp; Zachary Morello &amp;&amp; Hugo Bouillon
 */
public final class Controller implements IController {

	/** The GameOver. */

	private boolean isGameOver;

	/** The TIME_SLEEP. */

	private static int TIME_SLEEP = 30;

	/** The model. */

	private IModel model;

	/** The view. */

	private IView view;

	/**
	 * Instantiates a new controller.
	 *
	 * @param model
	 * 			the model
	 * @param view
	 * 			the view
	 */
	public Controller(final IView view, final IModel model){
		this.setView(view);
		this.setModel(model);
	}


	/** Plays gameLoop.
	 * @throws InterruptedException
	 * 				the InterruptedException
	 */
	public void play() throws InterruptedException {
		this.gameLoop();
	}


	/**
	 * Runs the gameLoop until the game is over (calls all functionalities from the model).
	 *
	 * @throws InterruptedException
	 * 						the InterruptedException
	 *
	 */
	private void gameLoop() throws InterruptedException {
		while (!this.isGameOver){
			try {
				Thread.sleep(TIME_SLEEP);
			}
			catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			this.getModel().death();
			this.getModel().win();
			this.getModel().isFalling();
			this.getModel().slip();
			Thread.sleep(500);
			this.getModel().monsterOrder();
			Thread.sleep(300);
		}
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */

	private IModel getModel(){
		return this.model;
	}

	/**
	 * Sets the Model.
	 *
	 * @param model
	 * 			the model
	 *
	 */

	private void setModel(final IModel model){
		this.model = model;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */

	private IView getView(){
		return this.view;
	}

	/**
	 * Sets the view
	 * @param view
	 *			the view
	 */
	private void setView (final IView view) {
		this.view = view;
	}

	/**
	 * Orderperform checks the controllerOrder, whenever a controllerOrder is received, it calls the move method associated.
	 *
	 * @param controllerOrder
	 * 				the controllerOrder
	 */

	@Override
	public void orderPerform(ControllerOrder controllerOrder) {
		if (controllerOrder != null){
			this.getModel().move(controllerOrder);
		}
	}



}
