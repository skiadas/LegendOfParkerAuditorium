package core;

import core.action.ActionFactory;
import core.boundary.UserAction;
import org.junit.Test;

public class UnlockBuildingsTest {
    // TODO implement tests
    @Test
    public void canCreate() {
        UserAction action = ActionFactory.unlockBuildingsAction();
    }
}
