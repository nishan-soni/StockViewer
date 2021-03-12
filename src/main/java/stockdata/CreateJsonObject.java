package stockdata;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class CreateJsonObject {
    public static JsonObject create(HttpResponse<JsonNode> response) {
        JsonElement je = new JsonParser().parse(response.getBody().toString());
        return je.getAsJsonObject();
    }
}
