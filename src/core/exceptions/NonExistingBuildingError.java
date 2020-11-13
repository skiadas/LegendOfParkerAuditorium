package core.exceptions;

import core.GameErrorException;
import core.MessageFactory;

public class NonExistingBuildingError extends GameErrorException {
    public NonExistingBuildingError() {
        super(MessageFactory.getInstance().buildingDoesNotExist());
    }

}
