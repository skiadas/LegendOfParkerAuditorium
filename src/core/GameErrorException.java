package core;

public class GameErrorException extends RuntimeException {
    public GameErrorException(String message) {
        super(message);
    }
}
