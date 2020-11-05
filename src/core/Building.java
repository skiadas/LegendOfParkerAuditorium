package core;

public class Building {
    private String name;
    private int requiredNumOfKeys;
    private Coordinates upperLeft;
    private Coordinates lowerRight;

    Building(String name) {
        this(name, 0);
    }

    Building(String name, int requiredNumOfKeys) {
        this.name = name;
        this.requiredNumOfKeys = requiredNumOfKeys;
        this.drawBuildingBoundaries();
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

    void drawBuildingBoundaries(){
        this.upperLeft = new Coordinates(0,20);
        this.lowerRight = new Coordinates(20,0);
    }



}
