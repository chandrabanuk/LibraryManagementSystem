package dao.custom.impl;

import dao.custom.LendDetailDAO;
import db.CrudUtil;
import entity.LendDetailEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class LendDetailDAOImpl implements LendDetailDAO {
    @Override
    public boolean add(LendDetailEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("insert into lend_detail values(lid,?,?,?,null,?)", obj.getMid(), obj.getBid(), obj.getIssueDate(), obj.getDueDate());
    }

    @Override
    public ArrayList<LendDetailEntity> load() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(LendDetailEntity obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public LendDetailEntity search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean borrowBook(String id) {
        return false;
    }
}
