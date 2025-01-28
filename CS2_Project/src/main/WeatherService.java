package main;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {
    private final OkHttpClient client = new OkHttpClient();

    public String getWeather(String city) {
        String url = Config.WEATHER_API_URL + "?q=" + city + "&appid=" + Config.WEATHER_API_KEY + "&units=metric";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                return "Error fetching weather data. Check the city name.";
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
