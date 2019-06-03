package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import entity.*;


	/**
 	* The Class Model.
	 *
	 * Creates the functionalities of the game.
	 *
 	* @author Zachary Morello &amp;&amp; Hugo Bouillon
 	*/

	public final class Model extends Observable implements IModel {

		/** The map. */
		private ArrayList<entity.Tileset> map;

		/** The controller. */
		private IController controller;

		/** The DAO. */
		private DAOMap DAO = new DAOMap(DBConnection.getInstance().getConnection());

		/** The ID. */
		private int ID = 1;

		/** The diamondLeft. */
		private int diamondLeft = this.getInfos();

		/** The diamondCollected. */
		private int diamondCollected =0;


		/**
		 * Instantiates a new model.
		 *
		 *@throws SQLException
		 * 	         the SQLException
		 */
		public Model() throws SQLException {
			this.map = DAO.getMapSql(ID);
		}

		/**
		 * Gets the infos (the number of diamonds).
		 *
		 * @return the result
		 *
		 * @throws SQLException
		 * 					the SQlException
		 */

		public int getInfos() throws SQLException{
			int result = DAO.getInfos(this.ID);
			return result;
		}

		/**
		 * Sets the ID(of the map).
		 *
		 * @param inte
		 * 			the inte
		 */
		public void setID(int inte) {
			this.ID = inte;
		}

		/**
		 * Gets the ID(of the map).
		 *
		 * @return the ID
		 */

		public int getID() {
			return this.ID;
		}

		/**
		 * Gets the size(of the map).
		 *
		 * @return the size
		 *
		 * @throws SQLException
		 * 					the SQL exception
		 */

		public int[] getSize() throws SQLException {
			int[] result = DAO.getMapSize(this.ID);
			return result;
		}

		/**
		 * Gets the map(in an ArrayList).
		 *
		 * @return the map
		 */

		public ArrayList<entity.Tileset> getMap() {
			return this.map;
		}

		/**
		 * Sets the map(in an ArrayList).
		 *
		 * @param ID
		 *			the ID
		 *
		 * @throws SQLException
		 * 					the SQLException
		 */

		public void setMap(int ID) throws SQLException {
			this.map = DAO.getMapSql(ID);
		}

		/**
		 * Gets the observable.
		 *
		 * @return this
		 */

		public Observable getObservable() {
			return this;
		}

		/**
		 * Gets the controller.
		 *
		 * @return the controller
		 */
		private IController getController() {
			return this.controller;
		}

		/**
		 * Sets the controller.
		 *
		 * @param controller
		 * 				the controller
		 */

		private void setController(final IController controller) {
			this.controller = controller;
		}

		/**
		 * Moves the factory object named "player".
		 * First it looks for the player object,
		 * Then it checks the object, the player wants to move onto.
		 * According to this object nature, either dig, collect, push or die.
		 *
		 * @param order
		 * 			the order
		 */

		public void move(ControllerOrder order) {
			int index = 0;
			for (int i = 0; i < this.map.size(); i++) {
				if (this.map.get(i).getFactory().getName().equals("player")) {
					index = i;

				}
			}
			switch (order) {
				case UP:
					if (this.map.get(index - 1).getFactory().getPermeability()) {
						this.map.get(index - 1).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
					}
					else if (!this.map.get(index - 1).getFactory().getState() && this.map.get(index - 1).getFactory().getCollectibility()) {
						this.map.get(index - 1).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
						this.diamondCollected += 1;
					}
					else if (this.map.get(index - 1).getFactory().getName().equals("monster")) {
					this.map.get(index).getFactory().setFallingReaction(FallingReaction.DEAD);
					}
					break;
				case DOWN:
					if (this.map.get(index + 1).getFactory().getPermeability()) {
						this.map.get(index + 1).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
					}
					else if (!this.map.get(index + 1).getFactory().getState() && this.map.get(index + 1).getFactory().getCollectibility()){

						this.map.get(index + 1).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
						this.diamondCollected += 1;
					}
					else if (this.map.get(index + 1).getFactory().getName().equals("monster")) {
						this.map.get(index).getFactory().setFallingReaction(FallingReaction.DEAD);
					}
					break;
				case LEFT:
					if (this.map.get(index - 22).getFactory().getPermeability()) {
						this.map.get(index - 22).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
					}
					else if (!this.map.get(index - 22).getFactory().getState() && this.map.get(index - 22).getFactory().getCollectibility()){

						this.map.get(index - 22).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
						this.diamondCollected += 1;
					}
					else if(this.map.get(index - 22).getFactory().getName().equals("rock") && (this.map.get(index - 44).getFactory().getName().equals("nothing"))){
						this.map.get(index - 44).setFactory(this.map.get(index-22).getFactory());
						this.map.get(index - 22).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
					}
					else if (this.map.get(index - 22).getFactory().getName().equals("monster")) {
						this.map.get(index).getFactory().setFallingReaction(FallingReaction.DEAD);
					}
					break;
				case RIGHT:
					if (this.map.get(index + 22).getFactory().getPermeability()) {
						this.map.get(index + 22).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
					}
					else if (!this.map.get(index + 22).getFactory().getState() && this.map.get(index + 22).getFactory().getCollectibility()){
						this.map.get(index + 22).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
						this.diamondCollected += 1;
					}
					else if(this.map.get(index + 22).getFactory().getName().equals("rock") && (this.map.get(index + 44).getFactory().getName().equals("nothing"))){
						this.map.get(index + 44).setFactory(this.map.get(index+22).getFactory());
						this.map.get(index + 22).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
					}
					else if (this.map.get(index + 22).getFactory().getName().equals("monster")) {
						this.map.get(index).getFactory().setFallingReaction(FallingReaction.DEAD);
					}
					break;
				default:
					break;

			}
		}

		/**
		 * Applicable to rocks or diamonds, checks if the object below them is "nothing".
		 * If it is, puts the rocks or diamonds State on true.
		 * Then if the below object is Alive and the rocks or diamonds State is on true.
		 * Either explode it into diamonds or close the game (if the player is dead).
		 */

		public void isFalling() {

			for (int i = 0; i < this.map.size(); i++) {
				if (this.map.get(i).getFactory().getName().equals("rock") || this.map.get(i).getFactory().getName().equals("diamond")) {
					if ((this.map.get(i + 1).getFactory().getFallingReaction() == FallingReaction.TRAVERSABLE)) {
						this.map.get(i).getFactory().setState(true);
						this.map.get(i + 1).setFactory(this.map.get(i).getFactory());
						this.map.get(i).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));

					} else if (((this.map.get(i).getFactory().getState())) && ((this.map.get(i + 1).getFactory().getFallingReaction() == FallingReaction.ALIVE))) {
						//this.map.get(i + 1).setFactory(this.map.get(i).getFactory());//
						if ((this.map.get(i).getFactory().getDestructibility())) {
							this.map.get(i).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));
						}
						if (this.map.get(i + 1).getFactory().getName().equals("player")) {
							this.map.get(i + 1).getFactory().setFallingReaction(FallingReaction.DEAD);
						}
						if (this.map.get(i + 1).getFactory().getName().equals("monster")) {
							this.map.get(i + 1).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));

						}
						if ((this.map.get(i + 2).getFactory().getDestructibility())) {
							this.map.get(i + 2).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));
						}
						if ((this.map.get(i + 22).getFactory().getDestructibility())) {
							this.map.get(i + 22).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));
						}
						if ((this.map.get(i - 21).getFactory().getDestructibility())) {
							this.map.get(i - 21).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));
						}
						if ((this.map.get(i - 20).getFactory().getDestructibility())) {
							this.map.get(i - 20).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));
						}
						if ((this.map.get(i + 23).getFactory().getDestructibility())) {
							this.map.get(i + 23).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));
						}
						if ((this.map.get(i - 22).getFactory().getDestructibility())) {
							this.map.get(i - 22).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));
						}
						if ((this.map.get(i + 24).getFactory().getDestructibility())) {
							this.map.get(i + 24).setFactory(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY));
						}
					}

				} else {


					this.map.get(i).getFactory().setState(false);


				}
			}
		}

		/**
		 * Moves the factory object named "monster".
		 *
		 * First it looks for the monster object,
		 * Then it checks the object, the monster wants to move onto.
		 * According to this object nature, if it's nothing, moves onto it.
		 * If it's a player, makes it dead.
		 * The monster's movement are random.
		 */

		public void monsterOrder() {

			int aleamove;
			for (int i = 0; i < this.map.size(); i++) {
				if (this.map.get(i).getFactory().getName().equals("monster")) {
					aleamove = (int) (Math.random() * 4);
					switch (aleamove) {
						case 0:
							if (this.map.get(i - 1).getFactory().getName().equals("nothing")) {
								this.map.get(i - 1).setFactory(this.map.get(i).getFactory());
								this.map.get(i).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
							}
							else if (this.map.get(i - 1).getFactory().getName().equals("player")) {
								this.map.get(i - 1).getFactory().setFallingReaction(FallingReaction.DEAD);

							}
							break;
						case 1:
							if (this.map.get(i + 1).getFactory().getName().equals("nothing")) {
								this.map.get(i + 1).setFactory(this.map.get(i).getFactory());
								this.map.get(i).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));

							}
							else if (this.map.get(i + 1).getFactory().getName().equals("player")) {
								this.map.get(i + 1).getFactory().setFallingReaction(FallingReaction.DEAD);

							}
							break;

						case 2:
							if (this.map.get(i - 22).getFactory().getName().equals("nothing")) {
								this.map.get(i - 22).setFactory(this.map.get(i).getFactory());
								this.map.get(i).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
							}
							else if (this.map.get(i - 22).getFactory().getName().equals("player")) {
								this.map.get(i - 22).getFactory().setFallingReaction(FallingReaction.DEAD);

							}
							break;
						case 3:
							if (this.map.get(i + 22).getFactory().getName().equals("nothing")) {
								this.map.get(i + 22).setFactory(this.map.get(i).getFactory());
								this.map.get(i).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
							}
							else if (this.map.get(i + 22).getFactory().getName().equals("player")) {
								this.map.get(i + 22).getFactory().setFallingReaction(FallingReaction.DEAD);

							}
							break;
						default:
							break;
					}
				}


			}
		}

		/**
		 * Applicable to rocks or diamonds, checks if they are on another rock or diamond.
		 * Checks the left and the bottom-left object.
		 * If they are "nothing", move the rock (or the diamond) on the left.
		 * If either of them is something else, checks the right and bottom-right object,
		 * If they are "nothing", move the rock (or the diamond) on the right.
		 * Else do nothing.
		 */

		public void slip() {
			for (int i = 0; i < this.map.size(); i++) {
				if (this.map.get(i).getFactory().getName().equals("rock") || this.map.get(i).getFactory().getName().equals("diamond")) {
					if ((this.map.get(i + 1).getFactory().getFallingReaction() == FallingReaction.SLIPPERY)) {
						if (((this.map.get(i - 22).getFactory().getFallingReaction() == FallingReaction.TRAVERSABLE)) && ((this.map.get(i - 21).getFactory().getFallingReaction() == FallingReaction.TRAVERSABLE))) {
							this.map.get(i - 22).setFactory(this.map.get(i).getFactory());
							this.map.get(i).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));

						} else if (((this.map.get(i + 22).getFactory().getFallingReaction() == FallingReaction.TRAVERSABLE)) && ((this.map.get(i + 23).getFactory().getFallingReaction() == FallingReaction.TRAVERSABLE))) {
							this.map.get(i + 22).setFactory(this.map.get(i).getFactory());
							this.map.get(i).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
						}
					}
				}
			}
		}

		/**
		 * Checks if the player is dead,
		 * If it is :
		 * Prints a "Game Over" message,
		 *
		 * Closes the window.
		 *
		 * @throws InterruptedException
		 * 						the InterruptedException
		 */

		public void death() throws InterruptedException {
			for (int i = 0; i < this.map.size(); i++) {
				if (this.map.get(i).getFactory().getName().equals("player")) {
					if ((this.map.get(i).getFactory().getFallingReaction() == FallingReaction.DEAD)) {
						System.out.println("That's unfortunate, you died ! :/");
						Thread.sleep(2000);
						System.exit(1);
					}
				}
			}
		}

		/**
		 * Checks if the player collected enough diamonds.
		 * If he has, enables the exit.
		 * If the player is an object next to the exit :
		 * Shows a "Game Won" message,
		 *
		 * Closes the window.
		 *
		 * @throws InterruptedException
		 * 						the InterruptedException
		 */
		public void win() throws InterruptedException{
			if (this.diamondLeft <= this.diamondCollected){
				for (int i = 0; i < this.map.size(); i++) {
					if (this.map.get(i).getFactory().getName().equals("exit")) {
						System.out.println("You got all the diamond you needed to win ! Head to the exit !");
						if ((this.map.get(i + 1).getFactory().getName().equals("player")) || (this.map.get(i - 1).getFactory().getName().equals("player")) || (this.map.get(i - 22).getFactory().getName().equals("player"))){
							System.out.println("Bravo ! You won ! You collected " + this.diamondCollected + " / " + this.diamondLeft);
							Thread.sleep(2000);
							System.exit(1);
						}

						}
					}
			}

		}
	}