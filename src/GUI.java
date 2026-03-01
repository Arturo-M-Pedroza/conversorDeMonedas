import modelos.Dinero;

import java.util.Scanner;

public class GUI {
    public void run() {

        Scanner lectura = new Scanner(System.in);

        String obtenerCantidadString =
                "Sea bienvenido/a al Conversor de Moneda\n" +
                        "Dame la cantidad de dinero a convertir:";

        String obtenerDivisaString =
                "Dame la divisa:";

        String obtenerCambioDivisa = "Dame la divisa a convertir: ";

        String opciones =
                "****************************************\n" +
                        "1) Dolar\n" + "2) Peso mexicano\n" + "3) Real brasileño\n" +
                "****************************************\n";

        String mensajeSalida = "Escribe '1' para convertir otra cantidad...";

        while (true) {
            System.out.println(obtenerCantidadString);
            var cantidadDinero = Double.valueOf(lectura.nextLine());
            System.out.println(obtenerDivisaString);
            System.out.println(opciones);
            var divisaDinero = Integer.valueOf(lectura.nextLine());
            System.out.println(obtenerCambioDivisa);
            System.out.println(opciones);
            var divisaCambioDinero = Integer.valueOf(lectura.nextLine());

            Dinero dinero;

            switch (divisaDinero) {
                case 1 -> dinero = new Dinero(cantidadDinero, "USD");
                case 2 -> dinero = new Dinero(cantidadDinero, "MXN");
                case 3 -> dinero = new Dinero(cantidadDinero, "BRL");
                default -> throw new IllegalArgumentException("Divisa no válida");
            }

            String divisaCambioString;

            switch (divisaCambioDinero) {
                case 1 -> divisaCambioString = "USD";
                case 2 -> divisaCambioString = "MXN";
                case 3 -> divisaCambioString = "BRL";
                default -> throw new IllegalArgumentException("Divisa no válida");
            };

            ConvertorDinero conversor = new ConvertorDinero();
            Dinero dineroConvertido = conversor.convertirDivisa(dinero, divisaCambioString);

            System.out.println(dinero + " en " + dineroConvertido.getDivisa() + "es: " + dineroConvertido.getCantidad());

            System.out.println(mensajeSalida);
            var salir = Integer.valueOf(lectura.nextLine());

            if (salir != 1) {
                System.out.println("Gracias por usar el conversor, saliendo...");
                break;
            }
        }
    }
}
