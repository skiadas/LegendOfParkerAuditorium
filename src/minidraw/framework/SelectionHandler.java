package minidraw.framework;

import java.util.List;

/**
 * The selection handler role defines the interface for the responsibility of
 * managing a drawing's multiple figure selection mechanism.
 * 
 * Responsibility A) Act as a collection of figures presently selected in a
 * drawing. B) Support adding, removing, and state toggling figures C) Any
 * adding or removing of a figure MUST be followed by a call to the figure's
 * 'changed' method in order for the views to repaint the figure correctly! See
 * StandardSelectionHandler.
 */
public interface SelectionHandler {
  /**
   * Get an iterator over all selected figures
   * 
   * @return a list of all figures selected
   */
  public List<Figure> selection();

  /**
   * Adds a figure to the current selection.
   *
   * @param figure
   *          the figure to add to the selection
   */
  public void addToSelection(Figure figure);

  /**
   * Removes a figure from the selection.
   *
   * @param figure
   *          the figure to remove
   */
  public void removeFromSelection(Figure figure);

  /**
   * If a figure isn't selected it is added to the selection. Otherwise it is
   * removed from the selection.
   *
   * @param figure
   *          the figure to toggle
   */
  public void toggleSelection(Figure figure);

  /**
   * Clears the current selection.
   */
  public void clearSelection();
}
