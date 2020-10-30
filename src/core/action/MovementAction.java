package core.action;

import core.Direction;

public class MovementAction implements UserAction {

    public final Direction direction;

    public static MovementAction up() {
        return new MovementAction(Direction.up);
    }

    public static MovementAction down() {
        return new MovementAction(Direction.down);
    }

    public static MovementAction left() {
        return new MovementAction(Direction.left);
    }

    public static MovementAction right() {
        return new MovementAction(Direction.right);
    }

    public MovementAction(Direction direction) {
        this.direction = direction;
    }

}
