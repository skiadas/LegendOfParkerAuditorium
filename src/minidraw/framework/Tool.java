package minidraw.framework;

import java.awt.event.*;

/**
 * Tool is the Controller role in the MVC pattern for MiniDraw. A tool must
 * process all user input events and translate them into modifications of the
 * Drawing (= model role).
 *
 * The interface follows the schema defined in JHotDraw.
 */
public interface Tool {
  /**
   * Handles mouse down events in the drawing view.
   *
   * @param e
   *          the original mouse event from AWT
   * @param x
   *          the x coordinate of the mouse cursor
   * @param y
   *          the y coordinate of the mouse cursor
   */
  public void mouseDown(MouseEvent e, int x, int y);

  /**
   * Handles mouse drag events in the drawing view (while mouse button is down).
   *
   * @param e
   *          the original mouse event from AWT
   * @param x
   *          the x coordinate of the mouse cursor
   * @param y
   *          the y coordinate of the mouse cursor
   */
  public void mouseDrag(MouseEvent e, int x, int y);

  /**
   * Handles mouse up in the drawing view.
   *
   * @param e
   *          the original mouse event from AWT
   * @param x
   *          the x coordinate of the mouse cursor
   * @param y
   *          the y coordinate of the mouse cursor
   */
  public void mouseUp(MouseEvent e, int x, int y);

  /**
   * Handles mouse moves (while the mouse button is up).
   *
   * @param e
   *          the original mouse event from AWT
   * @param x
   *          the x coordinate of the mouse cursor
   * @param y
   *          the y coordinate of the mouse cursor
   */
  public void mouseMove(MouseEvent e, int x, int y);

  /**
   * Handles key down events in the drawing view (KEY_PRESSED events).
   *
   * @param e
   *          the original key event from AWT
   * @param key
   *          the AWT keycode, the integer code for the actual key on the
   *          keyboard; consult
   */
  public void keyDown(KeyEvent e, int key);
}
