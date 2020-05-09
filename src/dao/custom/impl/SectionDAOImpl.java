package dao.custom.impl;

import dao.custom.SectionDAO;
import db.CrudUtil;
import entity.SectionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectionDAOImpl implements SectionDAO {
    @Override
    public boolean add(SectionEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("insert into section values(sid,?)",obj.getDescription());
    }

    @Override
    public ArrayList<SectionEntity> load() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from section");
        ArrayList<SectionEntity> section=new ArrayList<>();
        while(rst.next()){
            SectionEntity sectionEntity=new SectionEntity(rst.getInt("sid"),rst.getString("description"));
            section.add(sectionEntity);
        }
        return section;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from section where sid=?", Integer.parseInt(s));
    }

    @Override
    public boolean update(SectionEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update section set description=? where sid=?", obj.getDescription(), obj.getSid());
    }

    @Override
    public SectionEntity search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from section where sid=?", Integer.parseInt(s));
        SectionEntity entity= new SectionEntity();
        rst.next();
        entity.setSid(rst.getInt("sid"));
        entity.setDescription(rst.getString("description"));
        return entity;
    }
}
