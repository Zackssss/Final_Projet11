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
	private int ID = 1;


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
				System.out.println("UP");
				System.out.println(this.map.get(index - 1).getFactory().getPermeability());
				if (this.map.get(index - 1).getFactory().getPermeability() != Permeability.BLOCKING) {
					this.map.get(index - 1).setFactory(this.map.get(index).getFactory());
					this.map.get(index).setFactory(new Nothing("nothing", true, Permeability.PENETRABLE));
					System.out.println("déplacement");
				}
				break;
			case DOWN:
				if (this.map.get(index + 1).getFactory().getPermeability() != Permeability.BLOCKING) {
					this.map.get(index + 1).setFactory(this.map.get(index).getFactory());
					this.map.get(index).setFactory(new Nothing("nothing", true, Permeability.PENETRABLE));
				}
				break;
			case LEFT:
				if (this.map.get(index - 22).getFactory().getPermeability() != Permeability.BLOCKING) {
					this.map.get(index - 22).setFactory(this.map.get(index).getFactory());
					this.map.get(index).setFactory(new Nothing("nothing", true, Permeability.PENETRABLE));
				}
				break;
			case RIGHT:
				if (this.map.get(index + 22).getFactory().getPermeability() != Permeability.BLOCKING) {
					this.map.get(index + 22).setFactory(this.map.get(index).getFactory());
					this.map.get(index).setFactory(new Nothing("nothing", true, Permeability.PENETRABLE));
				}
				break;
			case STAND:
				break;
			default:
				break;
		}
	}

	public void isNormal(){


	}
	public void isFalling() {
		int index = 0;
		for (int i = 0; i < this.map.size(); i++) {
			if (this.map.get(i).getFactory().getName().equals("rock") || this.map.get(i).getFactory().getName().equals("diamond")) {
				index = i;
			}
			if (this.map.get(index + 1).getFactory().getPermeability() == Permeability.PENETRABLE) {

			}

		}
	}
}

