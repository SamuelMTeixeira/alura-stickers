package ClientAPI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.util.List;
import java.util.Map;

import Json.Json;

public class Api {
    Json JSON = new Json();

    HttpClient client;
    HttpRequest request;

    public Api(String url) {
        // ------------------//
        // CONEXÃO COM A API //
        // ------------------//

        client = HttpClient.newHttpClient(); // INSTANCIA A CLASSE HTTP QUE IRA FAZER A CONEXÃO COM A API
        request = HttpRequest.newBuilder(URI.create(url)).GET().build(); // FAZ O REQUEST DA URL (BUSCA NO NAVEGADOR)
    }

    public List<Map<String, String>> get() throws Exception {
        var res = client.send(request, BodyHandlers.ofString()); // ENVIA A REQUISIÇÃO PARA O NAVEGADOR E PEGA A
                                                                 // RESPOSTA
        String body = res.body();

        // CRIA UMA LISTA DO TIPO MAP (DICIONARIO)
        List<Map<String, String>> result = JSON.parse(body); // Store in var
        return result;
    }

}
