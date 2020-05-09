package dao.custom;

import crud.Crud;
import entity.BookEntity;

import java.sql.SQLException;

public interface BookDAO extends Crud<BookEntity, String> {
    public boolean returnBook(String id) throws SQLException, ClassNotFoundException;
    boolean lendBook(String id) throws SQLException, ClassNotFoundException;
}
