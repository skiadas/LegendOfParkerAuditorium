package minidraw.framework;

import java.util.EventListener;

/**
 * The Observer role, a listener interested in Figure changes.
 *
 */
public interface FigureChangeListener extends EventListener {

  /**
   * Sent when an area is invalid
   * 
   * @param e
   *          the event containing information about the change
   */
  public void figureInvalidated(FigureChangeEvent e);

  /**
   * Sent when a figure changed
   * 
   * @param e
   *          the event containing information about the change
   */
  public void figureChanged(FigureChangeEvent e);

  /**
   * Sent when a figure was removed
   * 
   * @param e
   *          the event containing information about the change
   */
  public void figureRemoved(FigureChangeEvent e);

  /**
   * Sent when requesting to remove a figure.
   * 
   * @param e
   *          the event containing information about the change
   */
  public void figureRequestRemove(FigureChangeEvent e);

  /**
   * Sent when an update should happen.
   * 
   * @param e
   *          the event containing information about the change
   *
   */
  public void figureRequestUpdate(FigureChangeEvent e);
}
