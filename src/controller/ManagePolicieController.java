package controller;

import bo.BOFactory;
import bo.custom.ManagePolicieBO;
import com.jfoenix.controls.JFXTextField;
import dto.BookDTO;
import dto.PoliciesDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManagePolicieController implements Initializable {

    @FXML
    private RadioButton rbtnType;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton rbtnAuthor;

    @FXML
    private RadioButton rbtnPublisher;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    private TextField txtSearch;

    ManagePolicieBO bo= (ManagePolicieBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.POLICIE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void idOnAction(KeyEvent event) {
        if((event.getCode() == KeyCode.ENTER)){
            if(rbtnAuthor.isSelected()){
                try {

                    PoliciesDTO author = bo.searchAuthor(txtId.getText());
                    txtName.setText(author.getAuthorName());
                    txtNumber.setText("N/A");

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else if (rbtnPublisher.isSelected()){

                try {
                    PoliciesDTO publisher= bo.searchPublisher(txtId.getText());
                    txtName.setText(publisher.getPublisherName());
                    txtNumber.setText(publisher.getPublisherContact()+"");

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } else if (rbtnType.isSelected()){

                try {
                    PoliciesDTO type= bo.searchType(txtId.getText());
                    txtName.setText(type.getTypeName());
                    txtNumber.setText("N/A");

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @FXML
    public void txtSearchOnAction(KeyEvent event) {
        txtId.setText(txtSearch.getText());
        idOnAction(event);
    }

    @FXML
    public void removeAction(ActionEvent event) {
        if(rbtnAuthor.isSelected()) {
            try {
                boolean b = bo.deleteAuthor(txtSearch.getText());
                if (b) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Author Removed");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Failed");
                    alert.show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }if(rbtnPublisher.isSelected()){
            try {
                boolean b=bo.deletePublisher(txtSearch.getText());
                if(b){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Publisher Removed");
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
        }
        if(rbtnType.isSelected()){
            try {
                boolean b=bo.deleteType(txtSearch.getText());
                if(b){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Type Removed");
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
        }

        }

    @FXML
    public void updateAction(ActionEvent event) {
        if(rbtnPublisher.isSelected()) {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            int contact = Integer.parseInt(txtNumber.getText());

            PoliciesDTO policiesDTO=new PoliciesDTO();
            policiesDTO.setPublisherId(id);
            policiesDTO.setPublisherName(name);
            policiesDTO.setPublisherContact(contact);

            try {
                boolean b=bo.updatePublisher(policiesDTO);
                if(b){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Publisher Updated");
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
        }
        if(rbtnType.isSelected()) {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();

            PoliciesDTO policiesDTO=new PoliciesDTO();
            policiesDTO.setTypeId(id);
            policiesDTO.getTypeName();

            try {
                boolean b=bo.updateType(policiesDTO);
                if(b){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Type Updated");
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

        }
        if(rbtnAuthor.isSelected()){
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();

            PoliciesDTO policiesDTO=new PoliciesDTO();
            policiesDTO.setAuthorId(id);
            policiesDTO.setAuthorName(name);

            try {
                boolean b=bo.updateAuthor(policiesDTO);
                if(b){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Author Updated");
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
        }


    }

}
