package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.*;




class DAOMap{

	private Connection connection;

	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	protected Connection getConnection() {
		return this.connection;
	}

	public ArrayList<entity.Tileset> getMapSql(int ID) throws SQLException {

		ArrayList<entity.Tileset> Map = new ArrayList<Tileset>();
		int i = 0;

		final String sql = "{call GetMap(" + ID + ")}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		call.execute();
		final ResultSet resultSet = call.getResultSet();

		while (resultSet.next()){
			entity.Tileset tileset = new Tileset(resultSet.getString("maps_integrate.nom_materiau"),resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
			Map.add(i, tileset);
			i++;
		}

		return Map;
	}

	public int[] getMapSize(int ID) throws SQLException {
		int[] result = new int[2];

		final String sql = "{call GetSize(" + ID + ")}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		call.execute();
		final ResultSet resultSet = call.getResultSet();

		resultSet.first();
		result[0] = resultSet.getInt("Height");
		result[1] = resultSet.getInt("Width");

		return result;
	}
}
