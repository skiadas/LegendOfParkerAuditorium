package minidraw.framework;

import javax.swing.JTextField;

/**
 * Abstract factory for creating implementations of the central roles used in
 * MiniDraw.
 * 
 * Responsibilities: 1) Create, upon request, instances of the roles that the
 * DrawingEditor needs.
 */
public interface Factory {

  /**
   * Create the drawing view (View role of the MVC pattern).
   *
   * @param editor
   *          the editor that the view will be associated with.
   * @return a new drawingview
   */
  public DrawingView createDrawingView(DrawingEditor editor);

  /**
   * Create the drawing (Model role of the MVC pattern).
   *
   * @param editor
   *          the editor that the view will be associated with
   * @return a new drawing
   */
  public Drawing createDrawing(DrawingEditor editor);

  /**
   * Create the text field used for messages.
   *
   * @param editor
   *          the editor that the view will be associated with
   * @return a new status field or null in case no status field is needed.
   */
  public JTextField createStatusField(DrawingEditor editor);
}
