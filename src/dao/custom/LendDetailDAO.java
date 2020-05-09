package dao.custom;

import crud.Crud;
import entity.LendDetailEntity;

public interface LendDetailDAO extends Crud<LendDetailEntity, String> {

    public boolean borrowBook(String id);
}
