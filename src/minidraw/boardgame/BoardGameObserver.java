package minidraw.boardgame;

/**
 * This defines the Observer pattern's observer role that allows the
 * BoardDrawing to observe a board game's game instance and react by redrawing
 * figures. A distinction is made between 'piece' which are the moveable objects
 * in a board game (like checkers), and 'props' which are the objects with fixed
 * position but changeable appearance (like cards or dice). 
 */
public interface BoardGameObserver<LOCATION> {
  /**
   * the update method for pieces moved from location 'from' to location 'to'.
   * 
   * @param from
   *          the LOCATION that a piece has moved from
   * @param to
   *          the LOCATION that a piece has moved to
   */
  public void pieceMovedEvent(LOCATION from, LOCATION to);

  /**
   * the update method for props changed.
   * 
   * @param keyOfChangedProp
   *          a string key identifying the game domain object that has changed.
   *          This key must be identical to that assigned in the FigureFactory's
   *
   */
  public void propChangeEvent(String keyOfChangedProp);
}
