package dao.custom.impl;

import dao.custom.MemberDAO;
import db.CrudUtil;
import entity.MemberEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {

    @Override
    public boolean add(MemberEntity obj) throws SQLException, ClassNotFoundException {

        return CrudUtil.executeUpdate ("insert into Member values(mid,?,?,?,?,?,?,?,?)",obj.getName(),obj.getNic(),obj.getAddress(), obj.getContact(), obj.getEmail(), obj.getDob(), obj.getGender(),obj.getMemberType());
    }

    @Override
    public ArrayList<MemberEntity> load() throws SQLException, ClassNotFoundException {
        String sql="select * from member";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<MemberEntity> allMemberEntities= new ArrayList<>();
        while (rst.next()){
            MemberEntity entity= new MemberEntity(rst.getInt("mid"), rst.getString("name"), rst.getString("nic"), rst.getString("address"), rst.getInt("contact"), rst.getString("email"), rst.getDate("dob"), rst.getString("gender"), rst.getString("member_type"));
            allMemberEntities.add(entity);
        }
        return allMemberEntities;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from member where mid=?", Integer.parseInt(s));
    }

    @Override
    public boolean update(MemberEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate ("update Member set nic=?,email=?,name=?,address=?,contact=?,gender=?,dob=?,member_type=? where mid=?", obj.getNic(),obj.getEmail(),obj.getName(),obj.getAddress(),obj.getContact(),obj.getGender(),obj.getDob(),obj.getMemberType(),obj.getMid());
    }

    @Override
    public MemberEntity search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select*from member where mid=?", Integer.parseInt(s));
        MemberEntity entity= null;
        while(rst.next()){
            entity=new MemberEntity(Integer.parseInt(s),rst.getString("name"), rst.getString("nic"),rst.getString("address"), rst.getInt("contact"), rst.getString("email"), rst.getDate("dob"), rst.getString("gender"), rst.getString("member_type"));
        }
        return entity;
    }

}
