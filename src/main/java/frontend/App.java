package frontend;

import tech.tablesaw.api.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        int yo = 1600056000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String converted = simpleDateFormat.format(new Date((long)yo*1000));
        System.out.println(converted);
    }
}
