package bo;

import bo.custom.impl.*;
import crud.Super;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{
        MEMBER,BOOK,LEND,POLICIE,RECEPTIONIST,FINE;
    }

    public Super getBO(BOTypes t){
        switch (t){
            case MEMBER: return new ManageMemberBOImpl();
            case BOOK: return new ManageBookBOImpl();
            case LEND: return new MakeLendBOImpl();
            case POLICIE: return new ManagePolicieBOImpl();
            case RECEPTIONIST: return new ManageReceptionistBOImpl();
            case FINE:return new PayFineBOImpl();
            default: return null;
        }
    }
}
