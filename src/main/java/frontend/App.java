package frontend;


import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import stockdata.Stock;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;


public class App {
    public static void main(String[] args) throws IOException, FontFormatException {

        JTextField stock_input = new JTextField("");
        stock_input.setOpaque(false);
        stock_input.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        stock_input.setForeground(Color.WHITE);
        stock_input.setPreferredSize(new Dimension(135, 50));
        stock_input.setMaximumSize(new Dimension(135, 50));
        stock_input.setMinimumSize(new Dimension(135, 50));
        stock_input.setHorizontalAlignment(JTextField.CENTER);


        final ChartPanel chartPanel = new ChartPanel(null);
        chartPanel.setBackground(new Color(17,17,17));
        chartPanel.setPreferredSize(new Dimension(650,350));

        Font momcake = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(App.class.getClassLoader().getResourceAsStream("fonts/momcakebold.otf"))).deriveFont(45f);
        stock_input.setFont(momcake);

        JPanel stock_quote_panel = new JPanel();
        GridLayout info_layout = new GridLayout(3,3);
        info_layout.setVgap(10);
        info_layout.setHgap(100);
        stock_quote_panel.setLayout(info_layout);
        stock_quote_panel.setOpaque(false);
        stock_quote_panel.setBorder(BorderFactory.createEmptyBorder(0, 145, 30, 0));

        JLabel price =new JLabel("Price: ");
        price.setForeground(Color.WHITE);
        price.setFont(momcake.deriveFont(18f));
        JLabel open =new JLabel("Open: ");
        open.setForeground(Color.WHITE);
        open.setFont(momcake.deriveFont(18f));
        JLabel mkt_cap = new JLabel("Mkt Cap: ");
        mkt_cap.setForeground(Color.WHITE);
        mkt_cap.setFont(momcake.deriveFont(18f));
        JLabel prev_close = new JLabel("Prev Close: ");
        prev_close.setForeground(Color.WHITE);
        prev_close.setFont(momcake.deriveFont(18f));
        JLabel high = new JLabel("High: ");
        high.setForeground(Color.WHITE);
        high.setFont(momcake.deriveFont(18f));
        JLabel fifty_high = new JLabel("52wk-high: ");
        fifty_high.setForeground(Color.WHITE);
        fifty_high.setFont(momcake.deriveFont(18f));
        JLabel fifty_low = new JLabel("52wk-low: ");
        fifty_low.setForeground(Color.WHITE);
        fifty_low.setFont(momcake.deriveFont(18f));
        JLabel low = new JLabel("Low: ");
        low.setForeground(Color.WHITE);
        low.setFont(momcake.deriveFont(18f));
        JLabel pe = new JLabel("P/E ratio: ");
        pe.setForeground(Color.WHITE);
        pe.setFont(momcake.deriveFont(18f));

        stock_quote_panel.add(price);
        stock_quote_panel.add(mkt_cap);
        stock_quote_panel.add(pe);
        stock_quote_panel.add(open);
        stock_quote_panel.add(high);
        stock_quote_panel.add(low);
        stock_quote_panel.add(prev_close);
        stock_quote_panel.add(fifty_high);
        stock_quote_panel.add(fifty_low);

        JPanel main_panel = new JPanel();
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.PAGE_AXIS));
        main_panel.setBackground(new Color(17,17,17));
        main_panel.add(stock_input);
        main_panel.add(chartPanel);
        main_panel.add(stock_quote_panel);

        JFrame main_frame = new JFrame();
        main_frame.setSize(1050,680);
        main_frame.add(main_panel);
        main_frame.setTitle("Stock Viewer");
        main_frame.setVisible(true);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setIconImage(ImageIO.read(Objects.requireNonNull(App.class.getClassLoader().getResourceAsStream("images/app_icon.png"))));

        stock_input.addActionListener(e -> {
            DecimalFormat df2 = new DecimalFormat("#.##");
            Stock stock = new Stock(stock_input.getText());
            JFreeChart chart = CreateTimeSeries.create(stock);
            chartPanel.setChart(chart);
            chart.setBackgroundPaint(new Color(17,17,17));
            chartPanel.setMouseZoomable( true , false );
            chartPanel.setDomainZoomable(false);
            chartPanel.setRangeZoomable(false);

            price.setText("Price: $" + stock.getRegularMarketPrice());
            open.setText("Open: $" +stock.getRegularMarketOpen());
            mkt_cap.setText("Mkt Cap: $"+ stock.getMarketCap());
            prev_close.setText("Prev Close: $" + stock.getRegularMarketPrevClose());
            high.setText("High: $" + df2.format(Double.parseDouble(stock.getRegularMarketHigh())));
            fifty_high.setText("52wk-high: $" + stock.getfiftHigh());
            fifty_low.setText("52wk-low: $" + df2.format(Double.parseDouble(stock.getfiftLow())));
            low.setText("Low: $" + stock.getRegularMarketLow());
            try {
                pe.setText("P/E ratio: " + df2.format(Double.parseDouble(stock.getPE())));
            }catch (NullPointerException exception) {
                pe.setText("P/E ratio: ");
                JOptionPane.showInternalMessageDialog(null, "Error: P/E ratio could " +
                        "not be loaded");

            }


            main_panel.repaint();
        });





    }
}
