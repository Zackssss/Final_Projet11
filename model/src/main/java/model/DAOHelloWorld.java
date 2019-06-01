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
		entity.Tileset tileset = null;

		while (resultSet.next()){

			switch (resultSet.getString("maps_integrate.nom_materiau")){
				case "border":
					tileset = new Tileset(new Border("border", false, false, false, false, FallingReaction.BLOCKING),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
				case "diamond":
					tileset = new Tileset(new Diamond("diamond", false, true, true, true, FallingReaction.SLIPPERY),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
				case "exit":
					tileset = new Tileset(new Exit("exit", false, false,	false, false, FallingReaction.BLOCKING),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
				case "ground":
					tileset = new Tileset(new Ground("ground", false, false, true,true, FallingReaction.TRAVERSABLE),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
				case "monster":
					tileset = new Tileset(new Monster("monster", false, false, true, true, FallingReaction.ALIVE),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
				case "nothing":
					tileset = new Tileset(new Nothing("nothing", false, false, true, true, FallingReaction.TRAVERSABLE),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
				case "player":
					tileset = new Tileset(new Player("player", false, false, true, true, FallingReaction.ALIVE),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
				case "rock":
					tileset = new Tileset(new Rock("rock", false, false, true, false, FallingReaction.BLOCKING),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
				case "wall":
					tileset = new Tileset(new Wall("wall", false, false, true, false, FallingReaction.BLOCKING),  resultSet.getInt("maps_integrate.X"),resultSet.getInt("maps_integrate.Y"));
					break;
					default:
						break;
			}
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
