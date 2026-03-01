import modelos.Dinero;
import modelos.DineroAPI;

public class ConvertorDinero {

    public Dinero convertirDivisa(Dinero dinero, String nuevaDivisa) {

        ConsultaCambioDivisa consultar = new ConsultaCambioDivisa();

        DineroAPI respuestaApi = consultar.buscaCambio(dinero.getDivisa());

        Double tasa = respuestaApi.conversion_rates().get(nuevaDivisa);

        if (tasa == null) {
            throw new IllegalArgumentException("Divisa no encontrada en la API");
        }

        double nuevaCantidad = dinero.getCantidad() * tasa;

        return new Dinero(nuevaCantidad, nuevaDivisa);
    }
}
