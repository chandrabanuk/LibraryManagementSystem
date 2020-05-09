package bo.custom.impl;

import bo.custom.ManagePolicieBO;
import dao.DAOFactory;
import dao.custom.AuthorDAO;
import dao.custom.PublisherDAO;
import dao.custom.TypeDAO;
import dto.PoliciesDTO;
import entity.AuthorEntity;
import entity.PublisherEntity;
import entity.TypeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManagePolicieBOImpl implements ManagePolicieBO {

    AuthorDAO daoAuthor= (AuthorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.AUTHOR);
    PublisherDAO daoPublisher= (PublisherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PUBLISHER);
    TypeDAO daoType= (TypeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TYPE);

    @Override
    public boolean add(PoliciesDTO obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<PoliciesDTO> load() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PoliciesDTO obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PoliciesDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public PoliciesDTO searchAuthor(String s) throws SQLException, ClassNotFoundException {
        AuthorEntity entity = daoAuthor.search(s);
        PoliciesDTO dto= new PoliciesDTO();
        dto.setAuthorName(entity.getName());
        dto.setAuthorId(entity.getAid());
        return dto;
    }

    @Override
    public PoliciesDTO searchPublisher(String s) throws SQLException, ClassNotFoundException {
        PublisherEntity entity = daoPublisher.search(s);
        PoliciesDTO dto= new PoliciesDTO();
        dto.setPublisherId(entity.getPid());
        dto.setPublisherName(entity.getName());
        dto.setPublisherContact(entity.getContact());
        return dto;
    }

    @Override
    public PoliciesDTO searchType(String s) throws SQLException, ClassNotFoundException {
        TypeEntity entity = daoType.search(s);
        PoliciesDTO dto= new PoliciesDTO();
        dto.setTypeId(entity.getTid());
        dto.setTypeName(entity.getName());
        return dto;
    }

    @Override
    public boolean updateAuthor(PoliciesDTO obj) throws SQLException, ClassNotFoundException {
        AuthorEntity entity=new AuthorEntity();
        entity.setAid(obj.getAuthorId());
        entity.setName(obj.getAuthorName());
        return daoAuthor.update(entity);
    }

    @Override
    public boolean updatePublisher(PoliciesDTO obj) throws SQLException, ClassNotFoundException {
        PublisherEntity entity=new PublisherEntity();
        entity.setPid(obj.getPublisherId());
        entity.setName(obj.getPublisherName());
        entity.setContact(obj.getPublisherContact());
        return daoPublisher.update(entity);
    }

    @Override
    public boolean updateType(PoliciesDTO obj) throws SQLException, ClassNotFoundException {
        TypeEntity entity=new TypeEntity();
        entity.setName(obj.getTypeName());
        entity.setTid(obj.getTypeId());
        return daoType.update(entity);
    }

    @Override
    public boolean deleteAuthor(String s) throws SQLException, ClassNotFoundException {
        return daoAuthor.delete(s);
    }

    @Override
    public boolean deletePublisher(String s) throws SQLException, ClassNotFoundException {
        return daoPublisher.delete(s);
    }

    @Override
    public boolean deleteType(String s) throws SQLException, ClassNotFoundException {
        return daoType.delete(s);
    }
}
