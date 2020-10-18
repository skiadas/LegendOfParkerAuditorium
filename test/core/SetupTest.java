package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SetupTest {
    @Test
    public void canCompile() {
        assertEquals(true, true);
    }

    @Test
    public void canCreateInstanceOfClass() {
        assertNotNull(new SampleClass());
    }
}
