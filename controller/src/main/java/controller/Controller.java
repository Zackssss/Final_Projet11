package controller;

import contract.*;


/**
 * The Class Controller.
 * @author plbaillet
 */
public final class Controller implements IController {
	/**
	 *
	 */
	private boolean isGameOver;
	private IView viewSystem;
	private static int TIME_SLEEP = 30;
	private IModel model;
	private IView view;

	/**
	 * @param model
	 * @param view
	 * Controller's Constructor
	 */
	public Controller(final IView view, final IModel model){
		this.setView(view);
		this.setModel(model);
	}


	/**
	 *
	 * play starts the game and launch gameLoop first
	 */
	public void play() throws InterruptedException {
		this.gameLoop();
	}


	/**
	 * 	gameLoop run different methods if the player is still alive, if not, there is the Game Over
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
	 * @param isGameOver
	 * setIsGameOver defined when the game turned over
	 */
	public void setIsGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}



	/**
	 * @param viewSystem
	 * setViewSystem defined the viewSystem
	 */
	public void setViewSystem(final IView viewSystem) {
		this.viewSystem = viewSystem;
	}


	/**
	 * getModel returns the model
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
