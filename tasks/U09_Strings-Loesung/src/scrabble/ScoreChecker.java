package scrabble;
public class ScoreChecker {

	private static final String ONE_POINT_CHARS = "AEILNORSTU";
	private static final String TWO_POINT_CHARS = "DG";
	private static final String THREE_POINT_CHARS = "BCMP";
	private static final String FOUR_POINT_CHARS = "FHVWY";
	private static final String FIVE_POINT_CHARS = "K";
	private static final String EIGHT_POINT_CHARS = "JX";
	private static final String TEN_POINT_CHARS = "QZ";

	public static int getScore(String str) {
		int score = 0;
		for (int i = 0; i < str.length(); i++) {
			score += getScore(str.charAt(i));
		}
		return score;
	}

	private static int getScore(char c) {
		if (ONE_POINT_CHARS.indexOf(c) != -1) {
			return 1;
		}
		if (TWO_POINT_CHARS.indexOf(c) != -1) {
			return 2;
		}
		if (THREE_POINT_CHARS.indexOf(c) != -1) {
			return 3;
		}
		if (FOUR_POINT_CHARS.indexOf(c) != -1) {
			return 4;
		}
		if (FIVE_POINT_CHARS.indexOf(c) != -1) {
			return 5;
		}
		if (EIGHT_POINT_CHARS.indexOf(c) != -1) {
			return 8;
		}
		if (TEN_POINT_CHARS.indexOf(c) != -1) {
			return 10;
		}
		return 0;
	}

}
