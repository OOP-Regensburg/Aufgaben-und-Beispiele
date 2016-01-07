package cars;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Rect;
import de.ur.mi.util.RandomGenerator;

public class Car {

    private double speed;
    private Rect car;
    private int carHeight;

    private int canvasWidth;
    private int canvasHeight;

    private static final double MIN_SPEED = 2;
    private static final double MAX_SPEED = 10;

    private static final RandomGenerator rGen = RandomGenerator.getInstance();

    public Car(int carWidth, int carHeight, int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.carHeight = carHeight;

        //Color carColor = createRandomColor();
        //int randomYPos = getRandomYPos();
        //speed = getRandomSpeed();
        //car = new Rect(0, randomYPos, carWidth, carHeight, carColor);
    }
	
	/* Your code here... */

}