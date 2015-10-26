import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphics.Label;
import de.ur.mi.graphics.Rect;
import de.ur.mi.graphicsapp.GraphicsApp;


@SuppressWarnings("serial")
public class ContainerApp extends GraphicsApp {
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	
	private Container container;
	
	public void setup() {
		setupCanvas();
		setupContainer();
	}
	
	public void draw() {
		background(BACKGROUND_COLOR);
		container.draw();
	}
	
	private void setupCanvas() {
		size(WIDTH, HEIGHT);
	}
	
	private void setupContainer() {
		container = new Container();
		container.addObject(new Rect(50, 50, 100, 100, Color.BLACK));
		container.addObject(new Ellipse(150, 290, 100, 100, Color.GREEN));
		container.addObject(new Label(300,300,"Hello World", Color.RED));
	}
	


}
