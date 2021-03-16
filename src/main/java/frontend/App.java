package frontend;


import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import stockdata.*;

import javax.swing.*;




public class App {
    public static void main(String[] args) {

        Stock MSFT = new Stock("MSFT");

        final JFreeChart chart = CreateTimeSeries.create(MSFT);
        final ChartPanel chartPanel = new ChartPanel( chart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 200 , 200 ) );
        chartPanel.setMouseZoomable( true , false );
        JFrame hi = new JFrame();
        hi.setSize(400, 400);
        hi.add(chartPanel);
        hi.setVisible(true);
        hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

















    }
}
