import java.awt.event.MouseEvent;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphicsapp.GraphicsApp;

/**
 * A simple demo application showing the use of mouse events. The application
 * draws a single ellipse in the canvases center. Each time the user clicks 
 * on that ellipse a drag movement is started. The ellipse then follows the mouse
 * movements until the mouse button is released.
 * @author Alexander Bazo
 *
 */
@SuppressWarnings("serial")
public class DraggerApp extends GraphicsApp {
	
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private static final int ELEMENT_SIZE = 50;
	
	private Ellipse ellipse;
	/*
	 * This variable indicates whether the ellipse is currently dragged or not. 
	 */
	private boolean dragging = false;

	public void setup() {
		setupCanvas();
		setupComponents();
	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
		background(BACKGROUND_COLOR);
	}

	private void setupComponents() {
		ellipse = new Ellipse(WIDTH/2, HEIGHT/2, ELEMENT_SIZE, ELEMENT_SIZE, Color.ORANGE);
	}
	
	
	/*
	 * When the ellipse is currently in drag mode, the given parameters are used
	 * to reposition it.
	 */
	private void moveEllipse(double x, double y) {
		if(!dragging) {
			return;
		}
		ellipse.setPosition(x, y);
	}
	
	public void draw() {
		background(BACKGROUND_COLOR);
		ellipse.draw();
	}
	
	
	/*
	 * Each time a mouse button is pressed we check if the current mouse position is within 
	 * the ellipse to determine if the drag mode should be activated
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		/*
		 * hitTest checks if a given position (x,y) is within in the bounding box of an GraphicsObject
		 */
		boolean ellipseClicked = ellipse.hitTest(e.getX(), e.getY());
		if(ellipseClicked) {
			dragging = true;
		}
	}
	
	/*
	 * The drag mode is deactivated when the mouse button is released
	 */
	@Override
	public void mouseReleased() {
		dragging = false;
		super.mouseReleased();
	}
	
	/*
	 * While dragging we hand down the current mouse position to the
	 * moveEllipse method to reposition the ellipse
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		moveEllipse(e.getX(), e.getY());
		super.mouseDragged(e);
	}
	

}
