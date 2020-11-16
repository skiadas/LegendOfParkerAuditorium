package core;

public class Inventory {
    private int numberOfKeys;

    public Inventory() {
        this(0);
    }

    public Inventory(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void addKey() {
        numberOfKeys += 1;
    }

    public void addKeys(int i) {
        numberOfKeys += i;
    }
}
