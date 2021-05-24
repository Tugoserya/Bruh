package sample.connection_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DayabaswHendel extends Config {
    Connection dbConnection;

    /**
     * Подключение к БД
     */
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + " " + dbName + "?serverTimezone=UTC" + "&characterEncoding=UTF8";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    /**
     * Авторизация инспектора
     */
    public ResultSet getUser(String login_text, String password_text) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.INSPECTOR_TABLE + " WHERE " + Const.INSPECTOR_LOGIN + "=? AND " + Const.INSPECTOR_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, login_text);
            prSt.setString(2, password_text);
            resultSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    /**
     * Авторизация наблюдателя
     */
    public ResultSet getViewer(String login_text, String password_text) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.VIEWER_TABLE + " WHERE " + Const.VIEWER_LOGIN + "=? AND " + Const.VIEWER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, login_text);
            prSt.setString(2, password_text);
            resultSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet DTP_ALL() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.DTP_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }


    public void addDtp(String class_dtp, String GPS, String kol_avto, String radius, String data, String sost) {

        String insert_add_tested = "INSERT INTO " + Const.DTP_TABLE + "(class_dtp, kol_avto, data, GPS, radius, sost, Inspector_id)" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert_add_tested);
            prSt.setString(1, class_dtp);
            prSt.setString(2, kol_avto);
            prSt.setString(3, data);
            prSt.setString(4, GPS);
            prSt.setString(5, radius);
            prSt.setString(6, sost);
            prSt.setString(7, String.valueOf(Const.id_user));
            prSt.executeUpdate();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet id_dtp() {
        ResultSet resultSet = null;
        String select = "SELECT id_dtp FROM " + Const.DTP_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet id_viewer() {
        ResultSet resultSet = null;
        String select = "SELECT id_view FROM " + Const.VIEWER_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public void addDopCar(String gosNomer, String vin, String marca) {
        String insert_add_tested = "INSERT INTO " + Const.CAR_DTP_TABLE + "(gos_nomer,vin,marca, dtp_id)" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert_add_tested);
            prSt.setString(1, gosNomer);
            prSt.setString(2, vin);
            prSt.setString(3, marca);
            prSt.setInt(4, Const.dtp);

            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addAcc(String login, String pass, String name, String last_name, String patronymic, String passport) {
        String insert_add_tested = "INSERT INTO " + Const.VIEWER_TABLE + "(login, pass, name, last_name, patronymic, passport)" + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert_add_tested);
            prSt.setString(1, login);
            prSt.setString(2, pass);
            prSt.setString(3, name);
            prSt.setString(4, last_name);
            prSt.setString(5, patronymic);
            prSt.setString(6, passport);

            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public ResultSet CheckUpdatetp() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.DTP_TABLE + " WHERE " + Const.CAR_DTP_ID + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, String.valueOf(Const.car_dtp_id));
            resultSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public void update(String class_dtpText, String kolo_dtp, String radius, String specsl, String opas, String sosto) {
        String Update = "update dtp set class_dtp=?, kolo_awto=?, radius=?, spec_sl=?,opasn_grus=?, sosoyaniye=? where " + Const.DTP_ID + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(Update);
            prSt.setString(1, class_dtpText);
            prSt.setString(2, kolo_dtp);
            prSt.setString(3, radius);
            prSt.setString(4, specsl);
            prSt.setString(5, opas);
            prSt.setString(6, sosto);
            prSt.setString(7, String.valueOf(Const.car_dtp_id));
            prSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet Car_dtp() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.CAR_DTP_TABLE + " WHERE " + Const.CAR_DTP_CAR_ID + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, String.valueOf(Const.car_dtp_id));
            resultSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getData() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.INSPECTOR_TABLE + " WHERE " + Const.INSPECTOR_ID + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, String.valueOf(Const.id_user));
            resultSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}

