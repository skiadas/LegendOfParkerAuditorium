package minidraw.framework;

import java.awt.Rectangle;
import java.util.EventObject;

/**
 * FigureChange event passed to FigureChangeListeners.
 *
 */
public class FigureChangeEvent extends EventObject {
  private static final long serialVersionUID = 5562263038057325120L;
  private Rectangle rect;
  private static final Rectangle emptyRect = new Rectangle(0, 0, 0, 0);

  /**
   * Constructs an event for the given source Figure. The rectangle is the area
   * to be invalidated.
   * 
   * @param source
   *          the figure that this event originates from
   * @param r
   *          the rectangle which is invalidated (needs repainting)
   */
  public FigureChangeEvent(Figure source, Rectangle r) {
    super(source);
    rect = r;
  }

  /**
   * Constructs an event for the given source Figure with an empty rectangle.
   * 
   * @param source
   *          the figure that this event originates from
   */
  public FigureChangeEvent(Figure source) {
    super(source);
    rect = emptyRect;
  }

  /**
   * Gets the changed figure.
   * 
   * @return the figure this event stems from
   */
  public Figure getFigure() {
    return (Figure) getSource();
  }

  /**
   * Gets the changed rectangle.
   * 
   * @return the invalidated/dirty rectangle that needs repainting
   */
  public Rectangle getInvalidatedRectangle() {
    return rect;
  }
}
