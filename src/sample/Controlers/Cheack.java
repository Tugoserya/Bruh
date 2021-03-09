package sample.Controlers;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.cj.xdevapi.Table;
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
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;

public class Cheack {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Table_modul> table;

    @FXML
    private TableColumn<Table_modul, String> id_dtp;

    @FXML
    private TableColumn<Table_modul, String> clas;

    @FXML
    private TableColumn<Table_modul, String> geo;

    @FXML
    private TableColumn<Table_modul, String> colo;

    @FXML
    private TableColumn<Table_modul, String> radius;

    @FXML
    private TableColumn<Table_modul, String> dat;

    @FXML
    private TableColumn<Table_modul, String> slu;

    @FXML
    private TableColumn<Table_modul, String> tip;
    @FXML
    private TableColumn<Table_modul, String> grys;
    @FXML
    private TableColumn<Table_modul, String> sosto;

    @FXML
    private Button id;

    @FXML
    private Button vash;

    @FXML
    private Button powres;

    @FXML
    private Button glav;

    @FXML
    private Button vihod;

    ObservableList<Table_modul> observableArray = FXCollections.observableArrayList();

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
        ResultSet resultCheck = dayabaswHendel.DTP_ALL();
        try {
            while (resultCheck.next()) {

                observableArray.add(new Table_modul(resultCheck.getInt("id"), resultCheck.getString("class_dtp"),
                        resultCheck.getString("mestopolosgenie"), resultCheck.getString("kolo_awto"), resultCheck.getString("radius"),
                        resultCheck.getString("date_dtp"), resultCheck.getString("spec_sl"),
                        resultCheck.getString("tip_dor"), resultCheck.getString("opasn_grus"), resultCheck.getString("sosoyaniye")));

            }
            id_dtp.setCellValueFactory(new PropertyValueFactory<>("id"));
            clas.setCellValueFactory(new PropertyValueFactory<>("class_dtp"));
            geo.setCellValueFactory(new PropertyValueFactory<>("geolocation"));
            colo.setCellValueFactory(new PropertyValueFactory<>("colo_avto"));
            radius.setCellValueFactory(new PropertyValueFactory<>("radius"));
            dat.setCellValueFactory(new PropertyValueFactory<>("date"));
            slu.setCellValueFactory(new PropertyValueFactory<>("spec_sl"));
            tip.setCellValueFactory(new PropertyValueFactory<>("tip_dor"));
            grys.setCellValueFactory(new PropertyValueFactory<>("grys"));
            sosto.setCellValueFactory(new PropertyValueFactory<>("sosoyaniye"));

            table.setItems(observableArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clicked(javafx.scene.input.MouseEvent event) {
        if (event.getClickCount() == 2) {
            table.getScene().getWindow().hide();
            Table_modul table_modul = table.getSelectionModel().getSelectedItem();
            Const.car_dtp_id=table_modul.id;
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/EditDTP.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }
    }
}

