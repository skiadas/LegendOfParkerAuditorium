package core.exceptions;

import core.MessageFactory;

public class GameErrorException extends RuntimeException {
    public GameErrorException(String message) {
        super(message);
    }

    public static GameErrorException playerCannotMove() {
        return new GameErrorException(MessageFactory.getInstance().playerCannotMove());
    }

    public static GameErrorException buildingDoesNotExist() {
        return new GameErrorException(MessageFactory.getInstance().buildingDoesNotExist());
    }

    public static GameErrorException mustExitBuilding() {
        return new GameErrorException(MessageFactory.getInstance().mustExistBuilding());
    }

    public static GameErrorException notInAvailableBuildingsList() {
        return new GameErrorException(MessageFactory.getInstance().notInAvailableBuildingsList());
    }

    public static GameErrorException mapLocationHasNoCurrentBuilding() {
        return new GameErrorException(MessageFactory.getInstance().mapLocationHasNoCurrentBuilding());
    }

    public static GameErrorException gameNotStarted() {
        return new GameErrorException(MessageFactory.getInstance().gameNotStarted());
    }
    public static GameErrorException invalidCoordinates() {
        return new GameErrorException(MessageFactory.getInstance().invalidCoordinates());
    }
}
