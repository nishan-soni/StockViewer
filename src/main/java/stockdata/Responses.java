package stockdata;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Responses {
    static String key1 ="2245c082b0msha8d407c6231cab9p1fb8d2jsnb195595cb891";
    static String key2 = "dac7c7dd74mshe49901165576b0ap196957jsnc8c137fd45dc";
    public static JsonObject quoteResponse(String symbol) {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://yahoo-finance-low-latency.p.rapidapi.com/v6/finance/quote?symbols="+symbol)
                    .header("x-rapidapi-key", key1)
                    .header("x-rapidapi-host", "yahoo-finance-low-latency.p.rapidapi.com")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        assert response != null;
        return CreateJsonObject.create(response);
    }

    public static JsonObject chartResponse(String symbol) {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://yahoo-finance-low-latency.p.rapidapi.com/v8/finance/chart/"+symbol+"?interval=1d&range=1y")
                    .header("x-rapidapi-key", key1)
                    .header("x-rapidapi-host", "yahoo-finance-low-latency.p.rapidapi.com")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        assert response != null;
        return CreateJsonObject.create(response);
    }
}
