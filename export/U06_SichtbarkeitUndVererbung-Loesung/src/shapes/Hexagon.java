package shapes;

import de.ur.mi.geom.Point;
import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.GraphicsObject;
import de.ur.mi.graphics.Line;

/**
 * Created by Alexander Bazo on 15/11/15.
 */
public class Hexagon extends GraphicsObject {

    private Point alpha;
    private Point beta;
    private Point gamma;
    private Point delta;
    private Point epsilon;
    private Point zeta;

    public Hexagon(double x, double y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    private void updatePoints() {
        alpha = new Point(getX() - width / 4, getY() + height / 2);
        beta = new Point(getX() + width / 4, getY() + height / 2);
        gamma = new Point(getX() + width/2, getY());
        delta = new Point(getX() + width/4, getY() - height / 2);
        epsilon = new Point(getX() - width/4, getY() - height / 2);
        zeta = new Point(getX() - width/2, getY());
    }


    @Override
    public void draw() {
        updatePoints();
        Line a = new Line(gamma, beta, getColor());
        Line b = new Line(gamma, delta, getColor());
        Line c = new Line(delta, epsilon, getColor());
        Line d = new Line(epsilon, zeta, getColor());
        Line e = new Line(zeta, alpha, getColor());
        Line f = new Line(alpha, beta, getColor());
        a.setBorderWeight(getBorderWeight());
        b.setBorderWeight(getBorderWeight());
        c.setBorderWeight(getBorderWeight());
        d.setBorderWeight(getBorderWeight());
        e.setBorderWeight(getBorderWeight());
        f.setBorderWeight(getBorderWeight());
        a.draw();
        b.draw();
        c.draw();
        d.draw();
        e.draw();
        f.draw();
    }
}
