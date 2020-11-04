package core;

public class Building {
    private String name;
    private int requiredNumOfKeys;

    Building(String name) {
        this(name, 0);
    }

    Building(String name, int requiredNumOfKeys) {
        this.name = name;
        this.requiredNumOfKeys = requiredNumOfKeys;
    }

    String getBuildingName() {
        return name;
    }

    int getRequiredNumOfKeys() {
        return requiredNumOfKeys;
    }

    Coordinates getEntranceCoordinates() {
        return new Coordinates(0, 0);
    }
}
