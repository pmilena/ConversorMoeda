import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {    public static void main(String[] args) throws IOException, InterruptedException {
    Scanner leitor = new Scanner(System.in);

    var base_code="";
    var target_code="";
    var choose = 0;

    System.out.println("""                
            1- Real ==> Dólar                
            2- Dólar ==> Real                
            3- Real ==> Euro                
            4- Euro ==> Real                
            5- Real ==> Peso Argentino                
            6- Peso Argentino ==> Real                
            7- sair                
            """);

    while(choose<=0 || choose>7){
        System.out.println("Escolha uma opção válida: ");
        choose = leitor.nextInt();

        switch (choose) {
            case 1:
                base_code="BRL";
                target_code="USD";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://v6.exchangerate-api.com/v6/90dac989c38a31c5dcd4d347/pair/" + base_code +"/"+target_code))
                        .build();
                HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());//transformar a requisição em método

                var resposta=response.body();

                Gson gson = new Gson();
                MoedaConvertidaJson novaMoeda = gson.fromJson(resposta, MoedaConvertidaJson.class);
                MoedaConvertida moedaConvertida = new MoedaConvertida(novaMoeda);
                System.out.println("Qual valor deseja converter?");
                var valorConvertido=moedaConvertida.converterMoeda(leitor.nextDouble());
                System.out.println("""
                        Valor em REAL: %.2f 
                        """.formatted(valorConvertido));
                break;
            case 2:
                System.out.println("Dolar/Real");
                break;
            case 3:
                System.out.println("Real/Euro");
                break;
            case 4:
                System.out.println("Euro/Real");
                break;
            case 5:
                System.out.println("Real/Peso");
                break;
            case 6:
                System.out.println("Peso/Real");
                break;
            case 7:
                System.out.println("SAIU");
                break;
            default:
                System.out.println("O número digitado não é válido. Tente novamente.");
        }
    }
}
}
 