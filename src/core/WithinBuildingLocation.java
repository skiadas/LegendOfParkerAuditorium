package core;


import java.util.Objects;

public class WithinBuildingLocation implements Location {
    public int xValue;
    public int yValue;

    public WithinBuildingLocation(int xValue, int yValue) {
        super();
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public int getxValue() {
        return xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithinBuildingLocation that = (WithinBuildingLocation) o;
        return xValue == that.xValue &&
                yValue == that.yValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xValue, yValue);
    }

    @Override
    public boolean isBuildingLocation() {
        return true;
    }

    @Override
    public void setCurrentBuilding(Building building) {

    }

    @Override
    public boolean isBuildingEntrance() {
        return false;
    }
}
