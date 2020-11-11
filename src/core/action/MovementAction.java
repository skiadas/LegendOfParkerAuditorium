package core.action;

import core.Direction;
import core.boundary.ActionVisitor;

public class MovementAction implements UserAction {
    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }
    public final Direction direction;

    public MovementAction(Direction direction) {
        this.direction = direction;
    }

}
