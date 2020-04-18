package http;

import services.CurrencyConverter;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpResponse;

public class HttpResponseParser {

    private String getResponse(String currencyFrom, String currencyTo) {
        HttpRequestMaker httpRequestMaker = new HttpRequestMaker();
        String responseBodyAsString = null;

        try {
            HttpResponse<String> response = httpRequestMaker.getResponseFromRequest(currencyFrom, currencyTo);
            responseBodyAsString = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.err.println("ERROR IN: " + CurrencyConverter.class.getSimpleName() + " HTTP REQUEST WAS NOT SEND PROPERLY TO EXTERNAL API!");
        }

        return responseBodyAsString;
    }

    public BigDecimal extractExchangeRate(String currencyFrom, String currencyTo) {
        String response = this.getResponse(currencyFrom, currencyTo);
        int columnIndex = response.indexOf(":");
        int closingBracketIndex = response.lastIndexOf("}");
        return new BigDecimal(response.substring(columnIndex + 1, closingBracketIndex));
    }


}
