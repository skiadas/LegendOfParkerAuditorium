package core.exceptions;

public class InvalidMovementException extends RuntimeException {
    public InvalidMovementException() {
        super("Unable to move to location.");
    }
}
