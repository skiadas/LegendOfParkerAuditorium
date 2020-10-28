package core;

import core.action.MovementAction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementInsideBuildingTest {


    @Test
    public void canCreateDirectionUp() {
        MovementAction.Direction direction = MovementAction.Direction.up;
    }

    @Test
    public void canCreateDirectionDown() {
        MovementAction.Direction direction = MovementAction.Direction.down;
    }

    @Test
    public void canCreateDirectionLeft() {
        MovementAction.Direction direction = MovementAction.Direction.left;
    }

    @Test
    public void canCreateDirectionRight() {
        MovementAction.Direction direction = MovementAction.Direction.right;
    }

    @Test
    public void canCallMovementActionWithDirectionUp() {
        MovementAction movementAction = MovementAction.up();
        assertEquals(MovementAction.Direction.up, movementAction.direction);
    }

    @Test
    public void canCallMovementActionWithDirectionDown() {
        MovementAction movementAction = MovementAction.down();
        assertEquals(MovementAction.Direction.down, movementAction.direction);
    }

    @Test
    public void canCallMovementActionWithDirectionLeft() {
        MovementAction movementAction = MovementAction.left();
        assertEquals(MovementAction.Direction.left, movementAction.direction);
    }

    @Test
    public void canCallMovementActionWithDirectionRight() {
        MovementAction movementAction = MovementAction.right();
        assertEquals(MovementAction.Direction.right, movementAction.direction);
    }
}
