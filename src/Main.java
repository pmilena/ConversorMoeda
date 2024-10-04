import java.io.IOException;
import java.util.Scanner;

public class Main {    public static void main(String[] args) throws IOException, InterruptedException {
    Scanner leitor = new Scanner(System.in);
    Requests request = new Requests();
    Serialize serialize = new Serialize();

    Object resposta;
    var choose = 0;

    System.out.println("""                
            1- Dólar ==> Peso Argentino
            2- Peso Argentino ==> Dólar
            3- Dólar ==> Real Brasileiro
            4- Real Brasileiro ==> Dólar
            5- Dólar ==> Peso Colombiano
            6- Peso Colombiano ==> Dólar
            7- sair
            """);

    while(choose<=0 || choose>7){
        System.out.println("Escolha uma opção válida: ");
        choose = leitor.nextInt();

        switch (choose) {
            case 1:
               resposta = request.Request("USD", "ARS").body();
               serialize.SerializeGson(resposta);
                break;
            case 2:
                resposta = request.Request("ARS", "USD").body();
                serialize.SerializeGson(resposta);
                break;
            case 3:
                resposta = request.Request("USD", "BRL").body();
                serialize.SerializeGson(resposta);
                break;
            case 4:
                resposta = request.Request("BRL", "USD").body();
                serialize.SerializeGson(resposta);
                break;
            case 5:
                resposta = request.Request("USD", "COP").body();
                serialize.SerializeGson(resposta);
                break;
            case 6:
                resposta = request.Request("COP", "USD").body();
                serialize.SerializeGson(resposta);
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
 