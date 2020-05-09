package controller;

import bo.BOFactory;
import bo.custom.ManageBookBO;
import com.jfoenix.controls.JFXTextField;
import dto.BookDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.input.MouseEvent;
import model.BookTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageBookController implements Initializable {

    @FXML
    private JFXTextField txtBID;

    @FXML
    private JFXTextField txtAuthorName;

    @FXML
    private JFXTextField txtPublisherName;

    @FXML
    private JFXTextField txtType;

    @FXML
    private JFXTextField txtPublisherTel;

    @FXML
    private JFXTextField txtSection;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private ComboBox<String> cmbAuthor;

    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private ComboBox<String> cmbPublisher;

    @FXML
    private ComboBox<String> cmbSection;

    @FXML
    private TableView<BookTM> tblBook;

    ArrayList<BookDTO> author;

    ArrayList<BookDTO> publisher;

    ArrayList<BookDTO> type;

    ManageBookBO bo = (ManageBookBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BOOK);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
        tblBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBook.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("publisher"));

        loadAuthorCombo();
        loadPublisherCombo();
        loadTypeCombo();
        loadSectionCombo();
        loadBookTbl();
    }

    @FXML
    void actionAddPublisher(ActionEvent event) {

        BookDTO dto = new BookDTO();
        dto.setPublisherName(txtPublisherName.getText());
        dto.setPublisherContact(Integer.parseInt(txtPublisherTel.getText()));
        boolean b = false;
        try {

            b = bo.addPublisher(dto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if (b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Publisher Added");
            alert.show();
            ;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed");
            alert.show();
        }

        loadPublisherCombo();
    }

    @FXML
    void actionAddSection(ActionEvent event) {

        BookDTO dto = new BookDTO();
        dto.setSectionName(txtSection.getText());
        boolean b = false;
        try {
            b = bo.addSection(dto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if (b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Section Added");
            alert.show();
            txtAuthorName.clear();
            ;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed");
            alert.show();
        }

        loadSectionCombo();

    }

    @FXML
    void addTypeAction(ActionEvent event) {

        BookDTO dto = new BookDTO();
        dto.setTypeName(txtType.getText());
        boolean b = false;

        try {
            b = bo.addType(dto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if (b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Type Added");
            alert.show();
            txtAuthorName.clear();
            ;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed");
            alert.show();
        }
        loadTypeCombo();

    }

    @FXML
    void addAuthorAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        BookDTO dto = new BookDTO();
        dto.setAuthorName(txtAuthorName.getText());
        boolean b = bo.addAuthor(dto);

        if (b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Author Added");
            alert.show();
            txtAuthorName.clear();
            ;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed");
            alert.show();
        }

        loadAuthorCombo();
    }

    @FXML
    void editOnAction(ActionEvent event) {
        String bid = txtBID.getText();


        String title = txtTitle.getText();
        int aid=0;
        int pid=0;
        int tid=0;
        for(BookDTO d:author){
            if(d.getAuthorName()== cmbAuthor.getSelectionModel().getSelectedItem()){
                aid= d.getAid();
            }
        }
        for(BookDTO d:publisher){
            if(d.getPublisherName()== cmbPublisher.getSelectionModel().getSelectedItem()){
                pid= d.getPid();
            }
        }
        for(BookDTO d:type){
            if(d.getTypeName()== cmbType.getSelectionModel().getSelectedItem()){
                tid= d.getTid();
            }
        }

        BookDTO dto= new BookDTO();
        dto.setBookId(Integer.parseInt(bid));
        dto.setTitle(title);
        dto.setAid(aid);
        dto.setPid(pid);
        dto.setTid(tid);

        try {
            boolean b=bo.update(dto);
            if(b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Book Updated");
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

        loadBookTbl();
    }

    @FXML
    void removeOnAction(ActionEvent event) {


        try {
           boolean b= bo.delete(txtBID.getText());

           if(b){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setContentText("Book Removed");
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

        loadBookTbl();
    }

    @FXML
    void actionTblBook(MouseEvent event) {


    }




    @FXML
    void actionAddBook(ActionEvent event) {

        boolean b=false;

        String title = txtTitle.getText();
        int aid=0;
        int pid=0;
        int tid=0;
        for(BookDTO d:author){
            if(d.getAuthorName()== cmbAuthor.getSelectionModel().getSelectedItem()){
                aid= d.getAid();
            }
        }
        for(BookDTO d:publisher){
            if(d.getPublisherName()== cmbPublisher.getSelectionModel().getSelectedItem()){
                pid= d.getPid();
            }
        }
        for(BookDTO d:type){
            if(d.getTypeName()== cmbType.getSelectionModel().getSelectedItem()){
                tid= d.getTid();
            }
        }

        BookDTO dto= new BookDTO();
        dto.setTitle(title);
        dto.setAid(aid);
        dto.setPid(pid);
        dto.setTid(tid);

        try {
            b = bo.add(dto);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Book Added");
            alert.show();
            txtAuthorName.clear();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed");
            alert.show();
        }

        loadBookTbl();

    }

    @FXML
    void txtBIDAction(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){

            try {
                BookDTO dto = bo.search(txtBID.getText());
                txtTitle.setText(dto.getTitle());
                cmbAuthor.getSelectionModel().select(dto.getAid()-1);
                cmbType.getSelectionModel().select(dto.getTid()-1);
                cmbPublisher.getSelectionModel().select(dto.getPid()-1);
                cmbSection.getSelectionModel().selectFirst();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    void loadAuthorCombo() {
        try {

            author = bo.loadAllAuthor();
            ArrayList<String> list = new ArrayList<>();
            for (BookDTO d : author) {
                String s = d.getAuthorName();
                list.add(s);
            }

            cmbAuthor.setItems(FXCollections.observableArrayList(list));
            cmbAuthor.getSelectionModel().selectFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void loadPublisherCombo() {

        try {

            publisher = bo.loadAllPublisher();
            ArrayList<String> all = new ArrayList<>();
            for (BookDTO d : publisher) {
                String s = d.getPublisherName();
                all.add(s);
            }

            cmbPublisher.setItems(FXCollections.observableArrayList(all));
            cmbPublisher.getSelectionModel().selectFirst();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    void loadTypeCombo() {

        try {

            type = bo.loadAllType();
            ArrayList<String> list= new ArrayList<>();
            for (BookDTO b : type) {
                String s = b.getTypeName();
                list.add(s);
            }

            cmbType.setItems(FXCollections.observableArrayList(list));
            cmbType.getSelectionModel().selectFirst();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void loadSectionCombo() {

        try {
            ArrayList<BookDTO> section = bo.loadAllSection();
            ArrayList<String> list = new ArrayList<>();
            for (BookDTO b : section) {
                String s = b.getSectionName();
                list.add(s);
            }

            cmbSection.setItems(FXCollections.observableArrayList(list));
            cmbSection.getSelectionModel().selectFirst();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    void loadBookTbl(){
        try {
            ArrayList<BookDTO> dto = bo.load();
            ArrayList<BookTM> tm= new ArrayList<>();
            for(BookDTO d:dto){
                BookTM bookTM= new BookTM(d.getBookId(),d.getTitle(),d.getTypeName(),d.getAuthorName(),d.getPublisherName());
                tm.add(bookTM);
            }
            tblBook.setItems(FXCollections.observableArrayList(tm));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
