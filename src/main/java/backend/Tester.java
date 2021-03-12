package backend;

public class Tester {
    public static void main(String[] args) {
        Stock apple = new Stock("AAPL");
        System.out.println(apple.getRegularMarketPrice());

        Stock microsoft = new Stock("MSFT");
        System.out.println(microsoft.getRegularMarketPrice());
    }
}
