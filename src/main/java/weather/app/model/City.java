package weather.app.model;

public enum City {
    CHISINAU(1, "Chisinau"),
    PARIS(2, "Paris"),
    LONDON(3, "London"),
    BERLIN(4, "Berlin"),
    NEW_YORK(5, "New York");

    private final int option;
    private final String name;

    City(int option, String name) {
        this.option = option;
        this.name = name;
    }

    public int getOption() {
        return option;
    }

    public String getName() {
        return name;
    }

    public static City fromOption(int option) {
        for (City city : values()) {
            if (city.option == option) {
                return city;
            }
        }
        throw new IllegalArgumentException("Invalid city option: " + option);
    }
}
