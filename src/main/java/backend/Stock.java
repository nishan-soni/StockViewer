package backend;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Stock {
    String symbol;
    HttpResponse<JsonNode> response = null;

    public Stock(String symbol) {
        this.symbol = symbol;
    }

    public String getRegularMarketPrice()  {
        JsonArray results = Responses.quoteResponse(symbol)
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketPrice").getAsString();
    }

    public String getRegularMarketHigh()  {
        JsonArray results = Responses.quoteResponse(symbol)
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketDayHigh").getAsString();
    }

    public String getMarketCap()  {
        JsonArray results = Responses.quoteResponse(symbol)
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("marketCap").getAsString();
    }

    public String getPostMarketPrice()  {
        JsonArray results = Responses.quoteResponse(symbol)
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("postMarketPrice").getAsString();
    }

    public String getRegularMarketOpen()  {
        JsonArray results = Responses.quoteResponse(symbol)
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketOpen").getAsString();
    }

    public String getRegularMarketPrevClose()  {
        JsonArray results = Responses.quoteResponse(symbol)
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketPreviousClose").getAsString();
    }

    public String getPE()  {
        JsonArray results = Responses.quoteResponse(symbol)
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("trailingPE").getAsString();
    }




}