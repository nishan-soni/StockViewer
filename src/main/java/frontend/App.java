package frontend;


import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import stockdata.*;
import javax.swing.*;
import java.awt.*;


public class App {
    public static void main(String[] args) {

        JTextField stock_input = new JTextField("Stock Symbol");
        stock_input.setOpaque(false);
        stock_input.setBorder(BorderFactory.createEmptyBorder());
        stock_input.setForeground(Color.WHITE);
        stock_input.setFont(new Font("Verdana",Font.BOLD,15));

        final ChartPanel chartPanel = new ChartPanel(null);
        chartPanel.setBackground(new Color(25,28,38));

        JPanel main_panel = new JPanel();
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.PAGE_AXIS));
        main_panel.setBackground(new Color(25,28,38));
        main_panel.add(stock_input);
        main_panel.add(chartPanel);

        JFrame main_frame = new JFrame();
        main_frame.setSize(1050,680);
        main_frame.add(main_panel);
        main_frame.setTitle("Stock Viewer");
        main_frame.setVisible(true);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        stock_input.addActionListener(e -> {
            Stock stock = new Stock(stock_input.getText());
            JFreeChart chart = CreateTimeSeries.create(stock);
            chartPanel.setChart(chart);
            chart.setBackgroundPaint(new Color(25,28,38));
            chartPanel.setMouseZoomable( true , false );
            chartPanel.setDomainZoomable(false);
            chartPanel.setRangeZoomable(false);
            main_panel.repaint();
        });





    }
}
