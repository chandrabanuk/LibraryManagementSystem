package dao.custom.impl;

import crud.Super;
import db.CrudUtil;
import entity.LendDetailEntity;
import entity.LendEntity;
import entity.QueryEntity;
import entity.ReceptionistDetailEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAO implements Super {

    public LendEntity getLendDetail(String id) throws SQLException, ClassNotFoundException {
        String sql="select b.bid, name, member_type, nic, contact, address, title, issue_date,due_date, price from member m, lend_detail ld, book b where m.mid=? and m.mid=ld.mid and ld.bid=b.bid";
        ResultSet rst = CrudUtil.executeQuery(sql, Integer.parseInt(id));
        LendEntity lendEntity=new LendEntity();
        rst.next();
        lendEntity.setBid(rst.getInt("bid"));
        lendEntity.setMemberName(rst.getString("name"));
        lendEntity.setTitle(rst.getString("title"));
        lendEntity.setMember_type(rst.getString("member_type"));
        lendEntity.setNic(rst.getString("nic"));
        lendEntity.setContact(rst.getInt("contact"));
        lendEntity.setAddress(rst.getString("address"));
        lendEntity.setIssue_date(rst.getString("issue_date"));
        lendEntity.setDue_date(rst.getString("due_date"));
        lendEntity.setPrice(rst.getDouble("price"));

        return lendEntity;

    }

    public ArrayList<QueryEntity> getBookById(String id) throws SQLException, ClassNotFoundException {
        ArrayList<QueryEntity> list= new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select b.title, a.name as author, p.name as publisher, b.availability, b.price, t.name as type from book b, author a, publisher p, type t where b.aid= a.aid and b.pid= p.pid and b.tid=t.tid and b.bid=?", Integer.parseInt(id));
        while (rst.next()){
            QueryEntity entity= new QueryEntity();
            entity.setTitle(rst.getString("title"));
            entity.setAuthor_name(rst.getString("author"));
            entity.setPublisherName(rst.getString("publisher"));
            entity.setTypeName(rst.getString("type"));
            entity.setAvailability(rst.getString("availability"));
            entity.setPrice(rst.getDouble("price"));
            list.add(entity);
        }
        return list;
    }

    public ArrayList<QueryEntity> loadAllBooks() throws SQLException, ClassNotFoundException {
        ArrayList<QueryEntity> list= new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select b.bid, b.title, a.name as author, p.name as publisher, b.availability, b.price, t.name as type from book b, author a, publisher p, type t where b.aid= a.aid and b.pid= p.pid and b.tid=t.tid");
        while (rst.next()){
            QueryEntity entity= new QueryEntity();
            entity.setBookId(rst.getString("bid"));
            entity.setTitle(rst.getString("title"));
            entity.setAuthor_name(rst.getString("author"));
            entity.setPublisherName(rst.getString("publisher"));
            entity.setTypeName(rst.getString("type"));
            entity.setAvailability(rst.getString("availability"));
            entity.setPrice(rst.getDouble("price"));
            list.add(entity);
        }
        return list;
    }

    public LendEntity getDetailsBID(String id) throws SQLException, ClassNotFoundException {

        String sql="select m.mid, name, member_type, nic, contact, address, title, issue_date,due_date, price, availability from member m, lend_detail ld, book b where m.mid=ld.mid and ld.bid=b.bid and b.bid=?";
        ResultSet rst = CrudUtil.executeQuery(sql, Integer.parseInt(id));
        LendEntity lendEntity=new LendEntity();
        rst.next();
        lendEntity.setMid(rst.getInt("mid"));
        lendEntity.setMemberName(rst.getString("name"));
        lendEntity.setTitle(rst.getString("title"));
        lendEntity.setMember_type(rst.getString("member_type"));
        lendEntity.setNic(rst.getString("nic"));
        lendEntity.setContact(rst.getInt("contact"));
        lendEntity.setAddress(rst.getString("address"));
        lendEntity.setIssue_date(rst.getString("issue_date"));
        lendEntity.setDue_date(rst.getString("due_date"));
        lendEntity.setPrice(rst.getDouble("price"));
        lendEntity.setAvailability(rst.getString("availability"));

        return lendEntity;
    }

    public boolean updateReceptionist(ReceptionistDetailEntity entity) throws SQLException, ClassNotFoundException {
        String sql="update receptionist r, account a set r.name=?, r.nic=?, r.address=?, r.contact=?, r.gender=? where r.rid=a.account_id and a.password=? and r.rid=?";
        boolean b = CrudUtil.executeUpdate(sql, entity.getReceptionistname(), entity.getNic(), entity.getAddress(), entity.getContact(), entity.getGender(), entity.getPassword(), entity.getRid());
        return b;
    }


}
