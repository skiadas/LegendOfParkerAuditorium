package minidraw.standard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

/**
 * ImageManager is a singleton class that acts as a centralized database of all
 * images to be used in a MiniDraw application. It takes care of automatically
 * loading images to be used in the JHotDraw framework and builds a Map that
 * maps from image names (without extension) to image instances. Images in GIF,
 * PNG, and JPG formats are supported.
 * 
 * <p>
 * As the ImageManager is a singleton class you access it using
 * <tt>ImageManager.getSingleton()</tt>. The MinimalApplication creates the
 * ImageManager automatically.
 * <p>
 *   Updated in MiniDraw v 1.10 to use ImageIO which requires Java 8.
 * </p>
 */

public class ImageManager {
  /* In the original Ant based code, images are put into a root
   * folder named /resource
   */
  private static final String RESOURCE_PATH_ANT = "/resource/";

  /* To support gradle builds, also look for stuff in
   * /src/main/resources/minidraw/ folder of gradle, which maps simply
   * to /minidraw once build using gradle.
   */
  private static final String RESOURCE_PATH_GRADLE = "/minidraw-images";

  // Will be set after construction to one of the two above paths
  private String resourceFolder;
  // Will be set after construction to the full URL of the resource folder
  private URL resourceRootURL;

  private static Component aComponent;

  private Map<String, Image> name2Image;

  public static ImageManager singleton;

  /** Construct the ImageManager. The
   * parameter is legacy as of version 1.10
   * @param c legacy, can be null.
   */
  ImageManager(Component c) {
    aComponent = c;
    registerAllImages();
    singleton = this;
  }

  ImageManager() {
    this(null);
  }

  public Image getImage(String shortName) {
    Image img = name2Image.get(shortName);
    if (img == null) {
      throw new RuntimeException("ImageManager: No image named '" + shortName
              + "' has been found in " + resourceRootURL + " folder.");
    }
    return img;
  }

  public static ImageManager getSingleton() {
    if (singleton == null) {
      throw new RuntimeException("getSingleton() invoked before ImageManger "
              + "has been instantiated.");
    }
    return singleton;
  }

  /** load all supported image files in resource folder into the image manager. */
  private void registerAllImages() {
    name2Image = new Hashtable<String, Image>();
    findRootFolderForImagesOrFail();

    try {
      String[] imageFileNameArray = getAllImagesInResourceFolder();
      readAllImages(imageFileNameArray);
    } catch (IOException e) {
      throw new RuntimeException("IOException caught during image load: " + e);
    }
  }

  private void readAllImages(String[] imageFileNameArray) throws IOException {
    for (String s : imageFileNameArray) {
      // Load and register the image
      Image img = loadImage(s, resourceRootURL);
      if (img == null) {
        throw new RuntimeException(
                "ImageManager: Did not find image named " + s
                        + ", was looking in " + resourceRootURL);
      }
      String filenameNoExtension = s.substring(0, s.length() - 4);
      name2Image.put(filenameNoExtension, img);
    }
  }

  private String[] getAllImagesInResourceFolder() {
    String[] imageFileNameArray;// Get the directory

    String resourcePath;
    try {
      resourcePath = URLDecoder.decode(resourceRootURL.getPath(), "UTF-8");
    }
    catch (UnsupportedEncodingException e) {
      return null; // "UTF-8" is valid, so this should never happen
    }
    File dir = new File(resourcePath);

    // create a filter to find .GIF and other supported files.
    FilenameFilter filter = new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        return name.endsWith(".gif") || name.endsWith(".GIF")
                || name.endsWith(".png") || name.endsWith(".PNG")
                || name.endsWith(".jpg") || name.endsWith(".JPG");
      }
    };
    // Retrieve array of gif file names in resource folder
    imageFileNameArray = dir.list(filter);
    return imageFileNameArray;
  }

  /** Test the two possible resource folders and set
   * internal state accordingly. If neither are found,
   * throw a runtime exceptions.
   */
  private void findRootFolderForImagesOrFail() {
    // Try the two possible paths for loading graphics
    resourceFolder = RESOURCE_PATH_ANT;
    resourceRootURL = getClass().getResource(resourceFolder);
    if (resourceRootURL == null) {
      resourceFolder = RESOURCE_PATH_GRADLE;
      resourceRootURL = getClass().getResource(resourceFolder);
      if (resourceRootURL == null) {
        throw new RuntimeException(
                "ImageManager: Cannot find minidraw images in folder '" + RESOURCE_PATH_ANT + " or "
                        + RESOURCE_PATH_GRADLE + ". Root folder determined to be : "+resourceRootURL);
      }
    }
  }

  private Image loadImage(String filename, URL directory) throws IOException {
    String fullFilename = resourceFolder + "/" + filename;
    URL url = getClass().getResource(fullFilename);
    Image img = ImageIO.read(url);
    return img;
  }
}
