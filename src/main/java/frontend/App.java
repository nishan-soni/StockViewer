package frontend;


import stockdata.ConvertJsonArray;
import stockdata.Stock;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) {

        Stock MSFT = new Stock("MSFT");

        Table stock_table = Table.create("MSFT Chart");
        stock_table.addColumns(
                StringColumn.create("Date", ConvertJsonArray.convertString(MSFT.getChartList().getDate())),
                DoubleColumn.create("Open", ConvertJsonArray.convertDouble(MSFT.getChartList().getOpen())),
                DoubleColumn.create("High", ConvertJsonArray.convertDouble(MSFT.getChartList().getHigh())),
                DoubleColumn.create("Low", ConvertJsonArray.convertDouble(MSFT.getChartList().getLow())),
                DoubleColumn.create("Close", ConvertJsonArray.convertDouble(MSFT.getChartList().getClose()))
        );






    }
}
