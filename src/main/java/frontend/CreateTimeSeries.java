package frontend;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.SeriesException;
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

        for(int i= 0; i < adjclose.size(); i++) {
            try {
                series.add(new Day(dates.get(i)), adjclose.get(i));
            }catch (SeriesException ignored) {

            }

        }

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(141,17,71));
        renderer.setSeriesShapesVisible(0, false);
        renderer.setDefaultStroke(new BasicStroke(2.5f));
        renderer.setAutoPopulateSeriesStroke(false);

        TimeSeriesCollection dataset = new TimeSeriesCollection(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "",
                "",
                "",
                dataset,
                false,
                false,
                false);
        chart.getPlot().setBackgroundPaint(new Color(25,28,38));
        chart.getXYPlot().setRangeGridlinesVisible(false);
        chart.getXYPlot().setDomainGridlinesVisible(false);
        chart.getXYPlot().getRangeAxis().setVisible(false);
        chart.getXYPlot().getDomainAxis().setVisible(false);
        chart.getXYPlot().setOutlinePaint(null);
        chart.getXYPlot().setRenderer(renderer);

        return chart;
        }

    }
