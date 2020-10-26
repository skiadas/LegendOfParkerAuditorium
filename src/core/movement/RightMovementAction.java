package core.movement;

import core.InvalidMovement;

public class RightMovementAction extends LeftMovementAction {
    public int moveRight() {
        if (false) {
            throw new InvalidMovement();
        }
        else {
            return MovementAction.SPEED;
        }
    }
}
