package sample.Controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.connection_sql.DayabaswHendel;

public class AddDtpCar {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addCar;

    @FXML
    private Button addDotCar;

    @FXML
    private Button glav_1;

    @FXML
    private TextField gosNomer;

    @FXML
    private TextField vin;

    @FXML
    private TextField marca;

    @FXML
    private TextField opasn;

    @FXML
    private TextField pricep;

    @FXML
    void initialize() {
        System.out.println("bpvtybnm nen");
        addDotCar.setOnAction(event -> {
            addDontGlav();
        });
        addCar.setOnAction(event -> {
            addDopCar();
            ocist();
        });
        glav_1.setOnAction(event -> {
            glav_1.getScene().getWindow().hide();
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

    private void ocist() {
        gosNomer.clear();
        vin.clear();
        marca.clear();
        opasn.clear();
        pricep.clear();
    }

    private void addDopCar() {
        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addCarDontDtp(gosNomer.getText(), vin.getText(), marca.getText(), opasn.getText(),
                pricep.getText());
    }



    private void addDontGlav() {
        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addCarDontDtp(gosNomer.getText(), vin.getText(), marca.getText(), opasn.getText(),
                pricep.getText());
        addDotCar.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/FXML/cheac.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
