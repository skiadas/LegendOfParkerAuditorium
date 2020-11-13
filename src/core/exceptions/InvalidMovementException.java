package core.exceptions;

import core.GameErrorException;

public class InvalidMovementException extends GameErrorException {
    public InvalidMovementException() {
        super("Unable to move to location.");
    }
}
