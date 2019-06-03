package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import entity.*;


	public final class Model extends Observable implements IModel {


		private ArrayList<entity.Tileset> map;
		private IController controller;
		private DAOMap DAO = new DAOMap(DBConnection.getInstance().getConnection());
		private int ID = 1;
		private int diamondLeft = this.getInfos();
		private int diamondCollected =0;

		/**
		 * Instantiates a new model.
		 */
		public Model() throws SQLException {
			this.map = DAO.getMapSql(ID);
		}

		public int getInfos() throws SQLException{
			int result = DAO.getInfos(this.ID);
			return result;
		}
		public void setID(int inte) {
			this.ID = inte;
		}

		public int getID() {
			return this.ID;
		}

		public int[] getSize() throws SQLException {
			int[] result = DAO.getMapSize(this.ID);
			return result;
		}



		public ArrayList<entity.Tileset> getMap() {
			return this.map;
		}

		public void setMap(int ID) throws SQLException {
			this.map = DAO.getMapSql(ID);
		}

		public Observable getObservable() {
			return this;
		}

		private IController getController() {
			return this.controller;
		}

		private void setController(final IController controller) {
			this.controller = controller;
		}

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
					else if (!this.map.get(index - 1).getFactory().getState() && this.map.get(index - 1).getFactory().getCollectibility()){

						this.map.get(index - 1).setFactory(this.map.get(index).getFactory());
						this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
						this.diamondCollected += 1;
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
					break;
				case STAND:
					break;
				default:
					break;

			}
		}

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
							if(this.map.get(i + 1).getFactory().getName().equals("monster")){
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

				} else ;

				{
					this.map.get(i).getFactory().setState(false);

				}

			}
		}




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
		public void win() throws InterruptedException{
			if (this.diamondLeft <= this.diamondCollected){
				for (int i = 0; i < this.map.size(); i++) {
					if (this.map.get(i).getFactory().getName().equals("exit")) {
						System.out.println("You got all the diamond you needed to win ! Head to the exit !");
						if ((this.map.get(i + 1).getFactory().getName().equals("player")) || (this.map.get(i - 1).getFactory().getName().equals("player")) || (this.map.get(i + 22).getFactory().getName().equals("player")) || (this.map.get(i - 22).getFactory().getName().equals("player"))){
							System.out.println("Bravo ! You won !");
							Thread.sleep(2000);
							System.exit(1);
						}

						}
					}
			}

		}
	}