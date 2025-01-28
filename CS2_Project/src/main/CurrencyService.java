package main;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CurrencyService {
    private final OkHttpClient client = new OkHttpClient();

    public String getExchangeRate(String currency) {
        String url = Config.EXCHANGE_API_URL + "?access_key=" + Config.EXCHANGE_API_KEY + "&symbols=" + currency;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                return "Error fetching currency data. Check the currency code.";
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
