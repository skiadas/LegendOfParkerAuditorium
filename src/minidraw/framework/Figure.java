package minidraw.framework;

import java.awt.*;

/**
 * This interface defines the role of a Figure in a MiniDraw drawing. Figure
 * instances acts as
 * 
 * Responsibilities: A) Represent a Figure in the model. B) Draw itself in a
 * Graphics context. C) Allow manipulations like moving. D) Has the Subject role
 * in the observer pattern as a Figure broadcasts FigureChangeEvents whenever it
 * changes.
 */

public interface Figure {

  /**
   * Draws the figure.
   *
   * @param g
   *          the Graphics to draw into
   */
  void draw(Graphics g);

  /**
   * Return the display box of this figure. The display box is the smallest
   * rectangle that completely contains the figure.
   *
   * @return the display box.
   */
  Rectangle displayBox();

  /**
   * Move the figure by a delta (dx, dy) offset from its present position.
   *
   * @param dx
   *          amount to move in x
   * @param dy
   *          amount to move in y
   */
  void moveBy(int dx, int dy);

  /**
   * Invalidates the figure. This method informs the listeners that the figure's
   * current display box is invalid and should be redrawn.
   */
  void invalidate();

  /**
   * Informs that a figure has changed its display box. This method also
   * triggers an update call for its registered observers.
   */
  void changed();

  /**
   * Adds a listener for this figure.
   * 
   * @param l
   *          the listener to associate with this figure
   */
  void addFigureChangeListener(FigureChangeListener l);

  /**
   * Removes a listener for this figure.
   * 
   * @param l
   *          the listener to remove this figure
   */
  void removeFigureChangeListener(FigureChangeListener l);
}
