package weather.app.ui;

import weather.app.exception.WeatherException;
import weather.app.model.City;
import weather.app.model.WeatherResponse;
import weather.app.service.WeatherService;

import java.util.Scanner;

public class CityMenu {

    private final WeatherService service;

    public CityMenu(WeatherService service) {
        this.service = service;
    }

    public void start() {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            System.out.println("=== WEATHER app \uD83C\uDF26 ===");

            while (running) {
                printMenu();
                System.out.println("Choose option: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Please enter a valid number!\\n");
                    scanner.next();
                    continue;
                }

                int option = scanner.nextInt();

                if (option == 0) {
                    running = false;
                    System.out.println("Goodbye 👋");
                    break;
                }

                try {
                    City city = City.fromOption(option);
                    WeatherResponse weather = service.getWeather(city.getName());

                    displayWeather(city, weather);

                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Invalid option! Please choose from the menu. \n");
                } catch (WeatherException e) {
                    System.out.println("❌ " + e.getMessage() + "\n");
                }
            }
        }
    }

    private void displayWeather(City city, WeatherResponse weather) {
        System.out.println("\n📍 " + city.getName());
        System.out.println("🌡  " + weather.getTemperature() + " °C");
        System.out.println("☁  " + weather.getDescription());
        System.out.println();
    }

    private void printMenu() {
        for (City city : City.values()) {
            System.out.println(city.getOption() + ". " + city.getName());
        }
        System.out.println("0. Exit");
    }
}
