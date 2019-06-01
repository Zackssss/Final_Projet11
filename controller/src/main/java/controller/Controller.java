package controller;

import contract.*;


import java.util.ArrayList;



/**
 * The Class Controller.
 */
public final class Controller implements IController {

	private boolean isGameOver  = false;
	private IPlayerModel playerModel;
	private IView viewSystem;
	private static int TIME_SLEEP = 30;
	private Order stackOrder;
	private IModel model;
	private IView view;



	public Controller(final IPlayerModel playerModel , final IView view){
		this.setView(view);
		this.setPlayerModel(playerModel);
		this.clearStackOrder();
	}


    public void orderPerform(final IUserOrder userOrder){
		if (userOrder != null){
			final IMobile player = this.playerModel.getMobileByPlayer(userOrder.getPlayer()); // ask Zack method's name IModel and player
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
					case STAND:
					default:
						direction = this.playerModel.getMobileByPlayer(userOrder.getPlayer()).getDirection(); // ask Zack method's name
						break;

				}
				player.setDirection(direction); // ask Zack method's name
			}
		}
	}

	public void play() {
		this.gameLoop();
		this.viewSystem.printMessage("Game Over !");
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
			final ArrayList<IMobile> initialMobiles = new ArrayList<>(this.playerModel.getMobiles());
			for (final IMobile mobile : initialMobiles) {
				mobile.move();
			}
			//IMobile ask Zack Mobile method
			this.playerModel.setMobilesHavesMoved();
		}


	}

	public void setViewSystem(final IView viewSystem) {
		this.viewSystem = viewSystem;
	}

	private IModel getModel(){
		return this.model;
	}

	private void setPlayerModel(final IPlayerModel playerModel){
		this.playerModel = playerModel;
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


	public void control() {
	}



	@Override
	public void orderPerform(ControllerOrder controllerOrder) {

	}


	public void orderPerform() {
	}


}
