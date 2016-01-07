import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphics.Rect;
import de.ur.mi.graphicsapp.GraphicsApp;


public class HelloGraphics extends GraphicsApp {
	
	/*
	 * Setup is called on launch. 
	 * You may use this as an entry point (see bounce()).
	 */
	public void setup() {
		setupApp();
		drawThings();
		
	}
	
	/*
	 * Sets the window size to 400px (with) and 400px (height) and
	 * paints window's background color black.
	 */
	private void setupApp() {
		size(400,400);
		background(Color.BLACK);
	}
	
	/*
	 * Creates and draws an Ellipse and Rectangle onto the canvas.
	 */
	private void drawThings() {
		translate(0,400);
		Ellipse circle = new Ellipse(0, 100, 100, 100, Color.CYAN);
		circle.draw();
	}

}
