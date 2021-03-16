package frontend;


import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import stockdata.*;
import javax.swing.*;
import java.awt.*;


public class App {
    public static void main(String[] args) {

        Stock stock = new Stock("RY");

        final JFreeChart chart = CreateTimeSeries.create(stock);
        chart.setBackgroundPaint(new Color(25,28,38));
        final ChartPanel chartPanel = new ChartPanel( chart );
        chartPanel.setBackground(new Color(25,28,38));
        chartPanel.setPreferredSize( new java.awt.Dimension( 200 , 200 ) );
        chartPanel.setMouseZoomable( true , false );
        JFrame main_panel = new JFrame();
        main_panel.setSize(650, 440);
        main_panel.add(chartPanel);
        main_panel.setTitle("Stock Viewer");
        main_panel.setVisible(true);
        main_panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
