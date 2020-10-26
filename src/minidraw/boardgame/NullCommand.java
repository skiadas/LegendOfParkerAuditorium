package minidraw.boardgame;

/**
 * A null object implementation of Command. All executions does nothing and
 * return true. 
 */
public class NullCommand implements Command {
  @Override
  public boolean execute() {
    return true;
  }

  @Override
  public void setFromCoordinates(int fromX, int fromY) {
  }

  @Override
  public void setToCoordinates(int toX, int toY) {
  }
}
