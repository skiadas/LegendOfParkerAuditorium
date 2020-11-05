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

    boolean isValidMovement(Coordinates requestedMove) {
        if (isInsideBuilding(requestedMove)) {
            // TODO: checking if tile is a wall or other invalid movement tile
            return true;
        }
        return false;
    }

    private boolean isInsideBuilding(Coordinates requestedMove) {
        return requestedMove.xValue >= upperLeft.xValue && requestedMove.yValue <= upperLeft.yValue && requestedMove.xValue <= lowerRight.xValue && requestedMove.yValue >= lowerRight.yValue;
    }

    private void drawBuildingBoundaries(){
        this.upperLeft = new Coordinates(-20,20);
        this.lowerRight = new Coordinates(20,-20);
    }
}
