package core;

public class Building{
    private String name;
    private int requiredNumOfKeys;


    public Building(String name) {
        this.name = name;
    }

    public Building(int requiredNumOfKeys) {
        this.requiredNumOfKeys = requiredNumOfKeys;
    }

    public Building(String name, int requiredNumOfKeys) {
        this.name = name;
        this.requiredNumOfKeys = requiredNumOfKeys;
    }

    public String getBuildingName() {
        return name;
    }

    public int getRequiredNumOfKeys() {
        return requiredNumOfKeys;
    }

    Coordinates getEntranceCoordinates() {
        return new Coordinates(0, 0);
    }
}
