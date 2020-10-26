package minidraw.framework;

import java.util.EventListener;

/**
 * DrawingChangeListener defines the observer role of an object listening to
 * DrawingChangeEvents from a Drawing.
 */
public interface DrawingChangeListener extends EventListener {

  /**
   * Called when a drawing has areas that needs to be redrawn.
   * 
   * @param e
   *          the event containing information about the change
   */
  public void drawingInvalidated(DrawingChangeEvent e);

  /**
   * Called when the drawing wants to be refreshed
   * 
   * @param e
   *          the event containing information about the change
   */
  public void drawingRequestUpdate(DrawingChangeEvent e);
}
