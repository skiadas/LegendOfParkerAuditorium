package core;

public class Building{
    private String name;
    private boolean permissionToEnter;


    public Building(String name) {
        this.name = name;
    }

    public Building(boolean permissionToEnter) {
        this.permissionToEnter = permissionToEnter;
    }


    public boolean canEnter() {
        return permissionToEnter;
    }

    public String getBuildingName() {
        return name;
    }
}
