package stockdata;

import com.google.gson.JsonArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ConvertJsonArray {
    public static ArrayList<String> convertString(JsonArray jsonArray) {
        ArrayList<String> converted = new ArrayList<>();
        for(int i = 0; i <jsonArray.size();i++) {
            try {
                converted.add(jsonArray.get(i).getAsString());
            } catch (UnsupportedOperationException ignored) {

            }

        }
        return converted;
    }
    public static ArrayList<Double> convertDouble(JsonArray jsonArray) {
        ArrayList<Double> converted = new ArrayList<>();
        for(int i = 0; i <jsonArray.size();i++) {
            try {
                converted.add(jsonArray.get(i).getAsDouble());
            } catch (UnsupportedOperationException ignored) {

            }

        }
        return converted;
    }
    public static ArrayList<Date> convertDate(JsonArray jsonArray) {
        ArrayList<Date> converted = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i <jsonArray.size();i++) {
            try {
                Date date = formatter.parse(jsonArray.get(i).getAsString());
                converted.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return converted;

    }
}
