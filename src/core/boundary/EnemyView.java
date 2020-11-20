package core.boundary;

import core.boundary.Coordinates;

public class EnemyView {

    private final Coordinates cords;

    public EnemyView(Coordinates enemyCords) {
        this.cords = enemyCords;
    }

    public Coordinates getCords() {
        return cords;
    }
}
