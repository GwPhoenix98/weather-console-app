# ☁️ Weather Console App

A Java console application that displays **real-time weather data** for predefined cities using the [OpenWeatherMap API](https://openweathermap.org). 
The project follows clean code principles with clear separation of concerns and proper error handling.

![Java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue?style=flat&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-green?style=flat)

## ✨ Features

- 🌍 **Interactive console menu** - Easy-to-use text interface
- 🏙️ **Predefined cities** - Select from major cities worldwide
- 🌡️ **Real-time weather data** - Current temperature and conditions
- 🔄 **Continuous operation** - Loop until user exits
- ⚠️ **Custom exception handling** - Graceful error management
- 🔒 **Secure API key handling** - Environment variable configuration
- 🧹 **Clean code** - SOLID principles and best practices

## 🏗️ Project Structure

```
weather-console-app/
├── src/
│   └── main/
│       └── java/
│           └── weather/
│               └── app/
│                   ├── WeatherApp.java           // Application entry point
│                   ├── ui/
│                   │   └── CityMenu.java         // User interaction
│                   ├── model/
│                   │   ├── City.java             // Cities enum
│                   │   └── WeatherResponse.java  // Weather data DTO
│                   ├── service/
│                   │   └── WeatherService.java   // API integration
│                   └── exception/
│                       └── WeatherException.java // Custom exception
├── pom.xml
└── README.md
```

## 🛠️ Technologies

- **Java 17** - Programming language
- **Maven** - Build and dependency management
- **OpenWeatherMap API** - Weather data provider
- **org.json** - JSON parsing
- **HttpURLConnection** - HTTP client

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.8+
- OpenWeatherMap API key (free)
- Internet connection

## 🔑 API Key Setup

The application requires an OpenWeatherMap API key. Follow these steps:

### 1. Get your API key
1. Create a free account at [OpenWeatherMap](https://openweathermap.org)
2. Navigate to **API Keys** section
3. Generate a new API key
4. Copy your API key

### 2. Set environment variable

**Windows (CMD):**
```cmd
setx WEATHER_API_KEY "your_api_key_here"
```

**Windows (PowerShell):**
```powershell
[System.Environment]::SetEnvironmentVariable('WEATHER_API_KEY','your_api_key_here','User')
```

**Linux / macOS:**
```bash
export WEATHER_API_KEY="your_api_key_here"
```

**Permanent (Linux/macOS):**
Add to `~/.bashrc` or `~/.zshrc`:
```bash
echo 'export WEATHER_API_KEY="your_api_key_here"' >> ~/.bashrc
source ~/.bashrc
```

> ⚠️ **Important:** Restart your IDE/terminal after setting the environment variable!

## 🚀 How to Run

### Option 1: Using Maven

```bash
# Clone the repository
git clone https://github.com/GwPhoenix98/weather-console-app.git

# Navigate to project directory
cd weather-console-app

# Run with Maven
mvn clean compile exec:java
```

### Option 2: Using IDE (IntelliJ IDEA)

1. Open the project in IntelliJ IDEA
2. Wait for Maven to download dependencies
3. Run `WeatherApp.java` (right-click → Run)

### Option 3: Build JAR and run

```bash
# Build the project
mvn clean package

# Run the JAR
java -jar target/weather-console-app-1.0-SNAPSHOT.jar
```

## 📱 Usage Example

```
=== WEATHER app 🌦 ===

--- Available Cities ---
1. Chisinau
2. Paris
3. London
4. Berlin
5. New York
0. Exit
Choose option: 2

📍 Paris
🌡  12.4 °C
☁  clear sky

--- Available Cities ---
1. Chisinau
2. Paris
3. London
4. Berlin
5. New York
0. Exit
Choose option: 0

Goodbye 👋
```

## 🏛️ Architecture & Design Patterns

### Applied Principles

- ✅ **Single Responsibility Principle (SRP)** - Each class has one clear purpose
- ✅ **Dependency Injection** - Loose coupling between components
- ✅ **Separation of Concerns** - UI, business logic, and data access are separated
- ✅ **DTO Pattern** - `WeatherResponse` for data transfer
- ✅ **Enum Pattern** - Type-safe city selection
- ✅ **Exception Handling** - Custom exceptions for domain errors
- ✅ **Resource Management** - Try-with-resources for automatic cleanup

### Class Responsibilities

| Class | Responsibility |
|-------|---------------|
| `WeatherApp` | Application entry point, dependency wiring |
| `CityMenu` | User interface and interaction flow |
| `City` | Enum of available cities |
| `WeatherService` | HTTP communication with OpenWeatherMap API |
| `WeatherResponse` | Immutable data container for weather info |
| `WeatherException` | Custom exception for weather-related errors |

## 🧪 Error Handling

The application handles various error scenarios:

- ❌ Missing API key → Clear setup instructions
- ❌ Invalid city option → User-friendly error message
- ❌ Network errors → Timeout and connection error handling
- ❌ API errors → HTTP status code validation
- ❌ Invalid input → Input validation and retry

## 🔒 Security

- API keys stored as environment variables (not in code)
- No sensitive data in version control
- Input validation to prevent crashes
- Proper exception handling for API errors

## 📝 Future Improvements

- [ ] Add more weather details (humidity, wind speed, pressure)
- [ ] Support for custom city input
- [ ] 5-day weather forecast
- [ ] Unit tests with JUnit and Mockito
- [ ] Integration tests
- [ ] Caching to reduce API calls
- [ ] Logging with SLF4J/Logback
- [ ] Configuration file (application.properties)
- [ ] Migrate to Spring Boot
- [ ] Add GUI version (JavaFX)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'feat: add some amazing feature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Ion Schimbător**
- GitHub: [@GwPhoenix98](https://github.com/GwPhoenix98)

## 🙏 Acknowledgments

- [OpenWeatherMap](https://openweathermap.org) for providing the weather API
- Java community for excellent documentation and resources

---

⭐ **If you found this project helpful, please consider giving it a star!**

---

**Note:** This project is created for educational purposes and portfolio demonstration. Each user must obtain their own OpenWeatherMap API key to run the application.
