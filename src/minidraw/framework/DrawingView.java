package minidraw.framework;

import java.awt.Graphics;

/**
 * The graphical output role of MiniDraw, representing the View role of the MVC
 * pattern.
 * 
 * Responsibilities: A) To draw all contents of its associated Drawing (model).
 * B) To draw additional graphics such as background and overlay.
 */

public interface DrawingView extends DrawingChangeListener {

  /**
   * Check if any damage has been made to this view and repaint if this is the
   * case.
   */
  public void checkDamage();

  /**
   * Draws the contents of the drawing view. The view has four layers:
   * background, drawing, highlight, and overlay. The layers are drawn in back
   * to front order.
   * 
   * @param g
   *          the graphics component to draw on
   */
  public void drawAll(Graphics g);

  /**
   * Draws the contents of the associated Drawing.
   * 
   * @param g
   *          the graphics component to draw on
   */
  public void drawDrawing(Graphics g);

  /**
   * Draws a background behind the Drawing's contents.
   * 
   * @param g
   *          the graphics component to draw on
   */
  public void drawBackground(Graphics g);

  /**
   * Draws highlight selection graphics . If figures are selected in the
   * associated Drawing instance then they are shown using the associated
   * SelectionHighlightStrategy.
   * 
   * @param g
   *          the graphics component to draw on
   */
  public void drawSelectionHighlight(Graphics g);

  /**
   * Draws the overlay. This graphics is overlaid all other graphics:
   * background, figures, etc. It is meant to provide borders that may partially
   * overwrite the underlying figures. If you use a fill area image, it must use
   * a transparent color in order for background graphics to appear.
   * 
   * @param g
   *          the graphics component to draw on
   */
  public void drawOverlay(Graphics g);

  /**
   * Get the graphics context of this view
   *
   * @return the graphics contents of this view.
   */
  public Graphics getGraphics();

}
