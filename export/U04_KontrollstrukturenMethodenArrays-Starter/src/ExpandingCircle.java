import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

/*
 * File: ExpandingCircle.java
 *
 * This program draws an expanding Circle on the screen.
 *
 */

public class ExpandingCircle extends GraphicsApp {
    /* Private constants */
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 60;
    private static final Color BACKGROUND_COLOR = Color.WHITE;

	/* Private instance variables */

    public void setup() {
        setupCanvas();

    }

    /*
     * This method is called repeatedly while the program is running.
     */
    public void draw() {
        drawBackground();
    }

    private void setupCanvas() {
        size(CANVAS_WIDTH, CANVAS_HEIGHT);
        frameRate(FRAME_RATE);
        smooth();
    }

    private void drawBackground() {
        background(BACKGROUND_COLOR);
    }
}
