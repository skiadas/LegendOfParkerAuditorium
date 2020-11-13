package core.exceptions;

import core.GameErrorException;
import core.MessageFactory;

public class InvalidCoordinateAccessorException extends GameErrorException {
    public InvalidCoordinateAccessorException() {
        super(MessageFactory.getInstance().noCoordinatesForNonExistingBuilding());
    }

}
