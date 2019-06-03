package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.ControllerOrder;


/**
 * The Class Controller.
 */
public final class Controller implements IController {

	private boolean isGameOver = false;
	private static int TIME_SLEEP = 30;
	private IModel model;
	private IView view;


	public Controller(final IView view, final IModel model){
		this.setView(view);
		this.setModel(model);

	}

	public void play() throws InterruptedException {
		this.gameLoop();
	}

	private void gameLoop() throws InterruptedException {
		while (!this.isGameOver){
			try {
				Thread.sleep(TIME_SLEEP);
			}
			catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			//this.getModel().death();//
			this.getModel().isFalling();
			Thread.sleep(300);
			this.getModel().slip();
			Thread.sleep(300);
			this.getModel().monsterOrder();
			Thread.sleep(300);
			this.getModel().death();
			this.getModel().win();



		}
		System.out.println("mort3");
	}

	private IModel getModel(){
		return this.model;
	}

	private void setModel(final IModel model){
		this.model = model;
	}

	private void setView (final IView view) {
		this.view = view;
	}

	public void orderPerform(ControllerOrder controllerOrder) {
		if (controllerOrder != null){
			this.getModel().move(controllerOrder);
		}
	}

	}