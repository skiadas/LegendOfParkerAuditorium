package core.movement;

import core.InvalidMovement;
import core.Result;
import core.action.UserAction;

public class UpwardsMovementAction implements UserAction {
    public static final int SPEED = 1;

    public int moveUp() {
        // if tile that the player is moving to is a wall throw exception
        // TODO: make way to check for wall
        if (false) {
            throw new InvalidMovement();
        }
        else {
            return MovementAction.SPEED;
        }
    }
}
