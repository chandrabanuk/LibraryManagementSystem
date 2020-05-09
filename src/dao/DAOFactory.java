package dao;

import crud.Super;
import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        ACCOUNT,BOOK,FINE,LENDDETAIL,RECEPTIONIST,MEMBER,AUTHOR,PUBLISHER,TYPE,SECTION,QUERY;
    }

    public Super getDAO(DAOTypes t){
        switch (t){
            case MEMBER: return new MemberDAOImpl();
            case AUTHOR: return new AuthorDAOImpl();
            case PUBLISHER: return new PublisherDAOImpl();
            case TYPE:return new TypeDAOImpl();
            case SECTION:return new SectionDAOImpl();
            case FINE: return new FineDAOImpl();
            case RECEPTIONIST: return new ReceptionistDAOImpl();
            case BOOK: return new BookDAOImpl();
            case ACCOUNT: return new AccountDAOImpl();
            case LENDDETAIL: return new LendDetailDAOImpl();
            case QUERY:return new QueryDAO();
            default: return null;
        }
    }
}
