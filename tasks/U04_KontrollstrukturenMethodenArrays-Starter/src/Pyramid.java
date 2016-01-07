import de.ur.mi.graphics.*;
import de.ur.mi.graphicsapp.*;

/*
 * File: Pyramid.java
 * 
 * This program draws a pyramid on the screen.
 * 
 */


public class Pyramid extends GraphicsApp {

	/* canvas setup */
	private static final Color BG_COLOR = Color.BLACK;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 300;

	public void setup() {
		setupCanvas();
		drawPyramid();
	}

	/*
	 * Draws the pyramid
	 */
	private void drawPyramid() {

	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
		background(BG_COLOR);
	}

}
