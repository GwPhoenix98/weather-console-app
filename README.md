Weather Console App (Java)
A Java console application that displays LIVE weather temperature for predefined cities using the OpenWeatherMap API. 
The project follows clean code principles, with clear separation of responsibilities.

Features: 
- Interactive console menu
- Select a city from a predefined enum
- Display temperature and weather description in real-time
- Continuous loop until Exit command - Custom exception handling for API errors
- Live data from an external API

Project Structure:
src/main/java/weather/app 
- WeatherApp.java // Entry point
- CityMenu.java // User interaction (console menu)
- City.java // Enum for available cities
- WeatherService.java // API call and JSON parsing
- WeatherResponse.java // DTO for weather data
- WeatherException.java // Custom exception

Technologies: 
- Java 17
- Maven
- OpenWeatherMap API
- org.json
- HTTPURLConnection

!!! OpenWeather API Key Setup: 

The application requires an OpenWeather API key, which is not included in the code.

1. Create an account at https://openweathermap.org
2. Generate an API key
3. Set it as an environment variable:

Windows (CMD): setx WEATHER_API_KEY “YOUR_API_KEY”

Linux / macOS: export WEATHER_API_KEY=YOUR_API_KEY

After setting the variable, restart your IDE.

How to Run: 
1. Clone the repository: git clone https://github.com/USERNAME/weather-console-app.git
2. Open the project in IntelliJ IDEA
3. Run the main class: WeatherApp.java

Example Output: 
=== Weather Console App 🌦 === 
1. Chisinau
2. Paris
3. London
4. Berlin
5. New York
0. Exit
Choose an option: 2
📍 Paris 🌡 12.4 °C ☁ clear sky

Applied Principles: 
- Single Responsibility Principle
- Separation of business logic from UI
- Use of enums for controlled data
- DTO for data transfer
- Safe handling of sensitive keys via environment variables

Notes: This project is intended for educational purposes and portfolio use. Each user must configure their own API key to run the application.

Author: Ion Schimbător - Junior Java Developer
