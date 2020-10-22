package core;

public class MovementAction implements UserAction {

    public static final int SPEED = 1;

    public MovementAction() {
    }

    public int moveUp() {
        return SPEED;
    }

    public int moveDown() {
        return -SPEED;
    }

    public int moveLeft() {
        return -SPEED;
    }

    public int moveRight() {
        return SPEED;
    }
}
