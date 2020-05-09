package controller;

import bo.BOFactory;
import bo.custom.ManageReceptionistBO;
import com.jfoenix.controls.JFXTextField;
import dto.ReceptionistDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.ReceptionistTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageReceptionistController implements Initializable {


    @FXML
    private JFXTextField txtRid;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private RadioButton radiobtnMale;

    @FXML
    private JFXTextField txtCurrentPassword;

    @FXML
    private RadioButton radiobtnFemale;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<ReceptionistTM> tblReceptionist;

    @FXML
    private JFXTextField txtNewPassword;

    @FXML
    private JFXTextField txtConfirmPassword;

    @FXML
    private ToggleGroup gender;

    ManageReceptionistBO bo= (ManageReceptionistBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RECEPTIONIST);

    @FXML
    void actionConfirm(ActionEvent event) {
        String newPassword=txtNewPassword.getText();
        String confirmPassword=txtConfirmPassword.getText();
        if(newPassword.equals(confirmPassword)){
            String receptionistName = txtName.getText();
            String nic = txtNIC.getText();
            String address = txtAddress.getText();
            int contact = Integer.parseInt(txtContact.getText());
            int account_id = 0;
            String gender = null;
            if (radiobtnMale.isSelected()) {
                gender = "Male";
            } else if (radiobtnFemale.isSelected()) {
                gender = "Female";
            }

            ReceptionistDTO receptionistDTO = new ReceptionistDTO();
            receptionistDTO.setName(receptionistName);
            receptionistDTO.setNIC(nic);
            receptionistDTO.setAddress(address);
            receptionistDTO.setContact(contact);
            receptionistDTO.setGender(gender);
            receptionistDTO.setAccountId(account_id);
            receptionistDTO.setAccountName(receptionistName);
            receptionistDTO.setPassword(newPassword);
            try {
                boolean b=bo.addReceptionist(receptionistDTO);
                if(b){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Receptionist Added");
                    alert.show();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Receptionist Adding Failed");
                    alert.show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("ERROR");
            alert.show();
        }
        loadAllReceptionists();


    }

    @FXML
    void addReceptionist(ActionEvent event) {
        txtNewPassword.requestFocus();

    }

    @FXML
    void actionUpdateReceptionist(ActionEvent event) {

        int rid=Integer.parseInt(txtRid.getText());
        String name=txtName.getText();
        String nic=txtNIC.getText();
        String address=txtAddress.getText();
        String gender=null;
        if(radiobtnMale.isSelected()){
            gender="Male";
        }else if(radiobtnFemale.isSelected()){
            gender="Female";
        }
        int contact=Integer.parseInt(txtContact.getText());
        int accountId=1;
        String password=txtCurrentPassword.getText();

        ReceptionistDTO dto=new ReceptionistDTO();
        dto.setRID(rid);
        dto.setName(name);
        dto.setNIC(nic);
        dto.setAddress(address);
        dto.setGender(gender);
        dto.setContact(contact);
        dto.setPassword(password);
        try {
            boolean b=bo.updateReceptionist(dto);
            if(b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Receptionist Updated");
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Failed");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        loadAllReceptionists();

    }

    @FXML
    void actionRemoveReceptionist(ActionEvent event) {
        String id=txtRid.getText();
        try {
            boolean b=bo.delete(id);

            if(b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Receptionist Removed");
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
        loadAllReceptionists();


    }



    @FXML
    void actionTblReceptionist(MouseEvent event) {
        ReceptionistTM tm=tblReceptionist.getSelectionModel().getSelectedItem();
        txtRid.setText(Integer.toString(tm.getReceptionistId()));
        txtName.setText(tm.getName());
        txtNIC.setText(tm.getNIC());
        txtAddress.setText(tm.getAddress());
        if(tm.getGender().equals("Male")){
            radiobtnMale.setSelected(true);
        }else{
            radiobtnFemale.setSelected(true);
        }
        txtContact.setText(Integer.toString(tm.getContact()));

    }


    void loadAllReceptionists(){
        try {
            ArrayList<ReceptionistDTO> allReceptionists=bo.load();
            ArrayList<ReceptionistTM> tm=new ArrayList<>();
            for(ReceptionistDTO d: allReceptionists){
                ReceptionistTM receptionistTM=new ReceptionistTM();
                receptionistTM.setReceptionistId(d.getRID());
                receptionistTM.setName(d.getName());
                receptionistTM.setNIC(d.getNIC());
                receptionistTM.setAddress(d.getAddress());
                receptionistTM.setGender(d.getGender());
                receptionistTM.setContact(d.getContact());
                tm.add(receptionistTM);
            }

            tblReceptionist.setItems(FXCollections.observableArrayList(tm));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchByRID(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            ReceptionistDTO dto = null;
            try {
                dto = bo.search(txtRid.getText());
                txtName.setText(dto.getName());
                txtNIC.setText(dto.getNIC());
                txtAddress.setText(dto.getAddress());
                txtContact.setText(Integer.toString(dto.getContact()));
                if (dto.getGender().equals("Female")) {
                    radiobtnFemale.setSelected(true);

                } else if (dto.getGender().equals("Male")) {
                    radiobtnMale.setSelected(true);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }



        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblReceptionist.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ReceptionistId"));
        tblReceptionist.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblReceptionist.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("NIC"));
        tblReceptionist.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblReceptionist.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblReceptionist.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("contact"));
        loadAllReceptionists();
    }
}
