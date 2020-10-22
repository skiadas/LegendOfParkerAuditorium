package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMovementActionTest {
    @Test
    public void playerCanMoveUp() {
        MovementAction movement = new MovementAction();
        assertEquals(1, movement.moveUp());
    }

    @Test
    public void playerCanMoveDown() {
        MovementAction movement = new MovementAction();
        assertEquals(-1, movement.moveDown());
    }

    @Test
    public void playerCanMoveLeft() {
        MovementAction movement = new MovementAction();
        assertEquals(-1, movement.moveLeft());
    }

    @Test
    public void playerCanMoveRight() {
        MovementAction movement = new MovementAction();
        assertEquals(1, movement.moveRight());
    }
}
