
import de.ur.mi.graphics.*;
import de.ur.mi.graphicsapp.*;

/*
 * File: Pyramid.java
 * 
 * This program draws a pyramid on the screen.
 * 
 */


public class Pyramid extends GraphicsApp {

	/* canvas setup */
	private static final Color BG_COLOR = Color.BLACK;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 300;
	private static final int HORIZONTAL_CENTER = WIDTH / 2;

	/* constants for bricks */
	private final int BRICK_WIDTH = 30;
	private final int BRICK_HEIGHT = 12;
	private final int BRICKS_IN_BASE = 14;
	private final int PYRAMID_ROWS = BRICKS_IN_BASE;
	private final Color BRICK_COLOR = Color.ORANGE;

	public void setup() {
		setupCanvas();
		drawPyramid();
	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
		background(BG_COLOR);
	}

	private void drawPyramid() {
		int xPosStart = HORIZONTAL_CENTER - (BRICK_WIDTH * BRICKS_IN_BASE / 2)  ;
		for (int currentRow = 1; currentRow <= PYRAMID_ROWS; currentRow++) {
			int yPos = calcCurrentYPos(currentRow);
			int numBricks = PYRAMID_ROWS - currentRow + 1;
			int xPosRowStart = calcCurrentXPos(currentRow, xPosStart);  
			drawPyramidRow(numBricks, xPosRowStart, yPos);
		}
	}
	
	private int calcCurrentYPos(int row){
		return HEIGHT - row * BRICK_HEIGHT;
	}
	
	private int calcCurrentXPos(int row, int xPosStart){
		return xPosStart + ((row -1) * (BRICK_WIDTH / 2));
	}
				
	private void drawPyramidRow(int numBricks, int xPosStart, int yPos) {
		for (int j = 0; j < numBricks; j++) {
			int xPosBrickInRow = xPosStart + (j * BRICK_WIDTH);
			drawBrick(xPosBrickInRow, yPos);
		}
	}
	
	private void drawBrick(int xPos, int yPos){
		Rect brick = new Rect(xPos, yPos, BRICK_WIDTH, BRICK_HEIGHT, BRICK_COLOR);
		brick.setBorder(BG_COLOR, 1);
		brick.draw();
	}

}

