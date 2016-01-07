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

	private Chessboard chessboard;
	
	public void setup() {
		setupCanvas();
		setupChessboard();
	}
	
	private void setupCanvas() {
		size(WIDTH,HEIGHT);
	}

	private void setupChessboard() {
		chessboard = new Chessboard(WIDTH, HEIGHT);
	}
	
	public void draw() {
		chessboard.draw();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(chessboard != null) {
			chessboard.handleMouseclick(e.getX(), e.getY());
		}
		super.mouseClicked(e);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(chessboard != null) {
			chessboard.handleMousemove(e.getX(), e.getY());
		}
		super.mouseMoved(e);
	}
}
