package dao.custom.impl;

import dao.custom.FineDAO;
import db.CrudUtil;
import entity.FineEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class FineDAOImpl implements FineDAO {
    @Override
    public boolean add(FineEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("insert into fine values (fid,?,?,?)", obj.getAmount(),obj.getLid(), obj.getRid());
    }

    @Override
    public ArrayList<FineEntity> load() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(FineEntity obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public FineEntity search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
