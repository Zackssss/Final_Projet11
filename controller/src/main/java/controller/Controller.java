package controller;

import contract.*;


/**
 * The Class Controller.
 *
 * @author plbaillet
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
	 * Controller's Constructor
	 */
	public Controller(final IView view, final IModel model){
		this.setView(view);
		this.setModel(model);
	}


	/** Plays gameLoop. */
	public void play() throws InterruptedException {
		this.gameLoop();
	}


	/**
	 * Runs the gameLoop until the game is over.
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
		System.out.println("mort3");
	}

	/**
	 * getModel
	 * returns the model
	 */
	private IModel getModel(){
		return this.model;
	}

	/**
	 * @param model
	 * setModel defined the model
	 */
	private void setModel(final IModel model){
		this.model = model;
	}

	/**
	 * getView returns the view
	 */
	private IView getView(){
		return this.view;
	}

	/**
	 * @param view
	 * setView defined the view
	 */
	private void setView (final IView view) {
		this.view = view;
	}


	/**
	 * @param controllerOrder
	 * orderPerform test the controllerOrder to send an information to the method move
	 */
	@Override
	public void orderPerform(ControllerOrder controllerOrder) {
		if (controllerOrder != null){
			this.getModel().move(controllerOrder);
		}
	}



}
