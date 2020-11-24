package core.action;

import core.game.Direction;
import core.boundary.ActionVisitor;
import core.boundary.UserAction;

public class MovementAction implements UserAction {
    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }
    public final Direction direction;

    public MovementAction(Direction direction) {
        this.direction = direction;
    }

    public String toString() {
        return "MovementAction{" + direction + '}';
    }
}
