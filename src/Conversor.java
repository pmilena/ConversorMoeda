import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class Conversor {

    public void Converter(String base_code, String target_code, double valorAConverter) throws IOException, InterruptedException {
        Requests request = new Requests();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(request.Request(base_code));
        JsonObject jsonobj = root.getAsJsonObject();

        JsonObject req_rate = jsonobj.get("conversion_rates").getAsJsonObject();
        var valorConvertido = req_rate.get(target_code).getAsDouble()*valorAConverter;
        System.out.printf("""
                Valor de %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]
                %n""", valorAConverter, base_code, valorConvertido,target_code);
    }
}
