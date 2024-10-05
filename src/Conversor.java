import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public void Converter(String base_code, String target_code, double valorAConverter) throws IOException, InterruptedException {
        String url_str = "https://v6.exchangerate-api.com/v6/90dac989c38a31c5dcd4d347/latest/" + base_code;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(response.body());
        JsonObject jsonobj = root.getAsJsonObject();

        JsonObject req_rate = jsonobj.get("conversion_rates").getAsJsonObject();
        var valorConvertido = req_rate.get(target_code).getAsDouble()*valorAConverter;
        System.out.printf("""
                Valor de %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]
                %n""", valorAConverter, base_code, valorConvertido,target_code);

    }
}
