package images;

import de.ur.mi.graphics.Image;
import de.ur.mi.graphicsapp.GraphicsApp;

import java.awt.event.KeyEvent;

public class ImageFlipper extends GraphicsApp {
    private Image sopranos;

    public void setup() {
        size(600, 500);
        sopranos = new Image(0, 0, "data/assets/sopranos.jpg");
        sopranos.draw();
    }

    private Image flipImageHorizontal(Image img) {
        // image flipping code here
        return img;
    }

    public void keyPressed(KeyEvent k) {
        sopranos = flipImageHorizontal(sopranos);
        sopranos.draw();
    }
}