import acm.program.*;


@SuppressWarnings("serial")
public class Pythagoras extends ConsoleProgram {

	public void run() {
		println("Geben Sie die Seitenlaengen von a und b ein um, die Seitenlaenge von c zu berechnen");

		int a = readInt("a: ");
		int b = readInt("b: ");
		int cSquare = (a * a) + (b * b);
		double c = Math.sqrt(cSquare);
		println("c= " + c);
	}
}
