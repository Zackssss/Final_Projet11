package controller;

import contract.*;


/**
 * The Class Controller.
 */
public final class Controller implements IController {

	private boolean isGameOver;
	private IView viewSystem;
	private static int TIME_SLEEP = 30;
	private Order stackOrder;
	private IModel model;
	private IView view;


	public Controller(final IView view, final IModel model){
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}



	public void play() throws InterruptedException {
		this.gameLoop();
		this.viewSystem.printMessage("Game Over !");
		this.viewSystem.closeAll();
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


	public void setIsGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public void setViewSystem(final IView viewSystem) {
		this.viewSystem = viewSystem;
	}

	private IModel getModel(){
		return this.model;
	}

	private void setModel(final IModel model){
		this.model = model;
	}

	private IView getView(){
		return this.view;
	}


	private void setView (final IView view) {
		this.view = view;
	}

	private Order getStackOrder(){
		return this.stackOrder;
	}


	private void setStackOrder(final Order stackOrder) {
		this.stackOrder = stackOrder;
	}

	private void clearStackOrder(){
		this.stackOrder = Order.NOP;
	}

	@Override
	public void orderPerform(ControllerOrder controllerOrder) {
		if (controllerOrder != null){
			this.getModel().move(controllerOrder);
		}
	}



}