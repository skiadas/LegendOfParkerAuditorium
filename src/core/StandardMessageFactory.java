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
}