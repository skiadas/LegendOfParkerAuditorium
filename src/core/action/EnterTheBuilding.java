package core.action;

import core.Building;

public class EnterTheBuilding implements UserAction {
    public final Building building;

    public EnterTheBuilding(Building building) {
        this.building = building;
    }
}
