package minidraw.standard;

import java.awt.Rectangle;
import java.util.*;

import minidraw.framework.*;

/**
 * Abstract Figure: Base implementation of some Figure behaviour.
 * Responsibilities: A) All observer role "Subject" base functionality is
 * provided.
 *
 * Code partly copied from JHotDraw 5.1.
 *
 */

public abstract class AbstractFigure implements Figure {

  /** the listeners of this figure */
  List<FigureChangeListener> listenerList;

  /** Base construction of a figure */
  public AbstractFigure() {
    listenerList = new ArrayList<FigureChangeListener>();
  }

  @Override
  public void moveBy(int dx, int dy) {
    willChange();
    basicMoveBy(dx, dy);
    changed();
  }

  /**
   * Informes that a figure is about to change something that affects the
   * contents of its display box.
   */
  protected void willChange() {
    invalidate();
  }

  @Override
  public void invalidate() {
    for (FigureChangeListener l : listenerList) {
      Rectangle r = (Rectangle) displayBox().clone();
      FigureChangeEvent e = new FigureChangeEvent(this, r);
      l.figureInvalidated(e);
    }
  }

  /**
   * This is the hook method to be overridden when a figure moves. Do not call
   * directly, instead call 'moveBy'.
   * 
   * @param dx
   *          the delta to move in x direction
   * @param dy
   *          the delta to move in y direction
   */
  protected abstract void basicMoveBy(int dx, int dy);

  @Override
  public void changed() {
    invalidate();
    for (FigureChangeListener l : listenerList) {
      FigureChangeEvent e = new FigureChangeEvent(this);
      l.figureChanged(e);
    }
  }

  @Override
  public void addFigureChangeListener(FigureChangeListener l) {
    listenerList.add(l);
  }

  @Override
  public void removeFigureChangeListener(FigureChangeListener l) {
    listenerList.remove(l);
  }

}
