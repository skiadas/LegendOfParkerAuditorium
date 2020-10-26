package ui;

import core.boundary.ActionHandler;
import minidraw.standard.MiniDrawApplication;
import org.junit.Test;

public class MinidrawTest {
    @Test
    public void canAccessMinidrawPackage() {
        ActionHandler handler = new TestActionHandler();
        MiniDrawApplication app = new LoPAMainApp(handler);
        app.open();
    }

    private class TestActionHandler implements ActionHandler {
    }
}
