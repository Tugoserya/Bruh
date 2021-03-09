package sample.connection_sql;

import javafx.collections.ObservableList;

public class Const {
/**
*Таблица CAR
*/
    public static final String CAR_TABLE="CAR";
    public static final String CAR_ID="id";
    public static final String CAR_VIN="vin";
    public static final String CAR_GOS_NOMER="gos_nomer";
    public static final String CAR_DTP_DO="dtp_do";
    public static final String CAR_LOGIN="login";
    public static final String CAR_PASSWORD="password";
    public static final String CAR_MARCA="marca";
/**
*Таблица car_dtp
 */
    public static final String CAR_DTP_TABLE="car_dtp";
    public static final String CAR_DTP_ID="id";
    public static final String CAR_DTP_GOS="gos_nomer";
    public static final String CAR_DTP_VIN="vin";
    public static final String CAR_DTP_MARCA="marca";
    public static final String CAR_DTP_CAR_ID="car_id";
    public static final String CAR_DTP_OPASN_GRUS="opasn_grus";
    public static final String CAR_DTP_PRICEP="pricep";
    public static final String CAR_DTP_DTP_ID="dtp_id";

/**
*Таблица dtp
 */
   public static final String DTP_TABLE="dtp";
   public static final String DTP_ID="id";
   public static final String DTP_CLASS_DTP="class_dtp";
   public static final String DTP_KOLO="kolo_awto";
   public static final String DTP_DATA="data";
   public static final String DTP_MESTO="mestopolosgenie";
   public static final String DTP_RADIUS="radius";
   public static final String DTP_SOSTOYANIYE="sosoyaniye";
    public static final boolean AUTH = false;
    public static final boolean INST = false;

    public static int id_user;

    public static int dtp=0;
    public static int car_dtp_id=0;
}
