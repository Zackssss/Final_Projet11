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

    void move(ControllerOrder order);

    void setID(int inte);

    int getID();

    int[] getSize()throws SQLException;

    ArrayList<entity.Tileset> getMap();

    void setMap(int ID) throws SQLException;

    Observable getObservable();
}