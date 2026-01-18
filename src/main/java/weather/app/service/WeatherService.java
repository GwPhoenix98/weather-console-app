package weather.app.service;

import org.json.JSONObject;
import weather.app.exception.WeatherException;
import weather.app.model.WeatherResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WeatherService {

    private static final String API_KEY = System.getenv("WEATHER_API_KEY");

    public WeatherResponse getWeather(String city) {
        if (API_KEY == null) {
            throw new WeatherException("API KEY missing!");
        }
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city +
                    "&units=metric"
                    + "&appid=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(conn.getInputStream())
                    );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            JSONObject json = new JSONObject(response.toString());

            double temp = json.getJSONObject("main").getDouble("temp");


            String description =
                    json.getJSONArray("weather")
                            .getJSONObject(0)
                            .getString("description");

            return  new WeatherResponse(temp, description);

        } catch (Exception e) {
            throw  new WeatherException("API call error");
        }
    }
}
