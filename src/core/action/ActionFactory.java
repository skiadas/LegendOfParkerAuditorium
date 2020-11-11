package core.action;

import core.Direction;

public class ActionFactory {
    public static UserAction seeAvailableBuildings() {
        return new SeeAvailableBuildingsAction();
    }

    public static UserAction moveUp() {
        return new MovementAction(Direction.up);
    }

    public static UserAction moveDown() {
        return new MovementAction(Direction.down);
    }

    public static UserAction moveLeft() {
        return new MovementAction(Direction.left);
    }

    public static UserAction moveRight() {
        return new MovementAction(Direction.right);
    }
}
