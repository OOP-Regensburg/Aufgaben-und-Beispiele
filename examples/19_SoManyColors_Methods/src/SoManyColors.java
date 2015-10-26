import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Rect;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.util.RandomGenerator;

/*
 * This program draws multiple colored rectangles on the screen,
 * using a grid-based approach, where rows and columns are defined 
 * by the square root of the total number of rectangles
 */
@SuppressWarnings("serial")
public class SoManyColors extends GraphicsApp {

	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private static final int NUM_SQUARES = 400;

	private RandomGenerator randomGen = RandomGenerator.getInstance();
	private int rows;
	private int columns;
	private int squareHeight;
	private int squareWidth;

	public void setup() {
		setupApp();
		setupGrid();
		drawGrid();
	}

	private void setupApp() {
		size(WIDTH, HEIGHT);
		background(Color.WHITE);
	}

	private void setupGrid() {
		rows = (int) Math.sqrt(NUM_SQUARES);
		columns = (int) Math.sqrt(NUM_SQUARES);
		squareHeight = HEIGHT / rows;
		squareWidth = WIDTH / columns;
	}

	private void drawGrid() {
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				Rect square = getRectangleForGrid(x, y);
				square.draw();
			}
		}
	}

	private Rect getRectangleForGrid(int x, int y) {
		Color squareColor = getRandomColor();
		int xPos = x * squareWidth;
		int yPos = y * squareHeight;
		return new Rect(xPos, yPos, squareWidth, squareHeight, squareColor);
	}

	private Color getRandomColor() {
		int r = (255 + randomGen.nextInt(0, 255)) / 2;
		int g = (255 + randomGen.nextInt(0, 255)) / 2;
		int b = (255 + randomGen.nextInt(0, 255)) / 2;
		return new Color(r, g, b);
	}
}
