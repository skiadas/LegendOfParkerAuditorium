package core;

public class NonExistingBuildingError extends GameErrorException {
    public NonExistingBuildingError() {
        super(MessageFactory.getInstance().buildingDoesNotExist());
    }

}
