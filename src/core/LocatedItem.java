package core;

public class LocatedItem<S> {
    private int key;
    private Coordinates coords;

    public LocatedItem(Coordinates coords) {
        this.coords = coords;
        this.key = 1;
    }

    public Coordinates getCoords() {
        return coords;
    }
}
