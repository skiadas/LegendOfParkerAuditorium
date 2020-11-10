package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
    @Test
    public void canCreateCell() {
        Cell exitCell = new ExitDoor();
        Cell entranceCell = new EntranceDoor();
        Cell wallCell = new Wall();
        Cell walkwayCell = new Walkway();
        assertEquals(false, exitCell.equals(null));
        assertEquals(false, entranceCell.equals(null));
        assertEquals(false, wallCell.equals(null));
        assertEquals(false, walkwayCell.equals(null));
    }
}
