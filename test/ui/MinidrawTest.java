package ui;

import core.action.*;
import core.boundary.ActionHandler;

public class MinidrawTest {
//    @Test
//    public void canAccessMinidrawPackage() {
//        ActionRouter handler = new TestActionHandler();
//        MiniDrawApplication app = new LoPAMainApp(handler);
//        app.open();
//    }

    // TODO: Fix this mess!
    private class TestActionHandler implements ActionHandler {
        public void perform(AppLoadAction action) {
            // TODO: Figure out if something should go here
        }

        public void perform(SaveGameAction action) {

        }

        @Override
        public void perform(GameWonAction action) {

        }

        public void perform(UserAction action) {

        }

        public void perform(SeeAvailableBuildingsAction action) {

        }

        public void perform(NewGameAction action) {

        }

        public UserAction getStartAction() {
            return ActionFactory.appLoadAction();
        }

        public void perform(StartGameAction action) {

        }

        public void perform(SelectBuildingAction action) {

        }

        public void perform(MovementAction action) {

        }
    }
}
