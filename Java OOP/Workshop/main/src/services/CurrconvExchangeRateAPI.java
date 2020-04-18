package services;

import http.HttpResponseParser;

import java.math.BigDecimal;

public class CurrconvExchangeRateAPI {
    private HttpResponseParser httpResponseParser;

    public CurrconvExchangeRateAPI() {
        this.httpResponseParser = new HttpResponseParser();
    }

    public BigDecimal exchange(String currencyFrom, String currencyTo) {
        return httpResponseParser.extractExchangeRate(currencyFrom, currencyTo);
    }
}
