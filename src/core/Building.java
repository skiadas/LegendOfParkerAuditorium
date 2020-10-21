package core;

public class Building {
    private boolean permissionToEnter;

    public Building(boolean permissionToEnter) {
        this.permissionToEnter = permissionToEnter;
    }

    public boolean canEnter() {
        return permissionToEnter;
    }
}
