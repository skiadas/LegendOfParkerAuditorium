package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementInsideBuildingTest {

    @Test
    public void playerStartsAtCorrectCoordinates() {
        Player player = new Player(1, 1);
        assertEquals(1, player.xValue);
        assertEquals(1, player.yValue);
    }

    @Test
    public void playerCanMovePositiveX() {
        Player player = new Player(1, 1);
        player.moveX(2);
        assertEquals(3, player.xValue);
    }

    @Test
    public void playerCanMoveNegativeX() {
        Player player = new Player(3, 1);
        player.moveX(-2);
        assertEquals(1, player.xValue);
    }

    @Test
    public void playerCanMovePositiveY() {
        Player player = new Player(1, 1);
        player.moveY(2);
        assertEquals(3, player.yValue);
    }

    @Test
    public void playerCanMoveNegativeY() {
        Player player = new Player(1, 3);
        player.moveY(-2);
        assertEquals(1, player.yValue);
    }
}
