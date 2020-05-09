package crud;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Crud<T, ID> extends Super {

    public boolean add(T obj) throws SQLException, ClassNotFoundException;
    public ArrayList<T> load() throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public boolean update(T obj) throws SQLException, ClassNotFoundException;
    public T search(ID id) throws SQLException, ClassNotFoundException;
}
