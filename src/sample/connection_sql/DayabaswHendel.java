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
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" +" "+ dbName + "?serverTimezone=UTC" + "&characterEncoding=UTF8";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    /**
     * Авторизация пользователя
     */
    public ResultSet getUser(String login_text, String password_text) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.CAR_TABLE + " WHERE " + Const.CAR_LOGIN + "=? AND " + Const.CAR_PASSWORD + "=?";
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



    public void addDtp(String class_dtp, String geolocation, String kolo_dtp, String radius, String dataDtp, String specsl, String tip, String opas, String sosto) {

        String insert_add_tested = "INSERT INTO " + Const.DTP_TABLE + "(class_dtp,mestopolosgenie,kolo_awto,radius,date_dtp,spec_sl,tip_dor,opasn_grus,sosoyaniye)" + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert_add_tested);
            prSt.setString(1, class_dtp);
            prSt.setString(2, geolocation);
            prSt.setString(3, kolo_dtp);
            prSt.setString(4, radius);
            prSt.setString(5, dataDtp);
            prSt.setString(6, specsl);
            prSt.setString(7, tip);
            prSt.setString(8, opas);
            prSt.setString(9, sosto);
             prSt.executeUpdate();



        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
        public ResultSet id_dtp() {
        ResultSet resultSet = null;
        String select = "SELECT id FROM " + Const.DTP_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public void addCarDontDtp(String gosNomer, String vin, String marca, String opasn, String pricep) {
        String insert_add_tested = "INSERT INTO " + Const.CAR_DTP_TABLE + "(gos_nomer,vin,marca,opasn_grus,pricep,dtp_id)" + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert_add_tested);
            prSt.setString(1, gosNomer);
            prSt.setString(2, vin);
            prSt.setString(3, marca);
            prSt.setString(4, opasn);
            prSt.setString(5, pricep);
            prSt.setInt(6, Const.dtp);

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

    public void update(String class_dtpText, String kolo_dtp, String radius, String specsl,String opas, String sosto) {
        String Update = "update dtp set class_dtp=?, kolo_awto=?, radius=?, spec_sl=?,opasn_grus=?, sosoyaniye=? where "+ Const.DTP_ID + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(Update);
            prSt.setString(1,class_dtpText);
            prSt.setString(2,kolo_dtp);
            prSt.setString(3,radius);
            prSt.setString(4,specsl);
            prSt.setString(5,opas);
            prSt.setString(6,sosto);
            prSt.setString(7, String.valueOf(Const.car_dtp_id));
            prSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet Car_dtp() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.CAR_DTP_TABLE + " WHERE " + Const.CAR_DTP_DTP_ID + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, String.valueOf(Const.car_dtp_id));
            resultSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
