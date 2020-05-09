package dao.custom.impl;

import crud.Crud;
import dao.custom.PublisherDAO;
import db.CrudUtil;
import entity.PublisherEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherDAOImpl implements PublisherDAO {

    @Override
    public boolean add(PublisherEntity obj) throws SQLException, ClassNotFoundException {
        boolean b = CrudUtil.executeUpdate("insert into publisher values(pid, ?,?)", obj.getName(), obj.getContact());
        return b;
    }

    @Override
    public ArrayList<PublisherEntity> load() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select*from publisher");
        ArrayList<PublisherEntity> publisher=new ArrayList<>();
        while(rst.next()){
            PublisherEntity e= new PublisherEntity(rst.getInt("pid"),rst.getString("name"),rst.getInt("contact"));
            publisher.add(e);
        }
        return publisher;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from publisher where pid=?", Integer.parseInt(s));
    }

    @Override
    public boolean update(PublisherEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update publisher set name=?, contact=? where pid=?", obj.getName(), obj.getContact(), obj.getPid());
    }

    @Override
    public PublisherEntity search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from publisher where pid=?", Integer.parseInt(s));
        PublisherEntity entity= new PublisherEntity();
        rst.next();
        entity.setPid(rst.getInt("pid"));
        entity.setName(rst.getString("name"));
        entity.setContact(rst.getInt("contact"));
        return entity;
    }
}
