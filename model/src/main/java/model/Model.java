package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import contract.*;
import entity.*;


public final class Model extends Observable implements IModel {


	private ArrayList<entity.Tileset> map;
	private Tileset getY;
	private Tileset getX;
	private Tileset getFactory;
	private DAOMap DAO = new DAOMap(DBConnection.getInstance().getConnection());
	private int ID = 4;

	/**
	 * Instantiates a new model.
	 */
	public Model() throws SQLException {
		this.map = DAO.getMapSql(ID);
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
				break;
			case DOWN:
				if (this.map.get(index + 1).getFactory().getPermeability()) {
					this.map.get(index + 1).setFactory(this.map.get(index).getFactory());
					this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
				}
				break;
			case LEFT:
				if (this.map.get(index - 22).getFactory().getPermeability()) {
					this.map.get(index - 22).setFactory(this.map.get(index).getFactory());
					this.map.get(index).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
				}
				break;
			case RIGHT:
				if (this.map.get(index + 22).getFactory().getPermeability()) {
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
				if (this.map.get(i + 1).getFactory().getFallingReaction() == FallingReaction.TRAVERSABLE) {
					this.map.get(i).getFactory().setState(true);
					this.map.get(i + 1).setFactory(this.map.get(i).getFactory());
					this.map.get(i).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));

				}
			} else ;
			{
				this.map.get(i).getFactory().setState(false);
			}

		}
	}

	public void monsterOrder() {
		int place = 0;
		int aleamove;
		for (int i = 0; i < this.map.size(); i++) {
			if (this.map.get(i).getFactory().getName().equals("monster")) {
				place = i;
				aleamove = (int) (Math.random() * 4);
				switch (aleamove) {
					case 0:
						if (this.map.get(place - 1).getFactory().getName().equals("nothing")) {
							this.map.get(place - 1).setFactory(this.map.get(place).getFactory());
							this.map.get(place).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
							System.out.println("0");

						}
						break;
					case 1:
						if (this.map.get(place + 1).getFactory().getName().equals("nothing")) {
							this.map.get(place + 1).setFactory(this.map.get(place).getFactory());
							this.map.get(place).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
							System.out.println("1");

						}
						break;

					case 2:
						if (this.map.get(place - 22).getFactory().getName().equals("nothing")) {
							this.map.get(place - 22).setFactory(this.map.get(place).getFactory());
							this.map.get(place).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
							System.out.println("2");
						}
						break;
					case 3:
						if (this.map.get(place + 22).getFactory().getName().equals("nothing")) {
							this.map.get(place + 22).setFactory(this.map.get(place).getFactory());
							this.map.get(place).setFactory(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE));
							System.out.println("3");
						}
						break;
					default:
						break;
				}
			}


		}
/**
 public void isPushing() {
 int index = 0;
 for (int i = 0; i < this.map.size(); i++) {
 if (this.map.get(i).getFactory().getName().equals("player") && (this.map.get(i + 22).getFactory().getName().equals("rock"))) {
 index = i;
 }
 }
 }*/
		}


	}