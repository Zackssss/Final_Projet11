package contract;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel{

    public void setID(int inte);

    public int getID();

    public int[] getSize()throws SQLException;

    public ArrayList<contract.ITileset> getMap();

    public void setMap(int ID) throws SQLException;

    Observable getObservable();
}