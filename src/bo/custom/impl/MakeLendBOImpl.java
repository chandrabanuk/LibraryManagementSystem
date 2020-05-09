package bo.custom.impl;

import bo.custom.MakeLendBO;
import dao.DAOFactory;
import dao.custom.BookDAO;
import dao.custom.LendDetailDAO;
import dao.custom.impl.QueryDAO;
import db.DBConnection;
import dto.BookDTO;
import dto.LendDTO;
import entity.BookEntity;
import entity.LendDetailEntity;
import entity.LendEntity;
import entity.QueryEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MakeLendBOImpl implements MakeLendBO {
    QueryDAO daoQuery= (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    BookDAO daoBook= (BookDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK);
    LendDetailDAO daoLendDetail= (LendDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LENDDETAIL);

    @Override
    public boolean add(LendDTO obj) throws SQLException, ClassNotFoundException {

        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd");
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        LendDetailEntity lendDetailEntity= new LendDetailEntity();
        lendDetailEntity.setBid(Integer.parseInt(obj.getBookId()));
        lendDetailEntity.setMid(obj.getMid());
        try {
            lendDetailEntity.setDueDate(dateFormat.parse(obj.getDue_date()));
            lendDetailEntity.setIssueDate(dateFormat.parse(obj.getIssue_date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean lend = daoLendDetail.add(lendDetailEntity);
        System.out.println(lend+"=================");

        boolean book = daoBook.lendBook(obj.getBookId());
        System.out.println(book+"==================");

        if(lend && book){
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

    }

    @Override
    public ArrayList<LendDTO> load() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(LendDTO obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public LendDTO search(String s) throws SQLException, ClassNotFoundException {
        BookEntity entity=daoBook.search(s);
        LendDTO dto=new LendDTO();
        dto.setTitle(entity.getTitle());

        return dto;
    }

   public LendDTO addLendDetail(String id) throws SQLException, ClassNotFoundException {

        LendDTO lendDTO=new LendDTO();
        LendEntity entity = daoQuery.getLendDetail(id);
        lendDTO.setBookId(entity.getBid()+"");
        lendDTO.setMemberName(entity.getMemberName());
        lendDTO.setMember_type(entity.getMember_type());
        lendDTO.setNic(entity.getNic());
        lendDTO.setContact(entity.getContact());
        lendDTO.setAddress((entity.getAddress()));
        lendDTO.setTitle(entity.getTitle());
        lendDTO.setAvailability(entity.getAvailability());
        lendDTO.setIssue_date(entity.getIssue_date());
        lendDTO.setDue_date(entity.getDue_date());
        lendDTO.setPrice(entity.getPrice());

        return lendDTO;

   }

    @Override
    public boolean returnBook(String id) throws SQLException, ClassNotFoundException {
        return daoBook.returnBook(id);
    }

    @Override
    public ArrayList<LendDTO> getBookById(String id) throws SQLException, ClassNotFoundException {
        ArrayList<QueryEntity> bookById = daoQuery.getBookById(id);
        ArrayList<LendDTO> list= new ArrayList<>();
        for(QueryEntity e:bookById){
            LendDTO dto= new LendDTO();
            dto.setTitle(e.getTitle());
            dto.setAuthorName(e.getAuthor_name());
            dto.setPublisherName(e.getPublisherName());
            dto.setType(e.getTypeName());
            dto.setPrice(e.getPrice());
            dto.setAvailability(e.getAvailability());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<LendDTO> loadAllBooks() throws SQLException, ClassNotFoundException {
        ArrayList<QueryEntity> bookById = daoQuery.loadAllBooks();
        ArrayList<LendDTO> list= new ArrayList<>();
        for(QueryEntity e:bookById){
            LendDTO dto= new LendDTO();
            dto.setBookId(e.getBookId());
            dto.setTitle(e.getTitle());
            dto.setAuthorName(e.getAuthor_name());
            dto.setPublisherName(e.getPublisherName());
            dto.setType(e.getTypeName());
            dto.setPrice(e.getPrice());
            dto.setAvailability(e.getAvailability());
            list.add(dto);
        }
        return list;
    }

    @Override
    public LendDTO getDetailsBID(String id) throws SQLException, ClassNotFoundException {
        LendDTO lendDTO=new LendDTO();
        LendEntity entity = daoQuery.getDetailsBID(id);
        lendDTO.setMid(entity.getMid());
        lendDTO.setMemberName(entity.getMemberName());
        lendDTO.setMember_type(entity.getMember_type());
        lendDTO.setNic(entity.getNic());
        lendDTO.setContact(entity.getContact());
        lendDTO.setAddress((entity.getAddress()));
        lendDTO.setTitle(entity.getTitle());
        lendDTO.setIssue_date(entity.getIssue_date());
        lendDTO.setDue_date(entity.getDue_date());
        lendDTO.setPrice(entity.getPrice());

        return lendDTO;
    }


}
