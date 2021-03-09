package sample.Controlers;

public class Table_modul {
    public int id;
    public String class_dtp;
    public String geolocation;
    public String colo_avto;
    public String radius;
    public String date;
    public String spec_sl;
    public String tip_dor;
    public String grys;
    public String sosoyaniye;

    public Table_modul(int id, String class_dtp, String geolocation, String colo_avto, String radius, String date, String spec_sl, String tip_dor, String grys, String sosoyaniye) {
        this.id = id;
        this.class_dtp = class_dtp;
        this.geolocation = geolocation;
        this.colo_avto = colo_avto;
        this.radius = radius;
        this.date = date;
        this.spec_sl = spec_sl;
        this.tip_dor = tip_dor;
        this.grys = grys;
        this.sosoyaniye = sosoyaniye;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_dtp() {
        return class_dtp;
    }

    public void setClass_dtp(String class_dtp) {
        this.class_dtp = class_dtp;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public String getColo_avto() {
        return colo_avto;
    }

    public void setColo_avto(String colo_avto) {
        this.colo_avto = colo_avto;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSpec_sl() {
        return spec_sl;
    }

    public void setSpec_sl(String spec_sl) {
        this.spec_sl = spec_sl;
    }

    public String getTip_dor() {
        return tip_dor;
    }

    public void setTip_dor(String tip_dor) {
        this.tip_dor = tip_dor;
    }

    public String getGrys() {
        return grys;
    }

    public void setGrys(String grys) {
        this.grys = grys;
    }

    public String getSosoyaniye() {
        return sosoyaniye;
    }

    public void setSosoyaniye(String sosoyaniye) {
        this.sosoyaniye = sosoyaniye;
    }
}
