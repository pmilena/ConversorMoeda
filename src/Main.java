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
            3- Dólar =>> Real Brasileiro
            4- Real Brasileiro =>> Dólar
            5- Dólar =>> Peso Colombiano
            6- Peso Colombiano =>> Dólar
            7- sair
            """);

    while(choose<=0 || choose>7){
        System.out.println("Escolha uma opção válida: ");
        System.out.println("***************************************");
        choose= leitor.nextInt();
        if (choose>=1 & choose<7) {
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
                conversor.Converter("USD", "BRL", leitor.nextDouble());
                break;
            case 4:
                conversor.Converter("BRL", "USD", leitor.nextDouble());
                break;
            case 5:
                conversor.Converter("USD", "COL", leitor.nextDouble());
                break;
            case 6:
                conversor.Converter("COL", "USD", leitor.nextDouble());
                break;
            case 7:
                System.out.println("A aplicação foi finalizada");
                break;

            default:
                System.out.println("O número digitado não é válido. Tente novamente.");
        }
    }
}}
 