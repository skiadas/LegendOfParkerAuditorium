package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
    @Test
    public void canCreateCell() {
        Cell cell = new Cell();
        assertEquals(false, cell.equals(null));
    }
}
