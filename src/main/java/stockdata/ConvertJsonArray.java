package stockdata;

import com.google.gson.JsonArray;


import java.util.ArrayList;

public class ConvertJsonArray {
    public static ArrayList<String> convertString(JsonArray jsonArray) {
        ArrayList<String> converted = new ArrayList<>();
        for(int i = 0; i <jsonArray.size();i++) {
            converted.add(jsonArray.get(i).getAsString());
        }
        return converted;
    }
    public static ArrayList<Double> convertDouble(JsonArray jsonArray) {
        ArrayList<Double> converted = new ArrayList<>();
        for(int i = 0; i <jsonArray.size();i++) {
            converted.add(jsonArray.get(i).getAsDouble());
        }
        return converted;
    }
}
