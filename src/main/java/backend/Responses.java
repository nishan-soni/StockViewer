package backend;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
public class Responses {

    public static JsonObject quoteResponse(String symbol) {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://yahoo-finance-low-latency.p.rapidapi.com/v6/finance/quote?symbols="+symbol)
                    .header("x-rapidapi-key", "2245c082b0msha8d407c6231cab9p1fb8d2jsnb195595cb891")
                    .header("x-rapidapi-host", "yahoo-finance-low-latency.p.rapidapi.com")
                    .asJson();

            /*Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(response.getBody().toString());
            String prettyJsonString = gson.toJson(je);
            System.out.println(prettyJsonString); */

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        assert response != null;
        return CreateJsonObject.create(response);
    }

    public static JsonObject chartResponse(String symbol) {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://yahoo-finance-low-latency.p.rapidapi.com/v8/finance/chart/AAPL?interval=1wk&range=6mo&region=US&lang=en")
                    .header("x-rapidapi-key", "2245c082b0msha8d407c6231cab9p1fb8d2jsnb195595cb891")
                    .header("x-rapidapi-host", "yahoo-finance-low-latency.p.rapidapi.com")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        assert response != null;
        return CreateJsonObject.create(response);
    }
}
