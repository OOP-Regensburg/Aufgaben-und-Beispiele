package numberdelimiter;
public class NumberDelimiter {

	public static final char SEPARATOR_COMMA = ',';
	public static final char SEPARATOR_POINT = '.';
	public static final char SEPARATOR_SPACE = ' ';

	private char separator = SEPARATOR_COMMA;

	public NumberDelimiter(char separator) {
		switch (separator) {
		case SEPARATOR_COMMA:
			this.separator = separator;
			break;
		case SEPARATOR_POINT:
			this.separator = separator;
			break;
		case SEPARATOR_SPACE:
			this.separator = separator;
			break;
		default:
			this.separator = SEPARATOR_COMMA;
		}
	}

	public String addSeparatorToNumericString(String number) {
		if (number.length() < 4) {
			return number;
		}

		String result = "";
		int len = number.length();
		int nDigits = 0;
		for (int i = len - 1; i >= 0; i--) {
			result = number.charAt(i) + result;
			nDigits++;
			if (((nDigits % 3) == 0) && (i > 0)) {
				result = separator + result;
			}
		}
		return result;
	}

}