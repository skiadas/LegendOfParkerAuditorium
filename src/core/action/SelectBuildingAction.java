package core.action;

public class SelectBuildingAction implements UserAction {
    private final int index;

    public SelectBuildingAction(int index) {
        this.index = index;
    }

    public int getBuildingNum() {
        return index;
    }

}
