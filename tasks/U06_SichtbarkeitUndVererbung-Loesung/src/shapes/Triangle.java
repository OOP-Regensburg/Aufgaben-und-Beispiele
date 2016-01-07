package shapes;

import de.ur.mi.geom.Point;
import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.GraphicsObject;
import de.ur.mi.graphics.Line;

/**
 * Created by Alexander Bazo on 15/11/15.
 */
public class Triangle extends GraphicsObject {

    private Point alpha;
    private Point beta;
    private Point gamma;

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        updatePoints();
    }

    private void updatePoints() {
        alpha = new Point(getX() - width / 2, getY() + height / 2);
        beta = new Point(getX() + width / 2, getY() + height / 2);
        gamma = new Point(getX(), getY() - height / 2);
    }


    @Override
    public void draw() {
        updatePoints();
        Line a = new Line(gamma, beta, getColor());
        Line b = new Line(gamma, alpha, getColor());
        Line c = new Line(alpha, beta, getColor());
        a.setBorderWeight(getBorderWeight());
        b.setBorderWeight(getBorderWeight());
        c.setBorderWeight(getBorderWeight());
        a.draw();
        b.draw();
        c.draw();
    }
}
