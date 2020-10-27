package core;

public class Building{
    private String name;

//    public Building(String name) {
//        this.name = name;
//    }

    private boolean permissionToEnter;

//    public Building(boolean permissionToEnter) {
//        this.permissionToEnter = permissionToEnter;
//    }

    public boolean canEnter() {
        return permissionToEnter;
    }

    public String getBuildingName() {
        return name;
    }
}
