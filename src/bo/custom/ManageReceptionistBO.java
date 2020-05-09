package bo.custom;

import crud.Crud;
import dto.ReceptionistDTO;
import entity.ReceptionistEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageReceptionistBO extends Crud<ReceptionistDTO, String> {
    public boolean addAccount(ReceptionistDTO dto) throws SQLException, ClassNotFoundException;
    public boolean addReceptionist(ReceptionistDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateReceptionist(ReceptionistDTO dto) throws SQLException, ClassNotFoundException;


}
