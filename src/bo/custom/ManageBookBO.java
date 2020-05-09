package bo.custom;

import crud.Crud;
import dto.BookDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageBookBO extends Crud<BookDTO,String> {

    public boolean addAuthor(BookDTO obj) throws SQLException, ClassNotFoundException;
    public boolean addPublisher(BookDTO obj) throws SQLException, ClassNotFoundException;
    public boolean addType(BookDTO obj) throws SQLException, ClassNotFoundException;
    public boolean addSection(BookDTO obj) throws SQLException, ClassNotFoundException;
    public ArrayList<BookDTO> loadAllAuthor() throws SQLException, ClassNotFoundException;
    public ArrayList<BookDTO> loadAllPublisher() throws SQLException, ClassNotFoundException;
    public ArrayList<BookDTO> loadAllType() throws SQLException, ClassNotFoundException;
    public ArrayList<BookDTO> loadAllSection() throws SQLException, ClassNotFoundException;

}
