import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

/**
 * 
 * @author Alexander Bazo
 * @version 1.0
 * 
 * A simple application to demonstrate the usage of the ExpandingCircle-class
 *
 */
@SuppressWarnings("serial")
public class CircleApp extends GraphicsApp {
	private static final int CANVAS_WIDTH = 800;
	private static final int CANVAS_HEIGHT = 800;
	private static final Color BACKGROUNDCOLOR = Color.WHITE;
	
	private ExpandingCircle circle1;
	private ExpandingCircle circle2;
	
	public void setup() {
		setupApplication();
		setupCircles();
	}
	
	private void setupApplication() {
		size(CANVAS_WIDTH, CANVAS_HEIGHT);
		background(BACKGROUNDCOLOR);
	}

	private void setupCircles() {
		circle1 = new ExpandingCircle(200, 200, 50, Color.BLUE);
		circle2 = new ExpandingCircle(600, 600, 40, Color.RED);
	}

	/**
	 * Draw-loop: Background, Update, Draw
	 */
	public void draw() {
		background(BACKGROUNDCOLOR);
		circle1.update();
		circle1.draw();
		circle2.update();
		circle2.draw();
	}

}
