package core;

public class StandardMessageFactory extends MessageFactory {

    public String gameAlreadyStarted() {
        return "Game Already Started";
    }

    public String characterIsDead() {
        return "You Are Dead";
    }

    public String saveGameMenuOption() {
        return "Save Game";
    }

    public String newGameMenuOption() {
        return "New Game";
    }

    public String gameNotStarted() {
        return "Game has not started";
    }

    public String buildingDoesNotExist() {
        return "Building does not exist!";
    }

    public String mustExistBuilding() {
        return "You cannot select a building when you are already inside a building";
    }

    public String mapLocationHasNoCurrentBuilding() {
        return "Should not access the current building for non-building";
    }

    public String playerCannotMove() { return "Unable to move to location."; }

    public String noCoordinatesForNonExistingBuilding() { return "Should not access coords for non-building"; }

    public String notInAvailableBuildingsList() { return "You do not have the keys to enter this building"; }

}