package minidraw.standard;

import java.awt.*;

/**
 * ImageFigure is a figure showing a graphical
 * image. The image must be read by the ImageManager.
 * 
 * Responsibility: A Figure showing an Image.
 * 
 * 
 */

public class ImageFigure extends AbstractFigure {

  protected Image fImage;
  protected Rectangle fDisplayBox;

  /**
   * Create a null image figure where the image and position is given later by
   * the set method
   */
  public ImageFigure() {
    fImage = null;
    fDisplayBox = new Rectangle(0, 0, 0, 0);
  }

  /**
   * Change the image and position of this image figure
   * 
   * @param img
   *          the image to set
   * @param p
   *          the position of the figure to set
   */
  public void set(Image img, Point p) {
    fImage = img;
    setDisplayBox(p);
  }

  /**
   * Change the image (based on the string used in the image manager) and
   * position of this image figure.
   * 
   * @param imagename
   *          the name of image to set
   * @param p
   *          the position of the figure to set
   */
  public void set(String imagename, Point p) {
    ImageManager im = ImageManager.getSingleton();
    fImage = im.getImage(imagename);
    setDisplayBox(p);
  }

  /**
   * Create an image figure from a given image
   * 
   * @param img
   *          the image to set
   * @param p
   *          the position of the figure to set
   */
  public ImageFigure(Image img, Point p) {
    fImage = img;
    setDisplayBox(p);
  }

  /*
   * Create an image figure from a previously loaded image by the image manager.
   * 
   * @param imagename the name of image to set
   * 
   * @param p the position of the figure to set
   */
  public ImageFigure(String imagename, Point p) {
    ImageManager im = ImageManager.getSingleton();
    fImage = im.getImage(imagename);
    setDisplayBox(p);
  }

  /** Change the display box
   * 
   * @param origin position to move figure to
   */
  private void setDisplayBox(Point origin) {
    willChange();
    fDisplayBox = new Rectangle(origin.x, origin.y, 0, 0);
    fDisplayBox.width = fImage.getWidth(null);
    fDisplayBox.height = fImage.getHeight(null);
    changed();
  }

  @Override
  public void draw(Graphics g) {
    if (fImage != null) {
      g.drawImage(fImage, fDisplayBox.x, fDisplayBox.y, fDisplayBox.width,
          fDisplayBox.height, null);
    }
  }

  @Override
  public Rectangle displayBox() {
    return fDisplayBox;
  }

  @Override
  protected void basicMoveBy(int x, int y) {
    fDisplayBox.translate(x, y);
  }
}
