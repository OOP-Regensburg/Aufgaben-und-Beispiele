package cars;

import java.util.ArrayList;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;


@SuppressWarnings("serial")
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
        setupCars();
    }

    public void draw() {
        drawBackground();
        drawCars();
    }

    private void drawCars() {
        for (Car car : cars) {
            car.update();
            car.draw();
        }
    }

    private void setupCars() {
        cars = new ArrayList<Car>();
        for (int i = 0; i < CAR_NUM; i++) {
            Car car = new Car(CAR_WIDTH, CAR_HEIGHT, WIDTH, HEIGHT);
            cars.add(car);
        }
    }


    private void setupCanvas() {
        size(WIDTH, HEIGHT);
    }

    private void drawBackground() {
        background(BG_COLOR);
    }
}
