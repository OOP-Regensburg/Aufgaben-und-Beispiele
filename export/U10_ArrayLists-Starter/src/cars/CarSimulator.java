package cars;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

import java.util.ArrayList;

public class CarSimulator extends GraphicsApp {

    private static final int CAR_NUM = 100;
    private static final int CAR_WIDTH = 15;
    private static final int CAR_HEIGHT = 5;
    private static final Color BG_COLOR = Color.BLACK;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;

    private ArrayList<Car> cars;

    public void setup() {
        setupCanvas();
        //setupCars();
    }

    public void draw() {
        drawBackground();
        //drawCars();
    }

    private void setupCanvas() {
        size(WIDTH, HEIGHT);
    }

    private void drawBackground() {
        background(BG_COLOR);
    }

	/* Your code here... */

}