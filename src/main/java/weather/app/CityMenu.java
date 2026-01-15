package weather.app;

import java.util.Scanner;

public class CityMenu {

    private final WeatherService service = new WeatherService();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== WEATHER app \uD83C\uDF26 ===");

        while (running) {
            printMenu();
            System.out.println("Choose option: ");

            int option = scanner.nextInt();

            if (option == 0) {
                running = false;
                System.out.println("Goodbye 👋");
                continue;
            }

            City city = City.fromOption(option);

            if (city == null) {
                System.out.println("❌ Invalid option!");
                continue;
            }

            try {
                WeatherResponse weather = service.getWeather(city.getName());

                System.out.println("\n📍 " + city.getName());
                System.out.println("🌡 " + weather.getTemperature() + " °C");
                System.out.println("☁ " + weather.getDescription());
                System.out.println();

            } catch (WeatherException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        for (City city : City.values()) {
            System.out.println(city.getOption() + ". " + city.getName());
        }
        System.out.println("0. Exit");
    }
}
