package backend;


public class Tester {
    public static void main(String[] args) {
        Stock msft = new Stock("MSFT");
        System.out.println(msft.getChartList().getDate());
        System.out.println(msft.getChartList().getOpen());
        System.out.println(msft.getChartList().getHigh());
        System.out.println(msft.getChartList().getLow());
        System.out.println(msft.getChartList().getClose());
        System.out.println(msft.getChartList().getVolume());
        System.out.println(msft.getChartList().getAdjclose());
    }
}
