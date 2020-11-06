package core.exceptions;

public class InvalidCoordinateAccessorException extends RuntimeException {
    public InvalidCoordinateAccessorException() {
        super("Should not access coords for non-building");
    }
}
