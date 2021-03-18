package stockdata;

import com.google.gson.*;


public class Stock {
    private final String symbol;
    private final ChartList chart_data;
    private final JsonObject quoteResponse;

    public Stock(String symbol) {
        this.symbol = symbol;
        this.chart_data = new ChartList(symbol);
        this.quoteResponse = Responses.quoteResponse(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRegularMarketPrice()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketPrice").getAsString();
    }

    public String getRegularMarketHigh()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketDayHigh").getAsString();
    }

    public String getRegularMarketLow()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketDayLow").getAsString();
    }

    public String getMarketCap()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("marketCap").getAsString();
    }

    public String getRegularMarketOpen()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketOpen").getAsString();
    }

    public String getRegularMarketPrevClose()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("regularMarketPreviousClose").getAsString();
    }

    public String getPE()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("trailingPE").getAsString();
    }

    public String getfiftHigh()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("fiftyTwoWeekHigh").getAsString();
    }

    public String getfiftLow()  {
        JsonArray results = quoteResponse
                .getAsJsonObject("quoteResponse")
                .getAsJsonArray("result");

        return results.get(0).getAsJsonObject().get("fiftyTwoWeekLow").getAsString();
    }

    public ChartList getChartList() {
        return chart_data;
    }

}
