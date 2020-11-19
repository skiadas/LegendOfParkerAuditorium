package core;

import core.location.Coordinates;

public class EnemyView {

    private final Coordinates cords;

    public EnemyView(Coordinates enemyCords) {
        this.cords = enemyCords;
    }

    public Coordinates getCords() {
        return cords;
    }
}
