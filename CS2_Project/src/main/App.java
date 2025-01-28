package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Weather and Currency Exchange App!");
        System.out.print("Enter a city for weather data: ");
        String city = scanner.nextLine();

        System.out.print("Enter a currency code (e.g., USD, EUR): ");
        String currency = scanner.nextLine();

        // Fetch weather data
        WeatherService weatherService = new WeatherService();
        String weatherResponse = weatherService.getWeather(city);

        // Fetch exchange rate data
        CurrencyService currencyService = new CurrencyService();
        String currencyResponse = currencyService.getExchangeRate(currency);

        // Process and format data
        Formatter formatter = new Formatter();
        String weatherFormatted = formatter.formatWeather(weatherResponse);
        String currencyFormatted = formatter.formatCurrency(currencyResponse);

        // Display results
        System.out.println("\n--- Weather Data ---");
        System.out.println(weatherFormatted);

        System.out.println("\n--- Currency Exchange Rate ---");
        System.out.println(currencyFormatted);

        scanner.close();
    }
}
