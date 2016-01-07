/**
 * A single chess field.
 * 
 * @author Alexander Bazo
 */
import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.GraphicsObject;
import de.ur.mi.graphics.Image;
import de.ur.mi.graphics.Rect;

public class Chessfield extends GraphicsObject {
	private boolean hasPawn = false;
	private Image pawnPiece;

	public Chessfield(double x, double y, int width, int height,
			Color backgroundColor) {
		super(x, y, width, height, backgroundColor);
		initPiece(x, y, width, height);
	}

	private void initPiece(double x, double y, int width, int height) {
		pawnPiece = new Image(x, y, width, height, "data/assets/pawn.png");
	}

	public void addPawn() {
		hasPawn = true;
	}

	public void removePawn() {
		hasPawn = false;
	}

	public boolean hasPawn() {
		return hasPawn;
	}

	@Override
	public void draw() {
		drawField();
		drawPawn();
	}

	private void drawField() {
		Rect field = new Rect(x, y, (int) width, (int) height, color);
		field.draw();
	}

	private void drawPawn() {
		if (hasPawn) {
			pawnPiece.draw();
		}
	}

}
