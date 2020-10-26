package minidraw.standard.handlers;

import java.awt.event.*;

import minidraw.framework.*;
import minidraw.standard.AbstractTool;

/**
 * A DragTracker tool moves the set of figures defined by the drawing's
 * selection container (= the figures presently selected).
 * 
 * This code is partially copied from JHotDraw 5.1
 */

public class DragTracker extends AbstractTool implements Tool {

  private Figure figure;
  private int fLastX, fLastY; // previous mouse position

  public DragTracker(DrawingEditor editor, Figure figure) {
    super(editor);
    this.figure = figure;

  }

  @Override
  public void mouseDown(MouseEvent e, int x, int y) {
    super.mouseDown(e, x, y);
    fLastX = x;
    fLastY = y;

    Drawing model = editor().drawing();

    if (e.isShiftDown()) {
      model.toggleSelection(figure);
    } else if (!model.selection().contains(figure)) {
      model.clearSelection();
      model.addToSelection(figure);
    }
  }

  @Override
  public void mouseDrag(MouseEvent e, int x, int y) {
    for (Figure f : editor().drawing().selection()) {
      f.moveBy(x - fLastX, y - fLastY);
    }
    fLastX = x;
    fLastY = y;
  }

  @Override
  public void keyDown(KeyEvent evt, int key) {
  }
}
