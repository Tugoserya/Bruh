package sample.Controlers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.animaion.Snake;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;

public class AddDtpCar {

    @FXML
    private Button addCar;

    @FXML
    private Button addDotCar;

    @FXML
    private Button glav;

    @FXML
    private TextField gosNomer;

    @FXML
    private TextField vin;

    @FXML
    private TextField marca;

    @FXML
    private ImageView prog_image;


    @FXML
    void initialize() {
        Image image = new Image("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png");
        prog_image.setImage(image);
        addCar.setOnAction(event -> {
            String gosNomer_text = gosNomer.getText().trim();
            String vin_text = vin.getText().trim();
            String marca_text = marca.getText().trim();

            if (!gosNomer_text.equals("")){
                if (!vin_text.equals("")){
                    if (!marca_text.equals("")){
                        addDopCar(gosNomer_text, vin_text, marca_text);
                    }else {
                        Snake snake6 = new Snake(marca);
                        snake6.playAnim();}
                }else {
                    Snake snake8 = new Snake(vin);
                    snake8.playAnim();}
            }else {
                Snake snake7 = new Snake(gosNomer);
                snake7.playAnim();}

            ocist();
        });
        glav.setOnAction(event -> {
            glav.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/lk_sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Система контроля дорожной обстановки");
            stage.getIcons().add(new Image(("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png")));
            stage.setMaxHeight(540);
            stage.setMaxWidth(800);
            stage.setMinHeight(540);
            stage.setMinWidth(800);
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void addDopCar(String gosNomer_text, String vin_text, String marca_text) {
        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addDopCar(
                gosNomer.getText(),
                vin.getText(),
                marca.getText());

        ResultSet resultSet = dbHandler.Car_dtp();
        try {
            while (resultSet.next()) {
                Const.id_user = Integer.parseInt(resultSet.getString("id_car"));
            }
            addCar.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/addDtpCar.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Система контроля дорожной обстановки");
            stage.getIcons().add(new Image(("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png")));
            stage.setMaxHeight(540);
            stage.setMaxWidth(800);
            stage.setMinHeight(540);
            stage.setMinWidth(800);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void ocist() {
        gosNomer.clear();
        vin.clear();
        marca.clear();
    }
}

