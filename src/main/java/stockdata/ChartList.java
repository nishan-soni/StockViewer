package stockdata;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChartList {
    private final JsonArray date;
    private final JsonArray adjclose;


    public ChartList(String symbol) {
        JsonObject chartResponse = Responses.chartResponse(symbol);

        this.date = chartResponse
                .getAsJsonObject("chart")
                .getAsJsonArray("result")
                .get(0).getAsJsonObject().getAsJsonArray("timestamp");

        for(int i = 0; i <date.size(); i++) {
            int temp = date.get(i).getAsInt();
            String converted = new SimpleDateFormat("yyyy-MM-dd").format(new Date((long)temp*1000));
            date.set(i, new JsonParser().parse(converted));
        }

        this.adjclose = chartResponse
                .getAsJsonObject("chart")
                .getAsJsonArray("result")
                .get(0).getAsJsonObject().getAsJsonObject("indicators")
                .getAsJsonArray("adjclose")
                .get(0).getAsJsonObject().getAsJsonArray("adjclose");
    }

    public JsonArray getDate() {
        return date;
    }

    public JsonArray getAdjclose() {
        return adjclose;
    }



}
