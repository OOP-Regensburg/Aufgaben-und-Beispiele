import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphics.Rect;


public class Ball {
	
	private int dx;
	private int dy;
	
	private Ellipse ball;
	private Rect boundingBox;
	
	public Ball(int x, int y, int radius, int xVelocity, int yVelocity, Color color, Rect boundingBox) {
		this.ball = new Ellipse(x, y, radius, radius, color);		
		this.dx = xVelocity;
		this.dy = yVelocity;
		this.boundingBox = boundingBox;
	}
	
	public double getX() {
		return ball.getX();
	}
	
	public double getY() {
		return ball.getY();
	}
	
	public void update() {
		ball.move(dx, dy);
	}
	
	public int[] reverseDirection() {
		dx = -dx;
		dy = -dy;
		return new int[] {dx,dy};
	}
	
	public int[] setDirection(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
		return new int[] {dx,dy};
	}
	
	public boolean isInBoundingBox() {
		return boundingBox.hitTest(ball.getX(), ball.getY());
	}
	
	public boolean collidesWith(Ball ball) {
		return this.ball.hitTest(ball.getX(), ball.getY());
	}
	
	public void draw() {
		ball.draw();
	}
}
