package sample.Controlers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.connection_sql.DayabaswHendel;

public class awtoDTP {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Car> table;

    @FXML
    private TableColumn<Car, String> gos;

    @FXML
    private TableColumn<Car, String> VIN;

    @FXML
    private TableColumn<Car, String> marca;

    @FXML
    private TableColumn<Car, String> opas;

    @FXML
    private TableColumn<Car, String> pricep;

    @FXML
    private Button glav;

    @FXML
    private Button vihod;

    ObservableList<Car> observableArray = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        vihod.setOnAction(event -> {
            vihod.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/auth_sample.fxml"));
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
        glav.setOnAction(event -> {
            glav.getScene().getWindow().hide();
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
        DayabaswHendel dayabaswHendel = new DayabaswHendel();
        ResultSet resultCheck = dayabaswHendel.Car_dtp();
        try {
            while (resultCheck.next()) {

                observableArray.add(new Car(resultCheck.getString("gos_nomer"), resultCheck.getString("vin"),
                        resultCheck.getString("marca"), resultCheck.getString("opasn_grus"),
                        resultCheck.getString("pricep")));

            }
            gos.setCellValueFactory(new PropertyValueFactory<>("gos"));
            VIN.setCellValueFactory(new PropertyValueFactory<>("VIN"));
            marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            opas.setCellValueFactory(new PropertyValueFactory<>("opas"));
            pricep.setCellValueFactory(new PropertyValueFactory<>("pricep"));


            table.setItems(observableArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

