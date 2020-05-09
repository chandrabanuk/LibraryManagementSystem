package bo.custom.impl;

import bo.custom.PayFineBO;
import dao.DAOFactory;
import dao.custom.FineDAO;
import dto.FineDTO;
import entity.FineEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class PayFineBOImpl implements PayFineBO {
    FineDAO dao = (FineDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FINE);

    @Override
    public boolean add(FineDTO obj) throws SQLException, ClassNotFoundException {
        FineEntity fineEntity=new FineEntity();
        fineEntity.setAmount(obj.getAmount());
        fineEntity.setLid(obj.getLid());
        fineEntity.setRid(obj.getRid());
        return dao.add(fineEntity);
    }

    @Override
    public ArrayList<FineDTO> load() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(FineDTO obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public FineDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
