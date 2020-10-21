package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMovementActionTest {
    @Test
    public void startsWithPlayerInformation() {
        MovementAction movementAction = new MovementAction(new Player(1, 1));
        assertEquals(new Player(1, 1), movementAction.player);
    }

    @Test
    public void canMove() {
        MovementAction movementAction = new MovementAction(new Player(1, 1));
        movementAction.moveX(2);
        movementAction.moveY(2);
        assertEquals(3, movementAction.player.xValue);
        assertEquals(3, movementAction.player.yValue);
    }
}
