package minidraw.standard.handlers;

//import javax.swing.*;
import java.awt.Rectangle;
import java.util.*;

import minidraw.framework.*;

/**
 * The Subject role of the observer pattern for DrawingChangeListeners.
 * 
 * You can use this default implementation in all objects that must handle
 * DrawingChangeListeners.
 * 
 */

public class StandardDrawingChangeListenerHandler
    implements DrawingChangeListenerHandler {

  /** list over all associated listeners */
  protected List<DrawingChangeListener> fListeners;

  public StandardDrawingChangeListenerHandler() {
    fListeners = new ArrayList<DrawingChangeListener>();
  }

  /**
   * Adds a listener for this drawing.
   * 
   * @param listener
   *          the listener to add
   */
  @Override
  public void addDrawingChangeListener(DrawingChangeListener listener) {
    fListeners.add(listener);
  }

  /**
   * Removes a listener from this drawing.
   * 
   * @param listener
   *          the listener to remove
   */
  @Override
  public void removeDrawingChangeListener(DrawingChangeListener listener) {
    fListeners.remove(listener);
  }

  /**
   * Fire a 'drawingInvalidated' event
   * 
   * @param source
   *          the drawing this event stems from
   * @param r the rectangle in need of redrawing
   */
  public void fireDrawingInvalidated(Drawing source, Rectangle r) {
    for (DrawingChangeListener l : fListeners) {
      l.drawingInvalidated(new DrawingChangeEvent(source, r));
    }
  }

  /**
   * Fire a 'drawingUpdate' event
   * 
   * @param source
   *          the drawing this event stems from
   */
  public void fireDrawingRequestUpdate(Drawing source) {
    for (DrawingChangeListener l : fListeners) {
      l.drawingRequestUpdate(new DrawingChangeEvent(source, null));
    }
  }
}
