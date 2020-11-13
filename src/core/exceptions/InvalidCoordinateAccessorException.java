package core.exceptions;

import core.GameErrorException;

public class InvalidCoordinateAccessorException extends GameErrorException {
    public InvalidCoordinateAccessorException() {
        super("Should not access coords for non-building");
    }
}
