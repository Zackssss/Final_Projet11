package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;


public final class Model extends Observable implements IModel{


	private ArrayList<contract.ITileset> map;
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

	public ArrayList<contract.ITileset> getMap() {
		return this.map;
	}

	public void setMap(int ID) throws SQLException {
		this.map = DAO.getMapSql(ID);
	}

	public Observable getObservable() {
		return this;
	}

}
