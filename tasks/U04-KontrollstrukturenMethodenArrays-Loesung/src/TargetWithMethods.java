
import de.ur.mi.graphics.*;
import de.ur.mi.graphicsapp.*;

/*
 * File: Target.java
 * 
 * This program draws a dart target on the screen.
 * 
 */


public class TargetWithMethods extends GraphicsApp {

	/* canvas setup */
	private static final Color BG_COLOR = Color.WHITE;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	private static final int X_POS_CENTER = WIDTH / 2;
	private static final int Y_POS_CENTER = HEIGHT / 2;

	/* properties for dart target */
	private static Color RING_COLOR_UNEVEN = Color.RED;
	private static Color RING_COLOR_EVEN = Color.WHITE;
	private static int NUM_RINGS = 15;
	private static int INITIAL_RING_WIDTH = 10;

	public void setup() {
		setupCanvas();
		drawDartTarget();
	}

	/*
	 * Draws a dart target
	 */
	private void drawDartTarget() {
		for (int i = NUM_RINGS; i > 0; i--) {
			Color ringColor = getColor(i);
			drawRing(i, ringColor);
		}
	}

	private void drawRing(int ringIndex, Color ringColor) {
		int radius = (INITIAL_RING_WIDTH) + (ringIndex * INITIAL_RING_WIDTH);
		Ellipse ring = new Ellipse(X_POS_CENTER, Y_POS_CENTER, radius, radius,
				ringColor);
		ring.draw();
	}

	private Color getColor(int i) {
		if (i % 2 == 0) {
			return RING_COLOR_EVEN;
		} else {
			return RING_COLOR_UNEVEN;
		}
	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
		background(BG_COLOR);
	}

}
