package bo.custom;

import crud.Crud;
import dao.custom.AuthorDAO;
import dto.PoliciesDTO;

import java.sql.SQLException;

public interface ManagePolicieBO extends Crud<PoliciesDTO, String> {

    PoliciesDTO searchAuthor(String s) throws SQLException, ClassNotFoundException;
    PoliciesDTO searchPublisher(String s) throws SQLException, ClassNotFoundException;
    PoliciesDTO searchType(String s) throws SQLException, ClassNotFoundException;
    boolean updateAuthor(PoliciesDTO obj) throws SQLException, ClassNotFoundException;
    boolean updatePublisher(PoliciesDTO obj) throws SQLException, ClassNotFoundException;
    boolean updateType(PoliciesDTO obj) throws SQLException, ClassNotFoundException;
    boolean deleteAuthor(String s) throws SQLException, ClassNotFoundException;
    boolean deletePublisher(String s) throws SQLException, ClassNotFoundException;
    boolean deleteType(String s) throws SQLException, ClassNotFoundException;

}
