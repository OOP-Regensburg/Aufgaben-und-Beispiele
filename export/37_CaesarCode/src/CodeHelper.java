public class CodeHelper {

	private int keyShift;

	public CodeHelper(int keyShift) {
		this.keyShift = keyShift;
	}

	public String encodeString(String string) {
		String result = "";
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			result += encodeChar(currentChar);
		}
		return result;
	}

	public String decodeString(String string) {
		String result = "";
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			result += decodeChar(currentChar);
		}
		return result;
	}

	private char encodeChar(char ch) {
		if (!Character.isLetter(ch)) {
			return ch;
		}
		char newChar = (char) (Character.toUpperCase(ch) + keyShift);
		if (newChar > 'Z') {
			newChar = (char) ('A' + (newChar - 'Z') - 1);
		}
		return newChar;
	}

	private char decodeChar(char ch) {
		if (!Character.isLetter(ch)) {
			return ch;
		}
		char newChar = (char) (Character.toUpperCase(ch) - keyShift);
		if (newChar < 'A') {
			newChar = (char) ('Z' - ('A' - newChar) - 1);
		}
		return newChar;
	}

}
