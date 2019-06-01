package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import contract.*;
import entity.*;


public final class Model extends Observable implements IModel{


	private ArrayList<entity.Tileset> map;
	private DAOMap DAO = new DAOMap(DBConnection.getInstance().getConnection());
	private int ID = 1;
	private Tileset getY;
	private Tileset getX;
	private Tileset getFactory;

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

	void moveUp() {
		this.position.setY(this.position.getY() - 1);
	}
	void moveRight() {
		this.position.setX(this.position.getX() + 1);
	}

	void moveDown() {
		this.position.setY(this.position.getY() + 1);
	}

	void moveLeft() {
		this.position.setX(this.position.getX() - 1);
	}

}
