package core;

public class Building{
    private String name;
    private boolean permissionToEnter;


    public Building(String name) {
        this.name = name;
    }

    public Building(String name, boolean permissionToEnter) {
        this.permissionToEnter = permissionToEnter;
        this.name = name;
    }

    public boolean canEnter() {
        return permissionToEnter;
    }

    public String getBuildingName() {
        return name;
    }

    public void setPermissionToEnter(boolean permissionToEnter) {
        this.permissionToEnter = permissionToEnter;
    }

    Coordinates getEntranceCoordinates() {
        return new Coordinates(0, 0);
    }
}
