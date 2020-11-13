package core;

public abstract class MessageFactory {
    private static MessageFactory instance;

    public static MessageFactory getInstance() {
        return instance;
    }

    public static void setInstance(MessageFactory factory) {
        instance = factory;
    }

    public abstract String gameAlreadyStarted();
    public abstract String characterIsDead();
    public abstract String saveGameMenuOption();
    public abstract String newGameMenuOption();
    public abstract String gameNotStarted();
    public abstract String buildingDoesNotExist();
    public abstract String mustExistBuilding();
    public abstract String mapLocationHasNoCurrentBuilding();
    public abstract String playerCannotMove();
    public abstract String noCoordinatesForNonExistingBuilding();
    public abstract String notInAvailableBuildingsList();
}
