import java.awt.event.MouseEvent;

import de.ur.mi.graphicsapp.GraphicsApp;

/**
 * A java application, displaying a chessboard with movable pieces. This controller
 * initializes a Chessboard and relays any mouse events to that instance.
 * 
 * @author Alexander Bazo
 *
 */
@SuppressWarnings("serial")
public class ChessboardController extends GraphicsApp {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	
	public void setup() {
		setupCanvas();
	}
	
	private void setupCanvas() {
		size(WIDTH,HEIGHT);
	}

	public void draw() {
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);
	}
}
