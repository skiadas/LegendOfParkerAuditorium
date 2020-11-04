package core;

public class Inventory {
    private int numberOfKeys;

    public Inventory() {

    }
    public Inventory(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public int numberOfItems() {
        return numberOfKeys;
    }

    public void addKey() {
        numberOfKeys += 1;
    }

    public void addKeys(int i) {
        numberOfKeys += i;
    }
}
