package minidraw.standard;

import java.awt.*;

import javax.swing.*;

import minidraw.framework.*;

/**
 * MiniDraw Application is a standard implementation of the DrawingEditor role.
 * It connects MiniDraw with Swing as it also fulfill the JFrame role. You have
 * to provide it with an abstract factory for configuring the variability points
 * of the application. 
 * 
 * Implementation note: MiniDrawApplication ASSUMES that the DrawingView
 * returned from the factory is a subclass of JPanel. If not you have to
 * override the createContents method to handle this!
 */

public class MiniDrawApplication extends JFrame implements DrawingEditor {

  private static final long serialVersionUID = -5340338919961729143L;

  /** the view that this application displays */
  protected DrawingView fView;

  /** the drawing that this application uses */
  protected Drawing fDrawing;

  /** the image manager of an application */
  protected ImageManager fImageManager;

  /** the tool being used by this editor */
  protected Tool fTool;

  /** abstract factory to make services */
  protected Factory factory;

  /** the status field */
  protected JTextField statusField;

  /**
   * Construct a minidraw editor that also acts as the JFrame application
   * window.
   * 
   * @param title
   *          the title to put in the frame bar
   * @param f
   *          the factory to produce internal handlers
   */
  public MiniDrawApplication(String title, Factory f) {
    super(title);
    try {
      // Set System L&F
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      // Ignore exceptions as they just mean
      // we run with the defaults
    }

    fImageManager = new ImageManager(this);

    // create the (default) controller in MVC
    fTool = new NullTool();

    factory = f;

    setLocation(100, 20);
    setFrameCloseOperation();
  }

  /**
   * define how the MiniDraw application responds to the user clicking the
   * window close button. Defaults to exiting the application. Override if you
   * need special handling like disconnecting a socket.
   */
  protected void setFrameCloseOperation() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void open() {
    Container pane = getContentPane();

    // create the underlying model in the MVC triad
    fDrawing = factory.createDrawing(this);

    // create a view for the MVC
    fView = factory.createDrawingView(this);
    statusField = factory.createStatusField(this);

    JPanel panel = createContents(fView, statusField);

    pane.add(panel);

    pack();
    setVisible(true);
  }

  /**
   * given a drawing view, return the JPanel that encapsulate it.
   * 
   * @param dv
   *          the drawing view to insert in the return JPanel
   * 
   * @param tf
   *          the text field the text field (may be null) to insert in the
   *          JPanel; if not null it will be a border layout with the text field
   *          in the south layout
   * 
   * @return the JPanel with the given elements in proper layout
   */
  protected JPanel createContents(DrawingView dv, JTextField tf) {
    if (tf == null) {
      return (JPanel) dv;
    }
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(BorderLayout.CENTER, (JPanel) dv);
    p.add(BorderLayout.SOUTH, statusField);
    return p;
  }

  /**
   * set a tool for this editor.
   * 
   * @param t
   *          the tool to set. PRECondition: t must never be null; if no tool is
   *          wanted, then set it to the null tool
   */
  @Override
  public void setTool(Tool t) {
    fTool = t;
  }

  @Override
  public Tool tool() {
    return fTool;
  }

  @Override
  public DrawingView view() {
    return fView;
  }

  @Override
  public Drawing drawing() {
    return fDrawing;
  }

  @Override
  public void showStatus(String message) {
    if (statusField != null) {
      statusField.setText(message);
    }
    // else status messages are simply ignored.
  }
}
