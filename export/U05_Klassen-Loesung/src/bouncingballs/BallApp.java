package bouncingballs;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

/**
 * @author Alexander Bazo
 * @version 1.0
 * 
 * This is the main class of the "Random Bouncing Balls" Application. 
 * Use this class to create two RandomBall-Objects and to control the
 * draw-loop. This tasks should help you to become familiar with
 * implementing and using classes. You may find some design flaws, 
 * keep in mind that it's all about learning the BASIC principles of
 * object oriented programming.
 */
@SuppressWarnings("serial")
public class BallApp extends GraphicsApp {
	private static final int CANVAS_WIDTH = 800;
	private static final int CANVAS_HEIGHT = 800;
	private static final Color BACKGROUNDCOLOR = Color.WHITE;
	private static final double MIN_BALL_VELOCITY = 2;
	private static final double MAX_BALL_VELOCITY = 10;
	
	private RandomBall ballOne;
	private RandomBall ballTwo;
	
	public void setup() {
		setupApplication();
		setupRandomBalls();
	}
	
	private void setupApplication() {
		size(CANVAS_WIDTH, CANVAS_HEIGHT);
		background(BACKGROUNDCOLOR);
	}
	
	private void setupRandomBalls() {
		ballOne = new RandomBall(CANVAS_WIDTH, CANVAS_HEIGHT, MIN_BALL_VELOCITY, MAX_BALL_VELOCITY);
		ballTwo = new RandomBall(CANVAS_WIDTH, CANVAS_HEIGHT, MIN_BALL_VELOCITY, MAX_BALL_VELOCITY);
	}
	
	public void draw() {
		background(BACKGROUNDCOLOR);
		drawBalls();
	}
	
	private void drawBalls() {
		drawBall(ballOne);
		drawBall(ballTwo);
	}
	
	private void drawBall(RandomBall ball) {
		ball.checkWallCollision(CANVAS_WIDTH, CANVAS_HEIGHT);
		ball.update();
		ball.draw();
	}

}
