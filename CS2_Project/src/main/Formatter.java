package main;

import org.json.JSONObject;

public class Formatter {
    public String formatWeather(String jsonResponse) {
        JSONObject json = new JSONObject(jsonResponse);
        String city = json.getString("name");
        String temperature = json.getJSONObject("main").getDouble("temp") + "°C";
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

        return "City: " + city + "\n" +
               "Temperature: " + temperature + "\n" +
               "Description: " + description;
    }

    public String formatCurrency(String jsonResponse) {
        JSONObject json = new JSONObject(jsonResponse);
        JSONObject rates = json.getJSONObject("rates");
        StringBuilder formatted = new StringBuilder();

        for (String currency : rates.keySet()) {
            formatted.append(currency).append(": ").append(rates.getDouble(currency)).append("\n");
        }

        return formatted.toString();
    }
}
