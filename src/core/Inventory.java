package core;

public class Inventory {
    private static int numberOfKeys;

    public Inventory() {

    }
    public Inventory(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public static int numberOfItems() {
        return numberOfKeys;
    }

    public void addKey() {
        numberOfKeys += 1;
    }
}
