import com.google.gson.Gson;
import modelos.Dinero;
import modelos.DineroAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambioDivisa {

    public DineroAPI buscaCambio(String divisa){
        URI direccion = URI.create
                ("https://v6.exchangerate-api.com/v6/5a8c3489b6c1df9473d1af5c/latest/" + divisa);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DineroAPI.class);
        } catch (Exception e) {
            throw new RuntimeException("Divisa no encontrada");
        }

    }

}
