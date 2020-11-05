package core;

public class BuildingView {

    private final String name;
    private final Coordinates entranceCoordinates;
    private final int requiredNumOfKey;
    private Coordinates lowerRight;
    private Coordinates upperLeft;

    public Coordinates getLowerRight() {
        return lowerRight;
    }

    public Coordinates getUpperLeft() {
        return upperLeft;
    }

    public BuildingView(String name, Coordinates entranceCoordinates, int requiredNumOfKey, Coordinates lowerRight, Coordinates upperLeft) {
        this.name = name;
        this.entranceCoordinates = entranceCoordinates;
        this.requiredNumOfKey = requiredNumOfKey;
        this.lowerRight = lowerRight;
        this.upperLeft = upperLeft;
    }

    public String getName() {
        return name;
    }

    public Coordinates getEntranceCoordinates() {
        return entranceCoordinates;
    }

    public int getRequiredNumOfKey() {
        return requiredNumOfKey;
    }
}
