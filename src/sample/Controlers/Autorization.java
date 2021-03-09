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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animaion.Snake;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;

public class Autorization {
    public boolean Auth = false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button auth_buttom;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password_auth;


    @FXML
    void initialize() {

/*
Проверка на пустоту введёных данных, и если данные введены переход на авторизацию
 */
        auth_buttom.setOnAction(event -> {
            String login_text = login.getText().trim();
            String password_text = password_auth.getText().trim();

            if (!login_text.equals("") && !password_text.equals("")) {
                loginUser(login_text, password_text);
            } else {
                System.out.println("Логин или пароль неверны");
                Snake snake = new Snake(login);
                Snake snake2 = new Snake(password_auth);
                snake.playAnim();
                snake2.playAnim();
            }
        });

    }

    /*
     *Авторизация пользователя с передачей ID, для проверки на инструктора
     */
    private void loginUser(String login_text, String password_text) {
        DayabaswHendel dbHandler = new DayabaswHendel();
        ResultSet resultSet = dbHandler.getUser(login.getText(), password_auth.getText());

        try {
            String pas = null;
            String log = null;
            while (resultSet.next()) {
                // Получаем id пользователей
                Const.id_user = Integer.parseInt(resultSet.getString("id"));
                pas=resultSet.getString("password");
                log=resultSet.getString("login");

            }
            if(login_text.equals(log) && pas.equals(password_text)){

               System.out.println("User id - " + Const.id_user);
                auth_buttom.getScene().getWindow().hide();
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
            }else {
                Snake snake = new Snake(login);
                Snake snake2 = new Snake(password_auth);
                snake.playAnim();
                snake2.playAnim();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

