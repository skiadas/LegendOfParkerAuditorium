package minidraw.framework;

/**
 * The DrawingEditor is the interface of the "main" class of any minidraw
 * application. It must instantiate all relevant parts of the framework as well
 * as open the relevant graphical user interface windows.
 * 
 * It is also the Mediator of the Mediator pattern that allows the different
 * implementation of MiniDraw roles to access each other. It is, however, the
 * object server variant as it does not centralize control.
 * 
 * The default implementation, MiniDrawApplication, should suffice for almost
 * any need as it is highly configurable via the Factory interface.
 * 
 * Responsibilities: A) Main class of a minidraw application, that is the editor
 * must instantiate all parts of the application. B) Open a window to become
 * visible. B) Acts as Mediator for the various parts of MiniDraw. C) Allow
 * changing the active tool. D) Allow displaying a message in the status bar.
 * 
 * Release history: See the 'version-history.md' in the /minidraw folder.
 * 
 */

/*
 * Version 1.8 notes.
 * 
 * The update sequence when moving a figure is this: a) moveBy invokes
 * 'invalidate()' twice and 'changed()' once. b) invalidate() notifies
 * FigureListeners of 'figureInvalidated() while changed() notifies of
 * 'figureChanged()' c) StandardDrawing implements figureInvalidated() but not
 * figureChanged(); the latter was instead handled by the inherited method from
 * CompositeFigure. d) StandardDrawing's figureInvalidated() notifies all
 * DrawingListeners of DrawingInvalidated but CompositeFigure's implementation
 * of figureChanged() is empty! e) Thus DrawingView is only notified of
 * invalidation (adds dirty rectangles) but never changes (i.e. force the
 * repaint).
 * 
 * How come anything was then redrawn?
 * 
 * Because StandardDrawingView invokes 'checkDamage()' after every mouse event
 * which calls the requestUpdate() method in StandardDrawing which force
 * drawingRequestUpdate calls to all views - which then again invokes
 * repairDamage() that repaints.
 * 
 * The change that has been made: a) all checkDamage() removed from
 * StandardDrawingView's mouse event methods b) StandardDrawingView's
 * figureChanged() method now fire DrawingRequestUpdate notifications
 * 
 * Upon testing defects were identified in StandardSelectionHandler: calls to
 * figure.invalidate() changed to figure.changed() to force the proper repaint.
 * 
 */

public interface DrawingEditor {

  /** Version of Minidraw. */
  public static final String VERSION = "1.13";

  /**
   * get the drawing this editor is associated with
   * 
   * @return the associated drawing
   */
  public Drawing drawing();

  /**
   * get the view associated with this editor
   * 
   * @return the associated view
   */
  public DrawingView view();

  /**
   * set a new tool to use in this editor.
   *
   * @param t
   *          the tool to use. t is not allowed to be null. Use a null tool
   *          instead.
   */
  public void setTool(Tool t);

  /**
   * return the tool presently set
   * 
   * @return tool currently set
   */
  public Tool tool();

  /** open the editor. This makes the editor visible */
  public void open();

  /**
   * show a status message to the user
   * 
   * @param message
   *          the message to show in the bottom text field
   */
  public void showStatus(String message);
}
