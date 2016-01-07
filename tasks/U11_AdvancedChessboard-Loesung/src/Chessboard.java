import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Compound;
import de.ur.mi.graphics.Image;
import de.ur.mi.util.RandomGenerator;

/**
 * A chessboard, composed of grid with different fields and an indicator image to visualize 
 * movement of the chess piece. Mouse movements are processed by public methods. A compound 
 * object is used to pack and draw the individual fields. 
 * 
 * @author Alexander Bazo
 *
 */
public class Chessboard {
	private static final int ROWS = 8;
	private static final int COLUMNS = 8;

	private Compound board;
	private Image moveIndicator;
	private boolean movingPiece = false;

	public Chessboard(int boardWidth, int boardHeight) {
		initBoard(boardWidth / COLUMNS, boardHeight / ROWS);
		initMoveIndicator(boardWidth / COLUMNS, boardHeight / ROWS);
		placeRandomPawnOnBoard();
	}

	private void initBoard(int fieldWidth, int fieldHeight) {
		board = new Compound(0, 0);
		for (int x = 0; x < ROWS; x++) {
			for (int y = 0; y < COLUMNS; y++) {
				Chessfield newField = getNewFieldForBoard(x, y, fieldWidth,
						fieldHeight);
				board.add(newField);
			}
		}
	}

	private Chessfield getNewFieldForBoard(int xIndex, int yIndex,
			int fieldWidth, int fieldHeight) {
		Chessfield newField;
		int xPos = xIndex * fieldWidth;
		int yPos = yIndex * fieldHeight;
		if ((xIndex + yIndex) % 2 == 0) {
			newField = new Chessfield(xPos, yPos, fieldWidth, fieldHeight,
					Color.BLACK);
		} else {
			newField = new Chessfield(xPos, yPos, fieldWidth, fieldHeight,
					Color.WHITE);
		}
		return newField;
	}

	private void initMoveIndicator(int fieldWidth, int fieldHeight) {
		moveIndicator = new Image(0, 0, fieldWidth, fieldHeight,
				"data/assets/pawn.png");
	}

	/**
	 * Based on the number of available fields (ROWS * COKUMNS) a random field is
	 * selected from the compound using a random generated value as index. 
	 * The chess piece is placed on that field.
	 */
	private void placeRandomPawnOnBoard() {
		RandomGenerator random = RandomGenerator.getInstance();
		int randomIndex = random.nextInt(0, (ROWS * COLUMNS) - 1);
		Chessfield randomChessfield = (Chessfield) board.get(randomIndex);
		randomChessfield.addPawn();
	}

	public void draw() {
		board.draw();
		if (movingPiece) {
			moveIndicator.draw();
		}
	}

	/**
	 * Handles mouse interaction. If move mode (movingPiece) is on, the chess piece is placed
	 * in the clicked field. Otherwise (and if the clicked field contains a piece) move mode is activated
	 * an the pawn is remove from the clicked field.
	 *  
	 * @param mouseX Current horizontal position of the mouse cursor on the canvas
	 * @param mouseY Current vertical position of the mouse cursor on the canvas
	 */
	public void handleMouseclick(int mouseX, int mouseY) {
		System.out.println(mouseX + ", " + mouseY);
		Chessfield clickedField = (Chessfield) board
				.getObjectAt(mouseX, mouseY);
		if (clickedField == null) {
			return;
		}
		if (movingPiece) {
			clickedField.addPawn();
			movingPiece = false;
		} else if (clickedField.hasPawn()) {
			clickedField.removePawn();
			movingPiece = true;
		}

	}

	/**
	 * Handles mouse interaction. While the mouse is moved, the position of the indicator image is changed.
	 * The cursor position and the images dimensions are used to center the indicator at the current 
	 * cursor position.
	 * 
	 * @param mouseX Current horizontal position of the mouse cursor on the canvas
	 * @param mouseY Current vertical position of the mouse cursor on the canvas
	 */
	public void handleMousemove(double x, double y) {
		x -= moveIndicator.getWidth() / 2;
		y -= moveIndicator.getHeight() / 2;
		moveIndicator.setPosition(x, y);
	}

}
