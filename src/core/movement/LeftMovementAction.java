package core.movement;

import core.InvalidMovement;
import core.Result;
import core.action.UserAction;

public class LeftMovementAction implements UserAction {
    public int moveLeft() {
        if (false) {
            throw new InvalidMovement();
        }
        else {
            return -MovementAction.SPEED;
        }
    }

    @Override
    public Result Action() {
        return null;
    }
}
