import java.io.IOException;
import java.util.Scanner;

public class Main {    public static void main(String[] args) throws IOException, InterruptedException {

    Conversor conversor = new Conversor();
    var choose = 0;

    Scanner leitor = new Scanner(System.in);

    System.out.println(""" 
            ***************************************  
            Seja bem vindo ao Conversor de Moeda =]
                         
            1- Dólar =>> Peso Argentino
            2- Peso Argentino =>> Dólar
            3- Dólar =>> Peso Boliviano
            4- Peso Boliviano =>> Dólar
            5- Dólar =>> Real Brasileiro
            6- Real Brasileiro =>> Dólar
            7- Dólar =>> Peso Chileno
            8- Peso Chileno =>> Dólar
            9- Dólar =>> Peso Colombiano
            10- Peso Colombiano =>> Dólar
            11- Sair
            """);

    while(choose<=0 || choose>11){
        System.out.println("Escolha uma opção válida: ");
        System.out.println("***************************************");
        choose= leitor.nextInt();
        if (choose>=1 & choose<11) {
            System.out.println("Digite o valor que deseja converter: ");
        }
        switch (choose) {
            case 1:
                conversor.Converter("USD", "ARS", leitor.nextDouble());
                break;
            case 2:
                conversor.Converter("ARS", "USD", leitor.nextDouble());
                break;
            case 3:
                conversor.Converter("USD", "BOB", leitor.nextDouble());
                break;
            case 4:
                conversor.Converter("BOB", "USD", leitor.nextDouble());
                break;
            case 5:
                conversor.Converter("USD", "BRL", leitor.nextDouble());
                break;
            case 6:
                conversor.Converter("BRL", "USD", leitor.nextDouble());
                break;
            case 7:
                conversor.Converter("USD", "CLP", leitor.nextDouble());
                break;
            case 8:
                conversor.Converter("CLP", "USD", leitor.nextDouble());
                break;
            case 9:
                conversor.Converter("USD", "COP", leitor.nextDouble());
                break;
            case 10:
                conversor.Converter("COP", "USD", leitor.nextDouble());
                break;
            case 11:
                System.out.println("A aplicação foi finalizada");
                break;

            default:
                System.out.println("O número digitado não é válido. Tente novamente.");
        }
    }
}}
 