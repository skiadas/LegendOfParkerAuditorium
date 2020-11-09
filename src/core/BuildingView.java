package core;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingView that = (BuildingView) o;
        return getRequiredNumOfKey() == that.getRequiredNumOfKey() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getEntranceCoordinates(), that.getEntranceCoordinates()) &&
                Objects.equals(getLowerRight(), that.getLowerRight()) &&
                Objects.equals(getUpperLeft(), that.getUpperLeft());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEntranceCoordinates(), getRequiredNumOfKey(), getLowerRight(), getUpperLeft());
    }
}
