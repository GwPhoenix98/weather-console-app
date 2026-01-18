package weather.app.service;

import org.json.JSONObject;
import weather.app.exception.WeatherException;
import weather.app.model.WeatherResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WeatherService {

    private static final String API_KEY = System.getenv("WEATHER_API_KEY");
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public WeatherResponse getWeather(String city) {

        validateApiKey();

        String urlString = String.format("%s?q=%s&units=metric&appid=%s", BASE_URL, city, API_KEY);

        HttpURLConnection conn = null;

        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new WeatherException("Failed to fetch weather data. HTTP code: " + responseCode);
            }

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                {

                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    return parseWeatherResponse(response.toString());
                }
            } catch (IOException e) {
                throw new WeatherException("Network error: " + e.getMessage());
            } catch (Exception e) {
                throw new WeatherException("Error processing weather data: " + e.getMessage());
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
        }

        private validateApiKey () {
            if (API_KEY == null || API_KEY.isEmpty()) {
                throw new WeatherException("API KEY missing! Please set WEATHER_API_KEY environment variable.");
            }
        }

        private WeatherResponse parseWeatherResponse (String jsonString) {
            try {
                JSONObject json = new JSONObject(response.toString());

                double temp = json.getJSONObject("main").getDouble("temp");
                String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

                return new WeatherResponse(temp, description);
            } catch (Exception e) {
                throw new WeatherException("API call error");
            }
        }
    }
