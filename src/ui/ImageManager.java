package ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ImageManager {
    public Image getImage(String filename) {
        try {
            URL url = getClass().getResource("/minidraw-images/" + filename + ".jpg");
            return ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
