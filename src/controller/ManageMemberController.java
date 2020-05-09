package controller;

import bo.BOFactory;
import bo.custom.ManageMembersBO;
import com.jfoenix.controls.JFXTextField;
import dto.MembersDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.MemberTM;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ManageMemberController implements Initializable {

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtId;

    @FXML
    private TableView<MemberTM> tblMember;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private RadioButton rbtnMale;

    @FXML
    private RadioButton rbtnFemale;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private TextField txtSearch;

    @FXML
    private RadioButton rbtnStudent;

    @FXML
    private RadioButton rbtnOther;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtMonth;

    @FXML
    private TextField txtDay;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ToggleGroup occpation;

    @FXML
    private Label totalMember;

    private int memberCount;

    ManageMembersBO bo = (ManageMembersBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        memberCount = 0;

        tblMember.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("mid"));
        tblMember.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMember.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblMember.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblMember.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblMember.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblMember.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblMember.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("occupation"));
        tblMember.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("dob"));

        loadAllMembers();
    }

    @FXML
    void actionTxtAddress(KeyEvent event) {

    }

    @FXML
    void actionTxtContact(KeyEvent event) {

    }

    @FXML
    void actionTxtEmail(KeyEvent event) {

    }

    @FXML
    void actionTxtName(KeyEvent event) {
if(event.getCode()==KeyCode.ENTER){
        txtNIC.requestFocus();}

    }

    @FXML
    void actionTxtNic(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
        txtYear.requestFocus();}

    }

    @FXML
    void actionTxtYear(KeyEvent event) {

    }


        @FXML
    void actionSearch(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            try {

                MembersDTO dto = bo.search(txtId.getText());

                txtName.setText(dto.getName());
                txtEmail.setText(dto.getEmail());
                txtNIC.setText(dto.getNic());
                txtContact.setText(Integer.toString(dto.getContact()));
                txtAddress.setText(dto.getAddress());
                txtEmail.setText(dto.getEmail());
                String date= dto.getDob().toString();
                txtYear.setText(date.split("-")[0]);
                txtMonth.setText(date.split("-")[1]);
                txtDay.setText(date.split("-")[2]);
                if (dto.getGender().equals("Male")) {
                    rbtnMale.setSelected(true);
                } else {
                    rbtnFemale.setSelected(true);
                }
                if ( dto.getOccupation().equals("Student")){
                    rbtnStudent.setSelected(true);
                }else {
                    rbtnOther.setSelected(true);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    void actionAddMember(ActionEvent event) {

        String name = txtName.getText();
        if(Pattern.compile("^[A-z ]{5,20}$").matcher(name).matches()){
        String nic = txtNIC.getText();
        String address = txtAddress.getText();
            if(Pattern.compile("^[A-z0-9]{5,20}$").matcher(address).matches()){
        int contact = Integer.parseInt(txtContact.getText());
        if(Pattern.compile("^[0-9]{10}$").matcher(txtContact.getText()).matches()){
                    String email = txtEmail.getText();
                    String year = txtYear.getText();
                    String month = txtMonth.getText();
                    String day = txtDay.getText();
                    String dateString = day + "/" + month + "/" + year;
                    Date date = null;
                    String gender = null;
                    String occupation = null;
                    try {
                        date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    if (rbtnMale.isSelected()) {
                        gender = "Male";
                    } else if (rbtnFemale.isSelected()) {
                        gender = "Female";

                    }
                    if (rbtnOther.isSelected()) {
                        occupation = "Other";
                    } else if (rbtnStudent.isSelected()) {
                        occupation = "Student";
                    }


            MembersDTO membersDTO = new MembersDTO(name, nic, address, contact, email, date, gender, occupation);
            boolean b = false;

            try {
                b = bo.add(membersDTO);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            if (b) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Member Added");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Failed");
                alert.show();
            }
                }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Input Format!");
            alert.show();}
        }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid Input Format!");
                alert.show();}
                }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Input Format!");
            alert.show();
            }


        loadAllMembers();
    }

    @FXML
    void actionRemove(ActionEvent event) throws SQLException, ClassNotFoundException {

        String id = txtId.getText();
        boolean b = bo.delete(id);

        if (b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Member Removed");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed");
            alert.show();
        }

        loadAllMembers();
    }

    @FXML
    void actionUpdate(ActionEvent event) {

        int mid = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String nic = txtNIC.getText();
        String address = txtAddress.getText();
        int contact = Integer.parseInt(txtContact.getText());
        String email = txtEmail.getText();
        String year = txtYear.getText();
        String month = txtMonth.getText();
        String day = txtDay.getText();
        String dateString = day+"/"+month+"/"+year;
        Date date= null;
        String gender = null;
        String occupation = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        if (rbtnMale.isSelected()) {
            gender = "Male";
        } else if (rbtnFemale.isSelected()) {
            gender = "Female";
        }
        if(rbtnOther.isSelected()){
            occupation = "Other";
        }else if( rbtnStudent.isSelected()){
            occupation = "Student";
        }

        MembersDTO membersDTO = new MembersDTO(name, nic, address, contact,  email, date, gender, occupation);
        membersDTO.setMid(mid);
        boolean b = false;
        try {
            b = bo.update(membersDTO);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if (b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Member Updated");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed");
            alert.show();
        }

        loadAllMembers();
    }

    @FXML
    void onActionSearch(ActionEvent event) {

    }

    @FXML
    void actionTblMember(MouseEvent event) {
        MemberTM tm=tblMember.getSelectionModel().getSelectedItem();
        txtId.setText(Integer.toString(tm.getMid()));
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getAddress());
        txtNIC.setText(tm.getNic());
        txtEmail.setText(tm.getEmail());
        if(tm.getGender().equals("Male")){
            rbtnMale.setSelected(true);
        }else{
            rbtnFemale.setSelected(true);
        }
        if(tm.getOccupation().equals("Student")){
            rbtnStudent.setSelected(true);
        }else{
            rbtnOther.setSelected(true);
        }
        String date=tm.getDob().toString();
        txtYear.setText(date.split("-")[0]);
        txtMonth.setText(date.split("-")[1]);
        txtDay.setText(date.split("-")[2]);


    }


    public void loadAllMembers() {

        memberCount = 0;
        try {
            ArrayList<MembersDTO> allMember = bo.load();
            ArrayList<MemberTM> tm = new ArrayList<>();

            for (MembersDTO d : allMember) {
                memberCount++;
                MemberTM memberTM = new MemberTM(d.getMid(), d.getName(), d.getNic(), d.getAddress(), d.getGender(), d.getContact(), d.getEmail(), d.getOccupation(), d.getDob());
                tm.add(memberTM);
            }
            tblMember.setItems(FXCollections.observableArrayList(tm));
            totalMember.setText(Integer.toString(memberCount));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}

