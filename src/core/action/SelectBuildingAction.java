package core.action;

import java.util.Objects;

public class SelectBuildingAction implements UserAction {
    private int index;
    private String buildingName;

    public SelectBuildingAction(int index) {
        this.index = index;
    }
    

    public int getSelectedBuildingNum() {
        return index;
    }


    public SelectBuildingAction(String buildingName) {
        this.buildingName = buildingName;
    }


    public String getSelectedBuildingName() {
        return buildingName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectBuildingAction that = (SelectBuildingAction) o;
        return index == that.index &&
                Objects.equals(buildingName, that.buildingName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, buildingName);
    }

    @Override
    public String toString() {
        return "SelectBuildingAction{" +
                "index=" + index +
                ", buildingName='" + buildingName + '\'' +
                '}';
    }
}
