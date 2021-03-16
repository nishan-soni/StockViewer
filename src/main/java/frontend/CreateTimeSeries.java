package frontend;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import stockdata.ConvertJsonArray;
import stockdata.Stock;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class CreateTimeSeries{

    public static JFreeChart create(Stock stock) {
        TimeSeries series = new TimeSeries(stock.getSymbol() +" Price");
        ArrayList<Date> dates = ConvertJsonArray.convertDate(stock.getChartList().getDate());
        ArrayList<Double> adjclose = ConvertJsonArray.convertDouble(stock.getChartList().getAdjclose());

        Day current = new Day();
        for(int i= 0; i < adjclose.size(); i++) {

            series.add(new Day(dates.get(i)), adjclose.get(i));
        }

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(142,123,211));
        renderer.setSeriesShapesVisible(0, false);
        renderer.setDefaultStroke(new BasicStroke(2.5f));
        renderer.setAutoPopulateSeriesStroke(false);

        TimeSeriesCollection dataset = new TimeSeriesCollection(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                stock.getSymbol(),
                "",
                "",
                dataset,
                false,
                false,
                false);
        chart.getPlot().setBackgroundPaint(new Color(12,12,12));
        chart.getXYPlot().setRangeGridlinesVisible(false);
        chart.getXYPlot().setDomainGridlinesVisible(false);
        chart.getXYPlot().getRangeAxis().setVisible(false);
        chart.getXYPlot().getDomainAxis().setVisible(false);
        chart.getXYPlot().setRenderer(renderer);

        return chart;
        }

    }
