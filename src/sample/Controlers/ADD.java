package sample.Controlers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animaion.Snake;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;

public class ADD {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addCar;

    @FXML
    private Button addDotCar;

    @FXML
    private TextField class_dtp;

    @FXML
    private TextField geolocation;

    @FXML
    private TextField kolo_dtp;
    @FXML
    private TextField glav;

    @FXML
    private TextField radius;

    @FXML
    private TextField dataDtp;

    @FXML
    private TextField specsl;

    @FXML
    private TextField tip;

    @FXML
    private TextField opas;

    @FXML
    private TextField sosto;
    @FXML
    private Button glav_2;

    @FXML
    void initialize() {
        addDotCar.setOnAction(event -> {
            addDtp();
        });
        addCar.setOnAction(event -> {
            addDtpCar();
        });
        glav_2.setOnAction(event -> {
            glav_2.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/lk_sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void addDtpCar() {
        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addDtp(class_dtp.getText(), geolocation.getText(), kolo_dtp.getText(), radius.getText(),
                dataDtp.getText(), specsl.getText(), tip.getText(), opas.getText(), sosto.getText());
        ResultSet resultPr = dbHandler.id_dtp();

        try {
            while (resultPr.next()) {
                Const.dtp = Integer.parseInt(resultPr.getString("id"));
            }
            addDotCar.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/addDtpCar.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void addDtp() {
        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addDtp(class_dtp.getText(), geolocation.getText(), kolo_dtp.getText(), radius.getText(),
                dataDtp.getText(), specsl.getText(), tip.getText(), opas.getText(), sosto.getText());
        ResultSet resultPr = dbHandler.id_dtp();

        try {
            while (resultPr.next()) {
                Const.dtp = Integer.parseInt(resultPr.getString("id"));
            }
            addDotCar.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/lk_sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}