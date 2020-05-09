package controller;

import bo.BOFactory;
import bo.custom.PayFineBO;
import dto.FineDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class PayFineController {
    PayFineBO bo= (PayFineBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.FINE);

    @FXML
    private TextField txtLid;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtBookName;


    @FXML
    private TextField txtReceptionistId;

    @FXML
    private TextField txtMid;

    @FXML
    void actionAddPayment(ActionEvent event) {

        int lid= Integer.parseInt(txtLid.getText());
        int mid=Integer.parseInt(txtMid.getText());
        String bookName=txtBookName.getText();
        double amount=Double.parseDouble(txtAmount.getText());
        int rid=Integer.parseInt(txtReceptionistId.getText());

        FineDTO fineDTO=new FineDTO();
        fineDTO.setMid(mid);
        fineDTO.setLid(lid);
        fineDTO.setBookName(bookName);
        fineDTO.setAmount(amount);
        fineDTO.setRid(rid);

        try {
            boolean b= bo.add(fineDTO);
            if(b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Fine Added");
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Failed");
                alert.show();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

}

