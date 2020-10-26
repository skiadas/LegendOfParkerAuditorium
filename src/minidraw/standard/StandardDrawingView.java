package minidraw.standard;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import minidraw.framework.*;

/**
 * Standard implementation of the DrawingView role in MiniDraw, just giving an
 * empty view of the specificed size.
 * 
 * Most code is copied from JHotDraw 5.1
 */
public class StandardDrawingView extends JPanel
    implements DrawingView, MouseListener, MouseMotionListener, KeyListener {

  private static final long serialVersionUID = 3722170409196832977L;

  /**
   * the object server providing yellow page access to all relevant parts of the
   * editor
   */
  private DrawingEditor editor;

  /**
   * the dirty rectangle of this view. it basically accumulates all rectangles
   * that have seen some change since the last repaint
   */
  private Rectangle dirtyRectangle;

  /** Create a drawing view associated with the given editor
   * @param editor the editor this view is associated with
   */
  public StandardDrawingView(DrawingEditor editor) {
    this(editor, new Dimension(600, 400));
  }

  /** Create a drawing view of a given size.
   * 
   * @param editor the editor this view is associated with
   * @param size the size of the windows
   */
  public StandardDrawingView(DrawingEditor editor, Dimension size) {
    this.editor = editor;
    addMouseListener(this);
    addMouseMotionListener(this);
    addKeyListener(this);

    dirtyRectangle = null;

    // register this view as listener on change events from the
    // model
    if (editor.drawing() == null) {
      throw new RuntimeException("StandardDrawingView: Drawing undefined!");
    }
    editor.drawing().addDrawingChangeListener(this);

    setSize(size);
  }

  /** Return the associated editor
   * 
   * @return the editor
   */
  public DrawingEditor editor() {
    return editor;
  }

  @Override
  public synchronized void checkDamage() {
    editor().drawing().requestUpdate();
  }

  private synchronized void repairDamage() {
    if (dirtyRectangle != null) {
      repaint(dirtyRectangle.x, dirtyRectangle.y, dirtyRectangle.width,
          dirtyRectangle.height);
      dirtyRectangle = null;
    }

    // the hard coded bit is just to invoke repaint()
    // repaint();
  }

  @Override
  public void paint(Graphics g) {

    drawAll(g);
  }

  @Override
  public void drawAll(Graphics g) {
    drawBackground(g);
    drawDrawing(g);
    drawSelectionHighlight(g);
    drawOverlay(g);
  }

  @Override
  public void drawDrawing(Graphics g) {
    Drawing d = editor.drawing();
    d.lock();
    Iterator<Figure> i = d.iterator();
    while (i.hasNext()) {
      Figure f = i.next();
      f.draw(g);
      /*
       * Uncomment for slowing down drawing to test for concurrent modification
       * failures try { Thread.sleep(300); } catch ( InterruptedException e ) {}
       */
    }
    d.unlock();
  }

  @Override
  public void drawBackground(Graphics g) {
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0, getBounds().width, getBounds().height);
  }

  @Override
  public void drawSelectionHighlight(Graphics g) {
    List<Figure> l = editor().drawing().selection();
    // TODO: fix this fast hack
    if (l.size() > 1) {
      g.setColor(Color.red);
      Rectangle r;
      for (Figure f : l) {
        r = f.displayBox();
        g.drawRect(r.x, r.y, r.width - 1, r.height - 1);
      }
    }
  }

  @Override
  public void drawOverlay(Graphics g) {
  }

  @Override
  public Dimension getPreferredSize() {
    return getSize();
  }

  @Override
  public Dimension getMinimumSize() {
    return getPreferredSize();
  }

  /**
   * Constrains a point to the current grid.
   * 
   * @param p
   *          the point which may be constrained to be inside our view port
   * @return the constrained point
   */
  protected Point constrainPoint(Point p) {
    // constrain to view size
    Dimension size = getSize();
    // p.x = Math.min(size.width, Math.max(1, p.x));
    // p.y = Math.min(size.height, Math.max(1, p.y));
    p.x = range(1, size.width, p.x);
    p.y = range(1, size.height, p.y);

    return p;
  }

  /**
   * Constrains a value to the given range.
   * 
   * @param min
   *          minimum value
   * @param max
   *          maximum value
   * @param the
   *          value to constrain
   * 
   * @return the constrained value
   */
  private static int range(int min, int max, int value) {
    if (value < min) {
      value = min;
    }
    if (value > max) {
      value = max;
    }
    return value;
  }

  // === Mouse event handling
  protected Point fLastClick;

  /**
   * Handles mouse down events. The event is delegated to the currently active
   * tool.
   * 
   * @param e
   *          the mouse event to handle
   */
  @Override
  public void mousePressed(MouseEvent e) {
    requestFocus();
    Point p = constrainPoint(new Point(e.getX(), e.getY()));
    fLastClick = new Point(e.getX(), e.getY());
    editor.tool().mouseDown(e, p.x, p.y);
  }

  /**
   * Handles mouse drag events. The event is delegated to the currently active
   * tool.
   * 
   * @param e
   *          the mouse event to handle
   */
  @Override
  public void mouseDragged(MouseEvent e) {
    Point p = constrainPoint(new Point(e.getX(), e.getY()));
    editor.tool().mouseDrag(e, p.x, p.y);
  }

  /**
   * Handles mouse move events. The event is delegated to the currently active
   * tool.
   * 
   * @param e
   *          the mouse event to handle
   */
  @Override
  public void mouseMoved(MouseEvent e) {
    editor.tool().mouseMove(e, e.getX(), e.getY());
  }

  /**
   * Handles mouse up events. The event is delegated to the currently active
   * tool.
   * 
   * @param e
   *          the mouse event to handle
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    Point p = constrainPoint(new Point(e.getX(), e.getY()));
    editor.tool().mouseUp(e, p.x, p.y);
  }

  // These listener methods are not interesting.
  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    editor.tool().keyDown(e, e.getKeyCode());
  }

  @Override
  public void drawingInvalidated(DrawingChangeEvent e) {
    Rectangle r = e.getInvalidatedRectangle();
    if (dirtyRectangle == null) {
      dirtyRectangle = r;
    } else {
      dirtyRectangle.add(r);
    }
  }

  @Override
  public void drawingRequestUpdate(DrawingChangeEvent e) {
    repairDamage();
  }
}
