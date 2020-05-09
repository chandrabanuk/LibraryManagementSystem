package dao.custom;

import crud.Crud;
import entity.AccountEntity;

import java.sql.SQLException;

public interface AccountDAO extends Crud<AccountEntity, String> {
    int getLastAccountID() throws SQLException, ClassNotFoundException;
}
