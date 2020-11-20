package core.game;

import core.action.ActionFactory;
import core.action.MovementAction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementInsideBuildingTest {


    @Test
    public void canCreateDirectionUp() {
        Direction direction = Direction.up;
    }

    @Test
    public void canCreateDirectionDown() {
        Direction direction = Direction.down;
    }

    @Test
    public void canCreateDirectionLeft() {
        Direction direction = Direction.left;
    }

    @Test
    public void canCreateDirectionRight() {
        Direction direction = Direction.right;
    }

    @Test
    public void canCallMovementActionWithDirectionUp() {
        MovementAction movementAction = (MovementAction) ActionFactory.moveUp();
        assertEquals(Direction.up, movementAction.direction);
    }

    @Test
    public void canCallMovementActionWithDirectionDown() {
        MovementAction movementAction = (MovementAction) ActionFactory.moveDown();
        assertEquals(Direction.down, movementAction.direction);
    }

    @Test
    public void canCallMovementActionWithDirectionLeft() {
        MovementAction movementAction = (MovementAction) ActionFactory.moveLeft();
        assertEquals(Direction.left, movementAction.direction);
    }

    @Test
    public void canCallMovementActionWithDirectionRight() {
        MovementAction movementAction = (MovementAction) ActionFactory.moveRight();
        assertEquals(Direction.right, movementAction.direction);
    }
}
