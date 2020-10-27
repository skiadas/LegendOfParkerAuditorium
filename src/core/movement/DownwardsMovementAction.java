package core.movement;

import core.InvalidMovement;
import core.action.UserAction;

public class DownwardsMovementAction extends UpwardsMovementAction implements UserAction {
    public int moveDown() {
        if (false) {
            throw new InvalidMovement();
        }
        else {
            return -MovementAction.SPEED;
        }
    }
}
