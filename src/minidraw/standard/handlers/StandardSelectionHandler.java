package minidraw.standard.handlers;

import java.util.*;

import minidraw.framework.*;

/**
 * The standard selection handler contains default implementation of managing a
 * drawing's multiple figure selection mechanism.
 * 
 * Responsibility A) Act as a collection of figures presently selected in a
 * drawing.
 * 
 */

public class StandardSelectionHandler implements SelectionHandler {

  /** list of all figures currently selected */
  protected List<Figure> selectionList;

  public StandardSelectionHandler() {
    selectionList = new ArrayList<Figure>();
  }

  /**
   * Get an iterator over all selected figures
   */
  @Override
  public List<Figure> selection() {
    return selectionList;
  }

  /**
   * Adds a figure to the current selection.
   */
  @Override
  public void addToSelection(Figure figure) {
    if (!selectionList.contains(figure)) {
      selectionList.add(figure);
      figure.changed();
    }
  }

  /**
   * Removes a figure from the selection.
   */
  @Override
  public void removeFromSelection(Figure figure) {
    if (selectionList.contains(figure)) {
      selectionList.remove(figure);
      figure.changed();
    }
  }

  /**
   * If a figure isn't selected it is added to the selection. Otherwise it is
   * removed from the selection.
   */
  @Override
  public void toggleSelection(Figure figure) {
    if (selectionList.contains(figure)) {
      removeFromSelection(figure);
    } else {
      addToSelection(figure);
      figure.changed();
    }
  }

  /**
   * Clears the current selection.
   */
  @Override
  public void clearSelection() {
    for (Figure f : selectionList) {
      f.changed();
    }
    selectionList = new ArrayList<Figure>();
  }
}
