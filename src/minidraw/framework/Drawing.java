package minidraw.framework;

import java.util.Iterator;

/**
 * Drawing is the model role of the MVC pattern, a container of Figure instances
 * in MiniDraw.
 * 
 * Responsibilities: A) Maintain the set of figures (add,remove). B) Maintain a
 * selection of a subset of these C) Serve as Subject in observer pattern and
 * notify DrawingListeners when changes to any figure happens. D) Serve as
 * Observer in the observer pattern as it observes all changes in its associated
 * Figures.
 * 
 * Copyright 2010 Henrik Baerbak Christensen
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Implementation notes: Much of the interface specification is copied literally
 * from JHotDraw 5.1 however an effort has been made to repartition the
 * interface into smaller interfaces: SelectionHandler,
 * DrawingChangeListenerHandler.
 */
public interface Drawing extends SelectionHandler, FigureChangeListener,
    DrawingChangeListenerHandler {

  /**
   * Adds a figure and sets its container to refer to this drawing. If you have
   * several threads that may call add, scope it by the lock/unlock methods.
   *
   * @param figure
   *          the figure to add
   * @return the figure that was inserted.
   */
  public Figure add(Figure figure);

  /**
   * Removes a figure. If you have several threads that may call add, scope it
   * by the lock/unlock methods.
   *
   * @param figure
   *          the figure to remove
   * @return the figure removed
   */
  public Figure remove(Figure figure);

  /**
   * Return an iterator over drawing's contents.
   *
   * @return an iterator over all figures in this drawing.
   */
  public Iterator<Figure> iterator();

  /**
   * Find and return the figure covering position (x,y).
   *
   * @param x
   *          X coordinate
   * @param y
   *          Y coordinate
   * @return the figure at position (x,y) or null if there is not any there.
   */
  public Figure findFigure(int x, int y);

  /**
   * Request update: force a "repaint" event to all associated listeners on this
   * drawing
   */
  public void requestUpdate();

  /**
   * Acquires a lock on the list of figures in this drawing. If you add or
   * remove figures to a drawing when other threads are potentially iterating
   * over the very same list (as AWT/Swing does when redrawing!) you have to
   * scope the add/remove by a lock/unlock pair. For instance like this:
   *
   * drawing.lock(); drawing.add( aFigure ); drawing.unlock();
   *
   * Otherwise you may get a ConcurrentModificationException.
   */
  public void lock();

  /**
   * Releases the drawing lock. See the discussion for the lock() method.
   */
  public void unlock();
}
