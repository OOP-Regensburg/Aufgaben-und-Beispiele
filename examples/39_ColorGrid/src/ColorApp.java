import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Rect;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.util.RandomGenerator;


@SuppressWarnings("serial")
public class ColorApp extends GraphicsApp {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	private static final int GRID_SIZE = 10;
	private static final Color BACKGROUND_COLOR = Color.BLACK;
	
	private Rect[][] grid;
	
	public void setup() {
		setupCanvas();
		setupGrid();
	}
	
	public void draw() {
		background(BACKGROUND_COLOR);
		drawGrid();
	}
	
	private void drawGrid() {
		for(int x = 0; x < GRID_SIZE; x++) {
			for(int y = 0; y < GRID_SIZE; y++) {
				grid[x][y].draw();
			}
		}
	}
	
	private void setupCanvas() {
		size(WIDTH, HEIGHT);
	}

	private void setupGrid() {
		RandomGenerator random = RandomGenerator.getInstance();
		int elementSize = (int) Math.floor(WIDTH/GRID_SIZE);
		
		grid = new Rect[GRID_SIZE][GRID_SIZE];
		
		for(int x = 0; x < GRID_SIZE; x++) {
			for(int y = 0; y < GRID_SIZE; y++) {
				Color color = random.nextColor();
				grid[x][y] = new Rect(x*elementSize, y*elementSize, elementSize, elementSize, color);
			}
		}
		
	}

}
