import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
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
    private static final Color CIRCLE_COLOR = Color.ORANGE;
    private static final int INITAL_CIRCLE_RADIUS = 50;
    private static final int MAX_CIRCLE_RADIUS = 250;

	/* Private instance variables */
	private Ellipse circle;

	public void setup() {
		setupCanvas();
		setupCircle();
	}

	/*
	 * This method is called repeatedly while the program is running.
	 */
	public void draw() {
        updateCircle();
		drawBackground();
        drawCircle();
	}

	private void setupCanvas() {
		size(CANVAS_WIDTH, CANVAS_HEIGHT);
		frameRate(FRAME_RATE);
		smooth();
	}

    /*
     * This method creates the inital circle at the center of the canvas.
     */
	private void setupCircle() {
        circle = new Ellipse(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, INITAL_CIRCLE_RADIUS*2, INITAL_CIRCLE_RADIUS*2, CIRCLE_COLOR);
	}

    /*
     * For each call of this method, the circles width and height is increased by 1. If MAX_CIRCLE_RADIUS is reached,
     * the circles width and height are reset to INITIAL_CIRCLE_RADIUS.
     */
    private void updateCircle() {
        double newCircleWidth = circle.getWidth() + 1;
        double newCircleHeight = circle.getHeight() + 1;
        if(newCircleWidth > MAX_CIRCLE_RADIUS*2 ||newCircleHeight > MAX_CIRCLE_RADIUS*2) {
            newCircleWidth = INITAL_CIRCLE_RADIUS*2;
            newCircleHeight = INITAL_CIRCLE_RADIUS*2;
        }
        circle.setSize(newCircleWidth, newCircleHeight);
    }

    /*
     * This method resets the background to a plain color (BACKGROUND_COLOR)
     */
	private void drawBackground() {
		background(BACKGROUND_COLOR);
	}

    private void drawCircle() {
        circle.draw();
    }
}
