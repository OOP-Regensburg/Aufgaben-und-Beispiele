import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.util.RandomGenerator;

/*
 * This program animates a ball (ellipse) moving from the upper left
 * corner to the bottom right of the canvas.
 */
@SuppressWarnings("serial")
public class FlyingBall extends GraphicsApp {
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	private static final int BALL_WIDTH = 50;
	private static final int BALL_HEIGHT = 50;
	private static final int BALL_HORIZONTAL_SPEED = 1;
	private static final int BALL_VERTICAL_SPEED = 1;
	
	private RandomGenerator randomGen = RandomGenerator.getInstance();
	private Ellipse ball;
	
	public void setup() {
		setupApp();
	}
	
	private void setupApp() {
		Color ballColor = getRandomColor();
		size(WIDTH,HEIGHT);
		background(BACKGROUND_COLOR);
		ball = new Ellipse(BALL_WIDTH/2, BALL_HEIGHT/2, BALL_WIDTH, BALL_HEIGHT, ballColor);
	}
	
	
	public void draw() {
		background(BACKGROUND_COLOR);
		ball.move(BALL_HORIZONTAL_SPEED, BALL_VERTICAL_SPEED);
		ball.draw();
	}
	
	private Color getRandomColor() {
		int r = (255 + randomGen.nextInt(0, 255)) / 2;
		int g = (255 + randomGen.nextInt(0, 255)) / 2;
		int b = (255 + randomGen.nextInt(0, 255)) / 2;
		return new Color(r, g, b);
	}

}
