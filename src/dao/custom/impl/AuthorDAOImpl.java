package dao.custom.impl;

import crud.Crud;
import dao.custom.AuthorDAO;
import db.CrudUtil;
import entity.AuthorEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public boolean add(AuthorEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("insert into author values (aid, ?)",obj.getName());
    }

    @Override
    public ArrayList<AuthorEntity> load() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from author");
        ArrayList<AuthorEntity> author= new ArrayList<>();
        while (rst.next()){
            AuthorEntity e= new AuthorEntity(rst.getInt("aid"), rst.getString("name"));
            author.add(e);
        }
        return author;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from author where aid=?", Integer.parseInt(s));
    }

    @Override
    public boolean update(AuthorEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update author set name=?", obj.getName());
    }

    @Override
    public AuthorEntity search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from author where aid=?", Integer.parseInt(s));
        AuthorEntity entity= new AuthorEntity();
        while (rst.next()){
            entity.setAid(rst.getInt("aid"));
            entity.setName(rst.getString("name"));
        }
        return entity;
    }
}
