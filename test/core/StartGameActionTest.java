package core;

import core.action.StartGameAction;
import core.action.UserAction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StartGameActionTest {

    @Test
    public void toStringReturnsStartGameAction() {
        UserAction action = new StartGameAction();
        assertEquals("StartGameAction", action.toString());
    }
}
