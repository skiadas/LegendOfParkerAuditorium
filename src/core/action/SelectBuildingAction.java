package core.action;

import core.Building;

import java.util.List;
import java.util.Objects;

public class SelectBuildingAction implements UserAction {
    public final String buildingName;

    public SelectBuildingAction(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectBuildingAction that = (SelectBuildingAction) o;
        return Objects.equals(buildingName, that.buildingName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingName);
    }

    @Override
    public String toString() {
        return "SelectBuildingAction{" +
                "buildingName='" + buildingName + '\'' +
                '}';
    }
}
