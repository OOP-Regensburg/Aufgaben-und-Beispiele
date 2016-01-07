package shapes;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

/**
 * Created by Alexander Bazo on 15/11/15.
 */
public class ShapesTestApp extends GraphicsApp {

    /*
    private Triangle triangle;
    private Hexagon hexagon;
    */

    @Override
    public void setup() {
        initCanvas();
        initShapes();
    }

    private void initCanvas() {
        size(500, 500);
        background(Color.WHITE);
        smooth(8);
    }

    private void initShapes() {
        /*
        triangle = new Triangle(250, 250, 100, 100, Color.BLACK);
        triangle.setBorderWeight(3.0);
        hexagon = new Hexagon(250, 250, 100, 100, Color.BLACK);
        hexagon.setBorderWeight(3.0);
        */
    }

    @Override
    public void draw() {
        background(Color.WHITE);
        drawShapes();

    }

    private void drawShapes() {
        /*
        triangle.move(2, 2);
        triangle.draw();
        hexagon.move(-2, -2);
        hexagon.draw();
        */
    }
}
