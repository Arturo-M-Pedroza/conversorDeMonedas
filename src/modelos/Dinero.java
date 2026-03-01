package modelos;

public class Dinero {
    private double cantidad;
    private String divisa;

    public Dinero(double cantidad, String divisa) {
        this.cantidad = cantidad;
        this.divisa = divisa;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getDivisa() {
        return divisa;
    }

    @Override
    public String toString() {
        return "La cantidad: " + this.getCantidad() + " " + this.getDivisa();
    }
}
