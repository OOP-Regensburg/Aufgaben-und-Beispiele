import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.util.RandomGenerator;

/*
 * This program animates a ball (ellipse). The ball bounces when 
 * reaching one of the walls.
 */
@SuppressWarnings("serial")
public class BouncingBall extends GraphicsApp {
	
	private static final int CANVAS_SIZE = 600;
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	private static final int BALL_RADIUS = 50;
	private static final int BALL_HORIZONTAL_SPEED = 1;
	private static final int BALL_VERTICAL_SPEED = 2;
	
	private RandomGenerator randomGen = RandomGenerator.getInstance();
	private Ellipse ball;
	/* Velocity delta in the x direction */
	private double dx = BALL_HORIZONTAL_SPEED;
	/* Velocity delta in the y direction */
	private double dy = BALL_VERTICAL_SPEED;
	
	public void setup() {
		setupApp();
	}
	
	private void setupApp() {
		Color ballColor = getRandomColor();
		size(CANVAS_SIZE,CANVAS_SIZE);
		background(BACKGROUND_COLOR);
		ball = new Ellipse(CANVAS_SIZE/2, CANVAS_SIZE/2, BALL_RADIUS, BALL_RADIUS, ballColor);
	}
	
	
	public void draw() {
		background(BACKGROUND_COLOR);
		checkCollision();
		moveBall();
	}
	
	private void checkCollision() {
		double ballX = ball.getX();
		double ballY = ball.getY();
		//if ball hits the right or left wall, change x-direction
		if (ballX > CANVAS_SIZE - BALL_RADIUS || ballX < BALL_RADIUS) {
			dx *= -1;
		}
		//if ball hits the bottom or top wall, change y-direction
		if (ballY > CANVAS_SIZE - BALL_RADIUS || ballY < BALL_RADIUS) {
			dy *= -1;
		}
	}
	
	private void moveBall() {
		ball.move(dx, dy);
		ball.draw();
	}
	
	private Color getRandomColor() {
		int r = (255 + randomGen.nextInt(0, 255)) / 2;
		int g = (255 + randomGen.nextInt(0, 255)) / 2;
		int b = (255 + randomGen.nextInt(0, 255)) / 2;
		return new Color(r, g, b);
	}

}
