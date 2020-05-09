package bo.custom.impl;

import bo.custom.ManageReceptionistBO;
import dao.DAOFactory;
import dao.custom.AccountDAO;
import dao.custom.ReceptionistDAO;
import dao.custom.impl.QueryDAO;
import db.DBConnection;
import dto.ReceptionistDTO;
import entity.AccountEntity;
import entity.ReceptionistDetailEntity;
import entity.ReceptionistEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageReceptionistBOImpl implements ManageReceptionistBO {

    private AccountDAO accountDAO= (AccountDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ACCOUNT);
    private ReceptionistDAO receptionistDAO= (ReceptionistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTIONIST);
    QueryDAO queryDAO= (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);


    @Override
    public boolean add(ReceptionistDTO obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<ReceptionistDTO> load() throws SQLException, ClassNotFoundException {
        ArrayList<ReceptionistEntity> load=receptionistDAO.load();
        ArrayList<ReceptionistDTO> allReceptionists=new ArrayList<>();

        for(ReceptionistEntity e: load){
            ReceptionistDTO dto=new ReceptionistDTO();
            dto.setRID(e.getRid());
            dto.setName(e.getName());
            dto.setNIC(e.getNic());
            dto.setAddress(e.getAddress());
            dto.setGender(e.getGender());
            dto.setContact(e.getContact());
            allReceptionists.add(dto);
        }
        return allReceptionists;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return receptionistDAO.delete(s);
    }

    @Override
    public boolean update(ReceptionistDTO obj) throws SQLException, ClassNotFoundException {
        ReceptionistEntity receptionistEntity=new ReceptionistEntity();
        receptionistEntity.setRid(obj.getRID());
        receptionistEntity.setName(obj.getName());
        receptionistEntity.setNic(obj.getNIC());
        receptionistEntity.setAddress(obj.getAddress());
        receptionistEntity.setGender(obj.getGender());
        receptionistEntity.setContact(obj.getContact());
        receptionistEntity.setAccountId(obj.getAccountId());
        return receptionistDAO.update(receptionistEntity);
    }

    @Override
    public ReceptionistDTO search(String s) throws SQLException, ClassNotFoundException {
        ReceptionistEntity entity=receptionistDAO.search(s);
        ReceptionistDTO dto=new ReceptionistDTO();
        dto.setRID(entity.getRid());
        dto.setName(entity.getName());
        dto.setNIC(entity.getNic());
        dto.setAddress(entity.getAddress());
        dto.setContact(entity.getContact());
        dto.setGender(entity.getGender());
        dto.setAccountId(entity.getAccountId());
        return dto;
    }

    @Override
    public boolean addAccount(ReceptionistDTO dto) throws SQLException, ClassNotFoundException {
       return false;
    }

    @Override
    public boolean addReceptionist(ReceptionistDTO dto) throws SQLException, ClassNotFoundException {

        ReceptionistEntity receptionistEntity=new ReceptionistEntity();
        AccountEntity accountEntity= new AccountEntity();

        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        accountEntity.setName(dto.getName());
        accountEntity.setPassword(dto.getPassword());
        boolean account = accountDAO.add(accountEntity);
        int lastAccountID = accountDAO.getLastAccountID();


        receptionistEntity.setRid(dto.getRID());
        receptionistEntity.setName(dto.getName());
        receptionistEntity.setNic(dto.getNIC());
        receptionistEntity.setAddress((dto.getAddress()));
        receptionistEntity.setContact(dto.getContact());
        receptionistEntity.setGender(dto.getGender());
        receptionistEntity.setAccountId(lastAccountID);

        boolean receptionist = receptionistDAO.add(receptionistEntity);

        if(account && receptionist){
            connection.setAutoCommit(true);
            return true;
        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

    }

    @Override
    public boolean updateReceptionist(ReceptionistDTO dto) throws SQLException, ClassNotFoundException {
        ReceptionistDetailEntity entity=new ReceptionistDetailEntity();
        entity.setRid(dto.getRID());
        entity.setReceptionistname(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setContact(dto.getContact());
        entity.setNic(dto.getNIC());
        entity.setGender(dto.getGender());
        entity.setPassword(dto.getPassword());

        return queryDAO.updateReceptionist(entity);
    }


}
