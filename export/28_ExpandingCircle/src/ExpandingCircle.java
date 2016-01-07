import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;

/**
 * 
 * @author Alexander Bazo
 * @version 1.0
 * 
 * A  class representing a expanding circle
 *
 */
public class ExpandingCircle {
	/* Maximal diameter of the circle */
	private static final int MAX_DIAMAETER = 250;
	
	/* Memeber: Ellipse-Object used to modify and draw the expanding ball */
	private Ellipse ball;
	
	/**
	 * The constructor: Use new ExpandingCircle(xPos,yPos,diameter,color) to create a
	 * new instance of the ExpandingCircle-class
	 * @param xPos x-position of the circle
	 * @param yPos y-position of the circle
	 * @param initialDiameter initial diameter of the circle
	 * @param backgroundColor backgroundcolor for the circle
	 */
	public ExpandingCircle(int xPos, int yPos, int initialDiameter, Color backgroundColor) {
		ball = new Ellipse(xPos, yPos, initialDiameter, initialDiameter, backgroundColor);
	}
	
	/**
	 * Called to update (expand) the circle by 1px
	 */
	public void update() {
		updateBall();
	}
	
	/**
	 * Called to draw the circle
	 */
	public void draw() {
		ball.draw();
	}
	
	private void updateBall() {
		double currentDiameter = ball.getWidth();
		if(currentDiameter < MAX_DIAMAETER) {
			currentDiameter++;
			ball.setSize(currentDiameter, currentDiameter);
		}
	}
	
}
