import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import ClientAPI.Api;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://linguagens-imersao-api.herokuapp.com/linguagens"; // PEGA A URL DA API

        var Api = new Api(url);
        var movieList = Api.get();

        for (Map<String, String> filme : movieList) {
            InputStream inputImg = 
                    new URL(filme.get("image"))
                    .openStream();

            var generator = new StickerGenerator();

            generator.create(inputImg, filme.get("title"));
            System.out.println(filme.get("title"));
            System.out.println("\n");
        }

    }
}
