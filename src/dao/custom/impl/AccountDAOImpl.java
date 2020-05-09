package dao.custom.impl;

import dao.custom.AccountDAO;
import db.CrudUtil;
import entity.AccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAO {


    @Override
    public boolean add(AccountEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("insert into account values(account_id,?,?)", obj.getPassword(),obj.getName());
    }

    @Override
    public ArrayList<AccountEntity> load() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from customer");
        ArrayList<AccountEntity> list= new ArrayList<>();
        while (rst.next()){
            AccountEntity entity= new AccountEntity();
            entity.setAccountId(rst.getInt("account_id"));
            entity.setName(rst.getString("name"));
            entity.setPassword(rst.getString("password"));
            list.add(entity);
        }
        return list;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from account where account_id=?", Integer.parseInt(s));
    }

    @Override
    public boolean update(AccountEntity obj) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update account set name=?, password=? where account_id=?", obj.getName(), obj.getPassword(), obj.getAccountId());
    }

    @Override
    public AccountEntity search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select from account where account_id=?", Integer.parseInt(s));
        AccountEntity entity= new AccountEntity();
        while (rst.next()){
            entity.setAccountId(rst.getInt("account_id"));
            entity.setName(rst.getString("name"));
            entity.setPassword(rst.getString("password"));
        }
        return entity;
    }

    @Override
    public int getLastAccountID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from account order by account_id desc limit 1");
        rst.next();
        return rst.getInt("account_id");

    }
}
