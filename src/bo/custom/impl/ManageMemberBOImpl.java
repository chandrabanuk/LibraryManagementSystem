package bo.custom.impl;

import bo.custom.ManageMembersBO;
import dao.DAOFactory;
import dao.custom.MemberDAO;
import dto.MembersDTO;
import entity.MemberEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageMemberBOImpl implements ManageMembersBO {

    private MemberDAO dao= (MemberDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMBER);


    @Override
    public boolean add(MembersDTO obj) throws SQLException, ClassNotFoundException {

        MemberEntity entity= new MemberEntity(obj.getName(),obj.getNic(), obj.getAddress(), obj.getContact(), obj.getEmail(), obj.getDob(),obj.getGender(),obj.getOccupation());
        return dao.add(entity);

    }

    @Override
    public ArrayList<MembersDTO> load() throws SQLException, ClassNotFoundException {

        ArrayList<MemberEntity> load = dao.load();
        ArrayList<MembersDTO> allMembersDTOS= new ArrayList<>();

        for(MemberEntity e:load){

            MembersDTO dto= new MembersDTO(e.getMid(), e.getName(), e.getNic(),e.getAddress(), e.getContact(), e.getEmail(), e.getDob(), e.getGender(), e.getMemberType());
            allMembersDTOS.add(dto);

        }
        return allMembersDTOS;

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {

        return dao.delete(s);
    }

    @Override
    public boolean update(MembersDTO obj) throws SQLException, ClassNotFoundException {

        MemberEntity entity= new MemberEntity(obj.getMid(), obj.getName(), obj.getNic(),obj.getAddress(), obj.getContact(), obj.getEmail(), obj.getDob(), obj.getGender(), obj.getOccupation());
        return dao.update(entity);

    }

   @Override
    public MembersDTO search(String s) throws SQLException, ClassNotFoundException {

       MemberEntity e= dao.search(s);
       return new MembersDTO(e.getMid(), e.getName(), e.getNic(),e.getAddress(), e.getContact(), e.getEmail(), e.getDob(), e.getGender(), e.getMemberType());
    }


}
