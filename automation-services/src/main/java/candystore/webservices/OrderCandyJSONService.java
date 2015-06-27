package candystore.webservices;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class OrderCandyJSONService {

	public String buildOrderCandyRequest(Map<String, Integer> orderLines) {

        JsonObject orderCandy = new JsonObject(); // outside container
        JsonArray lines = new JsonArray(); // container to hold order lines
        
        for(Entry<String, Integer> orderLine : orderLines.entrySet()){
        	JsonObject line = new JsonObject(); // single order line
            line.addProperty("sku", orderLine.getKey());
            line.addProperty("quantity", orderLine.getValue());
            lines.add(line);
        }
        
        orderCandy.add("orderLines", lines );
        
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        String request = gson.toJson(orderCandy);
        
        return request;
	}
}
