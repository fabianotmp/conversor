package conversor.api;

import com.google.gson.Gson;
import conversor.model.Moeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TaxaDeCambioApi {
    private  String key = "3319bf4831b03e9e00c4232c";
    private  HttpClient client = HttpClient.newHttpClient();
    private  Gson gson = new Gson();

    public Moeda pegarTaxaDeCambio(String dupla) {
        URI endpoint = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/"+dupla);
        HttpRequest request = HttpRequest.newBuilder().uri(endpoint).build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String body = response.body();
                return gson.fromJson(body, Moeda.class);

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
