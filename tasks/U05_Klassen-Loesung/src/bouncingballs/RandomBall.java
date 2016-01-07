package bouncingballs;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.util.RandomGenerator;

public class RandomBall {
	private static final int MIN_DIAMETER = 50;
	private static final int MAX_DIAMETER = 100;

	private Ellipse ball;
	private RandomGenerator random;
	private double dx;
	private double dy;

	public RandomBall(int canvasWidth, int canvasHeight, double minVelocity,
					  double maxVelocity) {
		initRandomGenerator();
		initSpeed(minVelocity, maxVelocity);
		initBall(canvasWidth, canvasHeight);
	}

	private void initRandomGenerator() {
		random = RandomGenerator.getInstance();
	}

	private void initSpeed(double minSpeed, double maxSpeed) {
		dx = random.nextDouble(minSpeed, maxSpeed);
		dy = random.nextDouble(minSpeed, maxSpeed);
	}

	private void initBall(int canvasWidth, int canvasHeight) {
		int diameter = random.nextInt(MIN_DIAMETER, MAX_DIAMETER);
		int lowerXLimit = diameter / 2;
		int upperXLimit = canvasWidth - (diameter / 2);
		int lowerYLimit = diameter / 2;
		int upperYLimit = canvasHeight - (diameter / 2);

		int xPos = random.nextInt(lowerXLimit, upperXLimit);
		int yPos = random.nextInt(lowerYLimit, upperYLimit);
		Color color = random.nextColor();

		ball = new Ellipse(xPos, yPos, diameter, diameter,
				color);
	}

	public void update() {
		ball.move(dx, dy);
	}

	public void draw() {
		ball.draw();
	}

	/**
	 * Checks if the ball is colliding with on of the inner walls of a bounding
	 * box, given by the two parameters. Ball and bounding box are using the
	 * same coordinate system.
	 *
	 * @param boundingBoxWidth
	 * @param boundingBoxHeight
	 */
	public void checkWallCollision(int boundingBoxWidth, int boundingBoxHeight) {

		if (ball.getRightBorder() + Math.abs(dx) >= boundingBoxWidth
				|| ball.getLeftBorder() - Math.abs(dx) <= 0) {
			handleVerticalBounce();
		}

		if (ball.getBottomBorder() + Math.abs(dy) >= boundingBoxHeight
				|| ball.getTopBorder() - Math.abs(dy) <= 0) {
			handleHorizontalBounce();
		}

	}

	/**
	 * Handles the case, that the ball collides with the left or right wall
	 */
	private void handleVerticalBounce() {
		changeColor();
		dx *= -1;
	}

	/**
	 * Handles the case, that the ball collides with the top or bottom wall
	 */
	private void handleHorizontalBounce() {
		changeColor();
		dy *= -1;
	}

	/**
	 * Handles the actual collision by updating color, size and speed
	 */
	private void changeColor() {
		Color color = random.nextColor();
		ball.setColor(color);
	}





}
