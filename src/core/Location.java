package core;

public class Location {
    private final boolean isBuildingEnterSquare;

    public Location(boolean isBuildingEnterSquare) {
        this.isBuildingEnterSquare = isBuildingEnterSquare;
    }

    public boolean isBuildingEntrance() {
        return isBuildingEnterSquare;
    }
}
