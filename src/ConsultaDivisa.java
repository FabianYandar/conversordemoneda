import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaDivisa {
    public Map<String, Double> buscaConversionRates() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e328108004da40628221c661/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ApiResponse apiResponse = new Gson().fromJson(response.body(), ApiResponse.class);
            return apiResponse.getConversionRates();
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa opcion.");
        }
    }
}

