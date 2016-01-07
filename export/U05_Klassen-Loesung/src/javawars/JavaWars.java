package javawars;

import acm.program.ConsoleProgram;
import de.ur.mi.geom.Point;
import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse; // For Point and Ellipse

@SuppressWarnings("serial")
public class JavaWars extends ConsoleProgram {
    public void run() {
	String hanSolo = "I've got...";
	Point alderaan = new Point(2.718, 3.141);
	int r2d2 = 137;
	
	Ellipse emperor = new Ellipse(45, 70, 10, 20, Color.BLACK);
	lukeSkywalker(emperor, alderaan);
	println("emperor.getX() = " + emperor.getX());
	println("alderaan.getX() = " + alderaan.getX());
	
	darthVader(emperor, r2d2);
	println("emperor.getY() = " + emperor.getY());
	println("r2d2 = " + r2d2);
	
	alderaan = landoCalrissian(alderaan, hanSolo);
	println("hanSolo = " + hanSolo);
	println("alderaan.getX() = " + alderaan.getX());
    }

    private void lukeSkywalker(Ellipse chewbacca, Point toto) {
	chewbacca.setPosition(40, 66);
	toto = new Point(1.61, 98.6);
    }

    private Ellipse darthVader(Ellipse emperor, int r2d2) {
	emperor = new Ellipse(90, 100, 10, 20, Color.BLACK);
	r2d2 = 14;
	return emperor;
    }

    private Point landoCalrissian(Point alderaan, String hanSolo) {
	hanSolo = hanSolo + "... a very bad feeling about this.";
	alderaan = new Point(99.9, 44.4);
	return alderaan;
    }
}