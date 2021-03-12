package stockdata;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChartList {
    private final JsonArray date;
    private final JsonArray open;
    private final JsonArray high;
    private final JsonArray low;
    private final JsonArray close;
    private final JsonArray volume;
    private final JsonArray adjclose;


    public ChartList(String symbol) {
        JsonArray quote = Responses.chartResponse(symbol)
                .getAsJsonObject("chart")
                .getAsJsonArray("result")
                .get(0).getAsJsonObject().getAsJsonObject("indicators")
                .getAsJsonArray("quote");

        this.date = Responses.chartResponse(symbol)
                .getAsJsonObject("chart")
                .getAsJsonArray("result")
                .get(0).getAsJsonObject().getAsJsonArray("timestamp");

        for(int i = 0; i <date.size(); i++) {
            int temp = date.get(i).getAsInt();
            String converted = new SimpleDateFormat("yyyy-MM-dd").format(new Date((long)temp*1000));
            date.set(i, new JsonParser().parse(converted));
        }

        this.open = quote.get(0).getAsJsonObject().getAsJsonArray("open");
        this.high = quote.get(0).getAsJsonObject().getAsJsonArray("high");
        this.low = quote.get(0).getAsJsonObject().getAsJsonArray("low");
        this.close = quote.get(0).getAsJsonObject().getAsJsonArray("close");
        this.volume = quote.get(0).getAsJsonObject().getAsJsonArray("volume");
        this.adjclose = Responses.chartResponse(symbol)
                .getAsJsonObject("chart")
                .getAsJsonArray("result")
                .get(0).getAsJsonObject().getAsJsonObject("indicators")
                .getAsJsonArray("adjclose")
                .get(0).getAsJsonObject().getAsJsonArray("adjclose");
    }

    public JsonArray getDate() {
        return date;
    }

    public JsonArray getOpen() {
        return open;
    }

    public JsonArray getHigh() {
        return high;
    }

    public JsonArray getLow() {
        return low;
    }

    public JsonArray getClose() {
        return close;
    }

    public JsonArray getVolume() {
        return volume;
    }

    public JsonArray getAdjclose() {
        return adjclose;
    }



}
