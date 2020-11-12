package core.action;

import core.Direction;

public class ActionFactory {
    public static UserAction seeAvailableBuildings() {
        return new SeeAvailableBuildingsAction();
    }

    public static UserAction moveUp() {
        return new MovementAction(Direction.up);
    }

    public static UserAction moveDown() {
        return new MovementAction(Direction.down);
    }

    public static UserAction moveLeft() {
        return new MovementAction(Direction.left);
    }

    public static UserAction moveRight() {
        return new MovementAction(Direction.right);
    }

    public static UserAction startGameAction() {
        return new StartGameAction();
    }

    public static UserAction appLoadAction() {
        return new AppLoadAction();
    }

    public static UserAction newGameAction() {
        return new NewGameAction();
    }

    public static UserAction saveGameAction() {
        return new SaveGameAction();
    }

    public static UserAction selectBuildingAction(String buildingName) {
        return new SelectBuildingAction(buildingName);
    }

    public static UserAction unlockBuildingsAction() {
        return new UnlockBuildingsAction();
    }
}

