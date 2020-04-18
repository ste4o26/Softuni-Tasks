package http;

import services.CurrencyConverter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestMaker {
    private static final String API_KEY = "34ba7ddaad327d2af129";

    public HttpResponse<String> getResponseFromRequest(String currencyFrom, String currencyTo) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(buildRequestUri(currencyFrom, currencyTo))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private URI buildRequestUri(String currencyFrom, String currencyTo) {
        try {
            return new URI("https://free.currconv.com/api/v7/convert?q=" + currencyFrom + "_" + currencyTo + "&compact=ultra&apiKey=" + API_KEY);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.err.println("ERROR IN: " + CurrencyConverter.class.getSimpleName() + ": URI WAS NOT PARSED PROPERLY!");
        }

        return null;
    }
}
