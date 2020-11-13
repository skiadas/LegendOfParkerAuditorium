package core.exceptions;

import core.GameErrorException;
import core.MessageFactory;

public class InvalidMovementException extends GameErrorException {
    public InvalidMovementException() {
        super(MessageFactory.getInstance().playerCannotMove());
    }

}
