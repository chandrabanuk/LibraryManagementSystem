package bo.custom;

import crud.Crud;
import dto.MembersDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageMembersBO extends Crud<MembersDTO, String> {
    public boolean add(MembersDTO obj) throws SQLException, ClassNotFoundException;
    public ArrayList<MembersDTO> load() throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean update(MembersDTO obj) throws SQLException, ClassNotFoundException;
    public MembersDTO search(String id) throws SQLException, ClassNotFoundException;

}
