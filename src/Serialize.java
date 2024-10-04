import com.google.gson.Gson;
import java.util.Scanner;

public class Serialize {
    public void SerializeGson(Object resposta){
        Gson gson = new Gson();
        MoedaConvertidaJson novaMoeda = gson.fromJson((String) resposta, MoedaConvertidaJson.class);
        MoedaConvertida moedaConvertida = new MoedaConvertida(novaMoeda);
        System.out.println("Qual valor deseja converter?");
        Scanner leitor = new Scanner(System.in);
        var valorConvertido=moedaConvertida.converterMoeda(leitor.nextDouble());
        System.out.printf("""
                Valor: %.2f
                %n""", valorConvertido);
    }
}
