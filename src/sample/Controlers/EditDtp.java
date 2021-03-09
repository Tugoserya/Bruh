package sample.Controlers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.connection_sql.DayabaswHendel;

public class EditDtp {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button update;
    @FXML
    private Button awtoDtp;

    @FXML
    private TextField class_dtp;

    @FXML
    private TextField kolo_dtp;

    @FXML
    private TextField radius;

    @FXML
    private TextField specsl;

    @FXML
    private TextField opas;

    @FXML
    private TextField sosto;

    @FXML
    void initialize() {
        try {

            awtoDtp.setOnAction(event -> {
                awtoDtp.getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/FXML/awtoDTP.fxml"));
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

            DayabaswHendel dayabaswHendel = new DayabaswHendel();
            ResultSet resultSet = dayabaswHendel.CheckUpdatetp();
            while (resultSet.next()) {
                class_dtp.setText(resultSet.getString("class_dtp"));
                kolo_dtp.setText(resultSet.getString("kolo_awto"));
                radius.setText(resultSet.getString("radius"));
                specsl.setText(resultSet.getString("spec_sl"));
                opas.setText(resultSet.getString("opasn_grus"));
                sosto.setText(resultSet.getString("sosoyaniye"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update.setOnAction(event -> {
            DayabaswHendel dayabaswHendel = new DayabaswHendel();
            dayabaswHendel.update(class_dtp.getText(),kolo_dtp.getText(),radius.getText(),specsl.getText(),opas.getText(),sosto.getText());
            update.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/cheac.fxml"));
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


}
