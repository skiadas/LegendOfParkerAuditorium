package core;

public class SelectBuildingAction implements UserAction {
    private final int index;

    public SelectBuildingAction(int index) {
        if (index < 0 || index > 10) {
            throw new RuntimeException("No Such Building index value");
        }
        this.index = index;
    }

    public int getNum() {
        return index;
    }

    @Override
    public Result Action() {
        return null;
    }
}
