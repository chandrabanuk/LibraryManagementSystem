package dao.custom.impl;

import dao.custom.TypeDAO;
import db.CrudUtil;
import entity.TypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeDAOImpl implements TypeDAO {
    @Override
    public boolean add(TypeEntity obj) throws SQLException, ClassNotFoundException {

        return CrudUtil.executeUpdate("insert into type values(tid,1,?)", obj.getName());
    }

    @Override
    public ArrayList<TypeEntity> load() throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("select*from type");
        ArrayList<TypeEntity> types=new ArrayList<>();
        while(rst.next()){

            TypeEntity typeEntity= new TypeEntity(rst.getInt("tid"),rst.getInt("sid"),rst.getString("name"));
            types.add(typeEntity);
        }
        return types;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from type where tid=?", Integer.parseInt(s));
    }

    @Override
    public boolean update(TypeEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update type set sid=1, name=? where tid=?", obj.getName(), obj.getTid());
    }

    @Override
    public TypeEntity search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from type where tid=?", Integer.parseInt(s));
        TypeEntity entity= new TypeEntity();
        rst.next();
        entity.setTid(rst.getInt("tid"));
        entity.setSid(rst.getInt("sid"));
        entity.setName(rst.getString("name"));
        return entity;
    }
}
