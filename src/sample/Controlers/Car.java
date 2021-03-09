package sample.Controlers;


public class Car {

    public String gos;
    public String VIN;
    public String marca;
    public String opas;
    public String pricep;

    public Car(String gos, String VIN, String marca, String opas, String pricep) {
        this.gos = gos;
        this.VIN = VIN;
        this.marca = marca;
        this.opas = opas;
        this.pricep = pricep;
    }

    public String getGos() {
        return gos;
    }

    public void setGos(String gos) {
        this.gos = gos;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOpas() {
        return opas;
    }

    public void setOpas(String opas) {
        this.opas = opas;
    }

    public String getPricep() {
        return pricep;
    }

    public void setPricep(String pricep) {
        this.pricep = pricep;
    }
}
