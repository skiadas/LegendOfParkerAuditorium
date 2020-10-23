package core;

public class MovementAction implements UserAction {

    public static final int SPEED = 1;

    public MovementAction() {
    }

    public int moveUp() {
        // if tile that the player is moving to is a wall throw exception
        // TODO: make way to check for wall
        if (false) {
            throw new InvalidMovement();
        }
        else {
            return SPEED;
        }
    }

    public int moveDown() {
        if (false) {
            throw new InvalidMovement();
        }
        else {
            return -SPEED;
        }
    }

    public int moveLeft() {
        if (false) {
            throw new InvalidMovement();
        }
        else {
            return -SPEED;
        }
    }

    public int moveRight() {
        if (false) {
            throw new InvalidMovement();
        }
        else {
            return SPEED;
        }
    }
}
