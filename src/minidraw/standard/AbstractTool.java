package minidraw.standard;

import java.awt.event.*;

import minidraw.framework.*;

/**
 * AbstractTool. Provides some rudimentary behavior for other tools to
 * override.
 *
 * Modeled over the schema from JHotDraw.
 *
 */

public abstract class AbstractTool implements Tool {

  protected DrawingEditor editor;
  protected int fAnchorX, fAnchorY;

  /**
   * Abstract base class for all tools.
   * 
   * @param editor
   *          the editor (object server) that this tool is associated with.
   */
  public AbstractTool(DrawingEditor editor) {
    this.editor = editor;
  }

  @Override
  public void mouseDown(MouseEvent e, int x, int y) {
    fAnchorX = x;
    fAnchorY = y;
  }

  @Override
  public void mouseDrag(MouseEvent e, int x, int y) {
  }

  @Override
  public void mouseUp(MouseEvent e, int x, int y) {
  }

  @Override
  public void mouseMove(MouseEvent evt, int x, int y) {
  }

  @Override
  public void keyDown(KeyEvent evt, int key) {
  }

  public DrawingEditor editor() {
    return editor;
  }

}
