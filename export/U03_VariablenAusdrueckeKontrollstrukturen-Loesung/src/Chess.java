import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Rect;
import de.ur.mi.graphicsapp.GraphicsApp;

/**
 * This program draws a chess board.
 */

@SuppressWarnings("serial")
public class Chess extends GraphicsApp {

	private static final int APP_WIDTH = 800;
	private static final int APP_HEIGHT = 800;
	private static final int NUM_ROWS = 8;
	private static final int NUM_COLS = 8;
	private static final Color BLACK_FIELD_COLOR = Color.BLACK;
	private static final Color WHITE_FIELD_COLOR = Color.WHITE;

	/**
	 * Entry point: The program starts here
	 */
	public void setup() {
		setupApplication();
		drawChessboard();
	}

	/**
	 * Setups size and background color of the application window
	 */
	private void setupApplication() {
		size(APP_WIDTH, APP_HEIGHT);
		background(BLACK_FIELD_COLOR);
	}

	/**
	 * This method iterates over the chessboard's rows and columns to draw the individual
	 * fields. The field color is swapped after each iteration, except for the last field of
	 * each row
	 */
	private void drawChessboard() {
		Color fieldColor = WHITE_FIELD_COLOR;
		for (int y = 0; y < NUM_ROWS; y++) {
			for (int x = 0; x < NUM_COLS; x++) {
				drawField(x, y, fieldColor);
				if (x < NUM_COLS - 1) {
					if (fieldColor == WHITE_FIELD_COLOR) {
						fieldColor = BLACK_FIELD_COLOR;
					} else {
						fieldColor = WHITE_FIELD_COLOR;
					}
				}

			}

		}
	}

	/**
	 * Draws a single field at the given coordinates. The board position is translated to a canvas position,
	 * using the field size, which is calculated from the window size and the number of rows and
	 * columns. 
	 * @param xPos X position (column on the chessboard) of the field to be drawn
	 * @param yPos Y position (row on the chessboard) of the field to be drawn
	 * @param fieldColor Color of the field to be drawn
	 */
	private void drawField(int xPos, int yPos, Color fieldColor) {
		int fieldWidth = APP_WIDTH / NUM_COLS;
		int fieldHeight = APP_HEIGHT / NUM_ROWS;
		int startX = xPos * fieldWidth;
		int startY = yPos * fieldHeight;
		Rect field = new Rect(startX, startY, fieldWidth, fieldHeight,
				fieldColor);
		field.draw();

	}

}
