package core.action;

import core.boundary.ActionVisitor;
import core.boundary.UserAction;

import java.util.Objects;

public class SelectBuildingAction implements UserAction {
    public final String buildingName;

    public SelectBuildingAction(String buildingName) {
        this.buildingName = buildingName;
    }

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
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
        return String.format("SelectBuildingAction{%s}", buildingName);
    }
}
