package sample.Controlers;


public class Car {

    public String id_car;
    public String gos_nomer;
    public String vin;
    public String marca;
    public String dtp_id;

    public Car(String id_car, String gos_nomer, String vin, String marca, String dtp_id) {
        this.id_car = id_car;
        this.marca = marca;
        this.vin = vin;
        this.gos_nomer = gos_nomer;
        this.dtp_id = dtp_id;
    }

    public String getGos() {
        return gos_nomer;
    }

    public void setGos(String gos) {
        this.gos_nomer = gos_nomer;
    }

    public String getVIN() {
        return vin;
    }

    public void setVIN(String VIN) {
        this.vin = vin;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) { this.marca = marca; }

}
