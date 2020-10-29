package core.action;

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
}
