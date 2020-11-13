package core;

public class Wall implements Cell {
    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public void onMoveToCell() {

    }
}
