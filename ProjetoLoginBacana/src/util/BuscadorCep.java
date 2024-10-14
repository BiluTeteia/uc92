package util;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.io.BufferedReader;

public class BuscadorCep {

    static String webService = "http://viacep.com.br/ws/";  //EndereÃ?Â§o viacep
    static String webremnant = "/json";                     //tipo de retorno
    static int codigoSucesso = 200;                         //CÃ?Â³digo Sucesso conexÃ?Â£o

    public static String encontraCep(String cep) {

        String endereco = "";
        String urlChamada = webService + cep + webremnant;
        String dados = "";
        String jsonEmString = "";

        try {

            URL url = new URL(urlChamada);

            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso) {
                throw new RuntimeException("Erro conexÃ?Â£o!" + conexao.getResponseMessage());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            while ((dados = resposta.readLine()) != null) {
                jsonEmString += dados;
            }

            JSONObject obj = new JSONObject(jsonEmString);

            String estado = obj.getString("estado");
            String cidade = obj.getString("localidade");
            String rua = obj.getString("logradouro");
            endereco += estado + ", " + cidade + ", " + rua;

        } catch (Exception e) {
        } finally {
        }

        return endereco;
    }
}
