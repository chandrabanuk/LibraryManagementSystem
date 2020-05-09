package dao.custom.impl;

import dao.custom.BookDAO;
import db.CrudUtil;
import entity.BookEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {

    @Override
    public boolean add(BookEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("insert into book values(bid,?,?,?,?,?,'yes')",obj.getPrice(),obj.getTitle(),obj.getAid(),obj.getTid(),obj.getPid());
    }

    @Override
    public ArrayList<BookEntity> load() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select*from book");
        ArrayList<BookEntity> list= new ArrayList<>();
        while (rst.next()){
            BookEntity entity= new BookEntity();
            entity.setBid(rst.getInt("bid"));
            entity.setTitle(rst.getString("title"));
            entity.setAid(rst.getInt("aid"));
            entity.setPid(rst.getInt("pid"));
            entity.setTid(rst.getInt("tid"));
            list.add(entity);
        }
        return list;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from book where bid=?", Integer.parseInt(s));
    }

    @Override
    public boolean update(BookEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update book set title=?, aid=?, tid=?, pid=? where bid=?", obj.getTitle(), obj.getAid(), obj.getTid(), obj.getPid(), obj.getBid());
    }

    @Override
    public BookEntity search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from book where bid=?", Integer.parseInt(s));
        BookEntity entity= new BookEntity();
        rst.next();
        entity.setBid(rst.getInt("bid"));
        entity.setTitle(rst.getString("title"));
        entity.setAid(rst.getInt("aid"));
        entity.setTid(rst.getInt("tid"));
        entity.setPid(rst.getInt("pid"));
        return entity;
    }

    @Override
    public boolean returnBook(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update book set availability='Yes' where bid=? ",Integer.parseInt(id));
    }

    @Override
    public boolean lendBook(String id) throws SQLException, ClassNotFoundException {
       return CrudUtil.executeUpdate("update book set availability='No' where bid=?", Integer.parseInt(id));
    }

}
