package minidraw.standard;

import java.awt.*;

import minidraw.framework.DrawingEditor;

/** A drawing view that paints the background with a fixed image */

public class StdViewWithBackground extends StandardDrawingView {

  private static final long serialVersionUID = 7329205003806037431L;
  Image background;

  /**
   * Create a DrawingView that features a graphical image as background for
   * figures.
   * 
   * @param editor
   *          the editor to be associated with
   * 
   * @param backgroundName
   *          name of an image previously loaded by the image manager.
   */
  public StdViewWithBackground(DrawingEditor editor, String backgroundName) {
    super(editor);
    ImageManager im = ImageManager.getSingleton();
    this.background = im.getImage(backgroundName);
  }

  /**
   * Create a DrawingView that features a graphical image as background for
   * figures.
   * 
   * @param editor
   *          the editor to be associated with
   * 
   * @param background
   *          the image to use as background
   */
  public StdViewWithBackground(DrawingEditor editor, Image background) {
    super(editor);
    this.background = background;
  }

  @Override
  public void drawBackground(Graphics g) {
    g.drawImage(background, 0, 0, null);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(background.getWidth(null), background.getHeight(null));
  }

  @Override
  public Dimension getMinimumSize() {
    return getPreferredSize();
  }

}
