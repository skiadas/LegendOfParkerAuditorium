package core;

import core.location.Coordinates;

public class LocatedItem<S> {
    private Key key;
    private Coordinates coords;

    public LocatedItem(Coordinates coords) {
        this.coords = coords;
        this.key = new Key();
    }

    public Coordinates getItemCoords() {
        return coords;
    }

}
