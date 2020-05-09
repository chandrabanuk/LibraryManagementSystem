package controller;

import bo.BOFactory;
import bo.custom.MakeLendBO;
import dto.BookDTO;
import dto.LendDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.BookTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class MakeLendController implements Initializable {

    @FXML
    private BorderPane pneMakeLend;

    @FXML
    private Button btnAddMember;

    @FXML
    private TextField txtSearchMid;

    @FXML
    private TextField txtTitle;

    @FXML
    private Label lblDueDate;

    @FXML
    private RadioButton rbtnTitle;

    @FXML
    private ToggleGroup book;

    @FXML
    private RadioButton rbtnAuthor;

    @FXML
    private TextField txtMid;

    @FXML
    private TextField txtIssueDate;

    @FXML
    private TextField txtDueDate;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtMemberType;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtContact;

    @FXML
    private TableView<LendDTO> tblBookDetail;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtDescription;

    @FXML
    private Button btnBorrow;

    @FXML
    private Button btnPay;

    @FXML
    private Button btnReturn;

    @FXML
    private AnchorPane pneSub;

    @FXML
    private Label txtNextName;

    @FXML
    private TextField txtBid2;

    @FXML
    private TextField txtLid;

    @FXML
    private TextField txtMidShow;

    @FXML
    private Button btnConfirm;



    ArrayList<LendDTO> searchDetails;

    MakeLendBO bo= (MakeLendBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.LEND);


    @FXML
    void actionNew(ActionEvent event) throws IOException {
            txtNextName.setText(txtName.getText());
            txtId.requestFocus();
    }

    @FXML
    void actionReturnBtn(ActionEvent event) {
        try {
            boolean b=bo.returnBook(txtBid2.getText());

            if(b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Book Returned");
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
        loadAllBooks();

    }

    @FXML
    void actionAddMember(MouseEvent event) throws IOException {

    }

    @FXML
    void actionPayFine(ActionEvent event) throws IOException {
        Parent parent=FXMLLoader.load(getClass().getResource("../view/PayFine.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    void actionSearchMid(KeyEvent event){
        if(event.getCode()== KeyCode.ENTER){
            try {
                System.out.println(txtSearchMid.getText());
                LendDTO dto=bo.addLendDetail(txtSearchMid.getText());

                txtName.setText(dto.getMemberName());
                txtMemberType.setText(dto.getMember_type());
                txtNic.setText(dto.getNic());
                txtContact.setText(Integer.toString(dto.getContact()));
                txtAddress.setText(dto.getAddress());
                System.out.println(dto.getTitle());
                txtTitle.setText(dto.getTitle());
                txtIssueDate.setText(dto.getIssue_date());
                txtDueDate.setText(dto.getDue_date());
                txtPrice.setText(Double.toString(dto.getPrice()));
                txtMidShow.setText(txtSearchMid.getText());
                System.out.println(dto.getBookId()+"===========================");
                txtBid2.setText(dto.getBookId());

                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
                Date issueDate=dateFormat.parse(dto.getIssue_date());
                Date dueDate= dateFormat.parse(dto.getDue_date());
                Date today= new Date();
                if(today.after(dueDate)){
                    btnReturn.setDisable(true);
                }else {
                    btnPay.setDisable(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void actionTxtId(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd");
            Date date= new Date();
            Calendar calendar= Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 14);
            Date dueDate = calendar.getTime();
            try {
                searchDetails= bo.getBookById(txtId.getText());
                LendDTO lendDTO= searchDetails.get(0);
                System.out.println(lendDTO.getAvailability());
                if (lendDTO.getAvailability().equals("No")){
                    btnConfirm.setDisable(true);
                }
                lendDTO.setBookId(txtId.getText());
                txtDescription.setText(lendDTO.getTitle());
                lblDueDate.setText(dateFormat.format(dueDate));
                tblBookDetail.setItems(FXCollections.observableArrayList(searchDetails));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void actionConfirmBorrow(ActionEvent event) {

        String mid = txtMidShow.getText();
        String bid = txtBid2.getText();
        String bookid = txtId.getText();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd");
        String today= dateFormat.format(new Date());
        Date returnDate= null;
        try {
            Date dueDate= dateFormat.parse(lblDueDate.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LendDTO dto= new LendDTO();
        dto.setBookId(bookid);
        dto.setMid(Integer.parseInt(mid));
        dto.setIssue_date(today);
        dto.setDue_date(lblDueDate.getText());
        try {
            boolean add = bo.add(dto);
            if (add) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Lending Added");
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

        loadAllBooks();
    }

    @FXML
    void actionSearchLid(KeyEvent event) {

    }

    void loadAllBooks(){
        try {
            searchDetails=bo.loadAllBooks();
            tblBookDetail.setItems(FXCollections.observableArrayList(searchDetails));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblBookDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bookId"));
        tblBookDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
        tblBookDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("authorName"));
        tblBookDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("publisherName"));
        tblBookDetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblBookDetail.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("availability"));

        loadAllBooks();

    }

    @FXML
    void actionSearchBid(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER) {
            try {
                LendDTO dto = bo.getDetailsBID(txtBid2.getText());
                txtMidShow.setText(dto.getMid()+"");
                txtName.setText(dto.getMemberName());
                txtMemberType.setText(dto.getMember_type());
                txtNic.setText(dto.getNic());
                txtContact.setText(Integer.toString(dto.getContact()));
                txtAddress.setText(dto.getAddress());
                txtTitle.setText(dto.getTitle());
                txtIssueDate.setText(dto.getIssue_date());
                txtDueDate.setText(dto.getDue_date());
                txtPrice.setText(Double.toString(dto.getPrice()));
                txtSearchMid.setText(dto.getMid()+"");

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date issueDate = dateFormat.parse(dto.getIssue_date());
                Date dueDate = dateFormat.parse(dto.getDue_date());
                Date today = new Date();
                if (today.after(dueDate)) {
                    btnReturn.setDisable(true);
                } else {
                    btnPay.setDisable(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
