import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Compound;
import de.ur.mi.graphics.Rect;
import de.ur.mi.util.RandomGenerator;

/**
 * 
 * @author Alexander Bazo
 * 
 * This class represents a snake that can be drawn on to the canvas.
 * The snake consists of multiple rectangular segments, which are drawn
 * using a compound object.
 *
 */
public class Snake {
	private static final int SNAKE_ELEMENT_SIZE = 50;
	private static final double SPEED = 4;

	/*
	 * This compound is used to controll and draw the snake. Every command (move, draw, ...), 
	 * addressed to the snake as a whole is called on snakeCompound.
	 */
	private Compound snakeCompound;
	private RandomGenerator random;

	public Snake(int initialXPos, int initialYPos, int initalSnakeSize) {
		initSnake(initialXPos, initialYPos, initalSnakeSize);
	}
	
	public void draw() {
		snakeCompound.draw();
	}
	
	public void moveForward() {
		snakeCompound.move(SPEED, 0);
	}
	
	public void moveBackward() {
		snakeCompound.move(-SPEED, 0);
	}

	/**
	 * This method initializes the snake compound. By using the size parameter we create
	 * and position multiple rectangular shapes that form the snake. Each element is colored 
	 * randomly an is positioned next to the previous one. Each element is finally added to the 
	 * compound. The compound - including all segments - can than be used to draw or move 
	 * all segments at once.
	 * 
	 * @param initialXPos Initial horizontal position of the snakes left end
	 * @param initialYPos Initial horizontal position of the snakes right end
	 * @param initalSnakeSize Initial number of elements for the snake
	 */
	private void initSnake(int initialXPos, int initialYPos, int initalSnakeSize) {
		random = RandomGenerator.getInstance();
		snakeCompound = new Compound();
		for (int i = 0; i < initalSnakeSize; i++) {
			Rect newElement = getNewSnakeElement(initialXPos, initialYPos, i);
			snakeCompound.add(newElement);
		}
	}

	private Rect getNewSnakeElement(int initialXPos, int initialYPos,
			int elementPostion) {
		double x = initialXPos + (elementPostion * SNAKE_ELEMENT_SIZE);
		double y = initialYPos;
		Color elementColor = random.nextColor();
		Rect element = new Rect(x, y, SNAKE_ELEMENT_SIZE, SNAKE_ELEMENT_SIZE,
				elementColor);
		return element;
	}
}
