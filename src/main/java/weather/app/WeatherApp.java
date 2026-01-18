package weather.app;

import weather.app.service.WeatherService;
import weather.app.ui.CityMenu;

public class WeatherApp {

    public static void main(String[] args) {

        String apiKey = System.getenv("WEATHER_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println(" ERROR: WEATHER_API_KEY environment variable is not set!");
            System.err.println("\nPlease set your API key:");
            System.err.println(" Windows: set WEATHER_API_KEY=tour_api_key_here");
            System.err.println(" Linux/Mac: export WEATHER_API_KEY=your_api_key_here");
            System.exit(1);
        }
        WeatherService weatherService = new WeatherService();
        CityMenu menu = new CityMenu(weatherService);

        menu.start();
    }
}
