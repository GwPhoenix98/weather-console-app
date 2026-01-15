package weather.app;

public class WeatherResponse {

    private final double temperature;
    private final String description;

    public WeatherResponse(double temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }
}
