package dao.custom.impl;

import dao.custom.ReceptionistDAO;
import db.CrudUtil;
import entity.ReceptionistEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReceptionistDAOImpl implements ReceptionistDAO {

    @Override
    public boolean add(ReceptionistEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("insert into receptionist values(rid,?,?,?,?,?,?)", obj.getName(), obj.getNic(), obj.getAddress(), obj.getContact(), obj.getGender(), obj.getAccountId());
    }

    @Override
    public ArrayList<ReceptionistEntity> load() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select rid,name,nic,address,gender,contact from receptionist");
        ArrayList<ReceptionistEntity> list= new ArrayList<>();
        while (rst.next()){
            ReceptionistEntity entity= new ReceptionistEntity(rst.getInt("rid"), rst.getString("name"), rst.getString("nic"), rst.getString("address"), rst.getString("gender"), rst.getInt("contact"));
            list.add(entity);
        }
        return list;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from receptionist where rid=?", Integer.parseInt(s));
    }

    @Override
    public boolean update(ReceptionistEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update receptionist set name=?, nic=?, address=?, contact=?, gender=? account_id=? where rid=?", obj.getName(), obj.getNic(), obj.getAddress(), obj.getContact(), obj.getGender(), obj.getAccountId(), obj.getRid());
    }

    @Override
    public ReceptionistEntity search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from receptionist where rid=?", Integer.parseInt(s));
        rst.next();
        ReceptionistEntity entity= new ReceptionistEntity(rst.getInt("rid"), rst.getString("name"), rst.getString("nic"), rst.getString("address"), rst.getInt("contact"), rst.getString("gender"), rst.getInt("account_id"));
        return entity;
    }
}
