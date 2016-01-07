import de.ur.mi.graphicsapp.*;
import de.ur.mi.graphics.*;

/*
 * File: BouncingBall.java
 *
 * This program draws a bouncing ball on the screen.
 *
 */

public class BouncingBall extends GraphicsApp {
	/* Private constants */
	private static final int CANVAS_HEIGHT = 400;
	private static final int CANVAS_WIDTH = 1000;
	private static final int FRAME_RATE = 60;
	private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

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
