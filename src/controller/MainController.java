package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private BorderPane pneMain;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadDateAndTime();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/MakeLend.fxml"));
            pneMain.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void actionBtn(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../view/MakeLend.fxml"));
        pneMain.setCenter(root);



    }
    @FXML
    void actionManageMembers(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../view/ManageMember.fxml"));
        pneMain.setCenter(root);

    }
    @FXML
    void actionManageBooks(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../view/ManageBook.fxml"));
        pneMain.setCenter(root);
    }

    @FXML
    void actionManageReceptionist(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../view/ManageReceptionists.fxml"));
        pneMain.setCenter(root);

    }

    @FXML
    void actionManagePolicies(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("../view/ManagePolicie.fxml"));
        pneMain.setCenter(root);

    }

    public BorderPane getPneMain() {
        return pneMain;
    }

    private void loadDateAndTime(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/YYYY");
        String datetxt=simpleDateFormat.format(date);
        lblDate.setText(datetxt);

        Timeline timeline=new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                Calendar time=Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
                                lblTime.setText(simpleDateFormat.format(time.getTime()));
                            }
                        }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void actionReport(ActionEvent actionEvent) {
    }
}