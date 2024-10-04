import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requests {

    public HttpResponse Request(String base_code, String target_code) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/90dac989c38a31c5dcd4d347/pair/" + base_code +"/"+target_code))
                .build();
        return client
                .send(request, HttpResponse.BodyHandlers.ofString());
    }
}
