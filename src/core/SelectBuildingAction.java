package core;

public class SelectBuildingAction implements UserAction {
    private final int buildingNumber;

    public SelectBuildingAction(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
    public int getNum() {
        return buildingNumber;
    }
}
