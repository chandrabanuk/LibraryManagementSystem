package bo.custom;

import crud.Crud;
import dto.BookDTO;
import dto.LendDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MakeLendBO extends Crud<LendDTO, String> {
    public LendDTO addLendDetail(String id) throws SQLException, ClassNotFoundException;
    public boolean returnBook(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<LendDTO> getBookById(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<LendDTO>loadAllBooks() throws SQLException, ClassNotFoundException;
    public LendDTO getDetailsBID(String id) throws SQLException, ClassNotFoundException;
}
