package core.action;

import core.Building;

public class EnterTheBuilding implements UserAction {
    private final Building building;

    public EnterTheBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }
}
