import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphicsapp.GraphicsApp;


public class CenterCircle extends GraphicsApp {
	
	public void setup() {
		setupApp();
		drawCircle();
	}
	
	private void setupApp() {
		size(400,400);
		background(Color.BLACK);
	}
	
	/*
	 * Create and draw a circle on to the canvas.
	 * The circles position is determined by the application't width and height,
	 * using the bisected size, the circles origin is positioned in the center. 
	 */
	private void drawCircle() {
		Ellipse circle = new Ellipse(width/2, height/2, 100, 100, Color.CYAN);
		circle.draw();
	}

}
