package bo.custom.impl;

import bo.custom.ManageBookBO;
import dao.DAOFactory;
import dao.custom.*;
import dto.BookDTO;
import dto.MembersDTO;
import entity.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageBookBOImpl implements ManageBookBO {

    AuthorDAO daoAuthor= (AuthorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.AUTHOR);
    PublisherDAO daoPublisher= (PublisherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PUBLISHER);
    TypeDAO daoType= (TypeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TYPE);
    SectionDAO daoSection= (SectionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SECTION);
    BookDAO daoBook= (BookDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK);

    @Override
    public boolean add(BookDTO obj) throws SQLException, ClassNotFoundException {
        BookEntity entity= new BookEntity(250.00,obj.getTitle(),obj.getAid(),obj.getTid(),obj.getPid());
        return daoBook.add(entity);
    }

    @Override
    public ArrayList<BookDTO> load() throws SQLException, ClassNotFoundException {
        ArrayList<BookEntity> entity = daoBook.load();
        ArrayList<BookDTO> dto= new ArrayList<>();
        for(BookEntity e:entity){
            BookDTO bookDTO= new BookDTO();
            TypeEntity typeEntity = daoType.search(Integer.toString(e.getTid()));
            AuthorEntity authorEntity = daoAuthor.search(Integer.toString(e.getAid()));
            PublisherEntity publisherEntity = daoPublisher.search(Integer.toString(e.getPid()));
            bookDTO.setBookId(e.getBid());
            bookDTO.setTitle( e.getTitle());
            bookDTO.setTypeName(typeEntity.getName());
            bookDTO.setAuthorName(authorEntity.getName());
            bookDTO.setPublisherName(publisherEntity.getName());
            dto.add(bookDTO);
        }
        return dto;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return daoBook.delete(s);
    }

    @Override
    public boolean update(BookDTO obj) throws SQLException, ClassNotFoundException {
        BookEntity entity= new BookEntity();
        entity.setBid(obj.getBookId());
        entity.setTitle(obj.getTitle());
        entity.setAid(obj.getAid());
        entity.setTid(obj.getTid());
        entity.setPid(obj.getPid());
        return daoBook.update(entity);
    }

    @Override
    public BookDTO search(String s) throws SQLException, ClassNotFoundException {
        BookEntity entity = daoBook.search(s);
        BookDTO dto= new BookDTO();
        dto.setBookId(entity.getBid());
        dto.setTitle(entity.getTitle());
        dto.setAid(entity.getAid());
        dto.setTid(entity.getTid());
        dto.setPid(entity.getPid());
        return dto;
    }

    @Override
    public boolean addAuthor(BookDTO obj) throws SQLException, ClassNotFoundException {
        AuthorEntity authorEntity =new AuthorEntity(obj.getAuthorName());
        return daoAuthor.add(authorEntity);
    }

    @Override
    public boolean addPublisher(BookDTO obj) throws SQLException, ClassNotFoundException {

        PublisherEntity publisherEntity=new PublisherEntity(obj.getPublisherName(),obj.getPublisherContact());
        return daoPublisher.add(publisherEntity);
    }

    @Override
    public boolean addType(BookDTO obj) throws SQLException, ClassNotFoundException {

        TypeEntity typeEntity=new TypeEntity();
        typeEntity.setName(obj.getTypeName());
        return daoType.add(typeEntity);
    }

    @Override
    public boolean addSection(BookDTO obj) throws SQLException, ClassNotFoundException {
        SectionEntity sectionEntity=new SectionEntity(obj.getSectionName());
        return daoSection.add(sectionEntity);
    }

    @Override
    public ArrayList<BookDTO> loadAllAuthor() throws SQLException, ClassNotFoundException {

        ArrayList<AuthorEntity> entity = daoAuthor.load();
        ArrayList<BookDTO> dto= new ArrayList<>();
        for (AuthorEntity e :entity){
            BookDTO d= new BookDTO();
            d.setAid(e.getAid());
            d.setAuthorName(e.getName());
            dto.add(d);
        }
        return dto;
    }

    @Override
    public ArrayList<BookDTO> loadAllPublisher() throws SQLException, ClassNotFoundException {
        ArrayList<PublisherEntity> entity=daoPublisher.load();
        ArrayList<BookDTO> dto=new ArrayList<>();
        for(PublisherEntity e: entity){
            BookDTO d=new BookDTO();
            d.setPid(e.getPid());
            d.setPublisherName(e.getName());
            d.setPublisherContact(e.getContact());
            dto.add(d);
        }
        return dto;

    }

    @Override
    public ArrayList<BookDTO> loadAllType() throws SQLException, ClassNotFoundException {
        ArrayList<TypeEntity> load=daoType.load();
        ArrayList<BookDTO> dto=new ArrayList<>();
        for(TypeEntity e: load){
            BookDTO d=new BookDTO();
            d.setTid(e.getTid());
            d.setSid(e.getSid());
            d.setTypeName(e.getName());
            dto.add(d);
        }
        return dto;
    }

    @Override
    public ArrayList<BookDTO> loadAllSection() throws SQLException, ClassNotFoundException {
        ArrayList<SectionEntity> load=daoSection.load();
        ArrayList<BookDTO> dto=new ArrayList<>();
        for(SectionEntity e: load){
            BookDTO b=new BookDTO();
            b.setSid(e.getSid());
            b.setSectionName(e.getDescription());
            dto.add(b);

        }
        return dto;
    }
}
