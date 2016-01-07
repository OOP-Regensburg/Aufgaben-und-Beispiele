package passwordchecker;
public class PasswordChecker {

	private static final int MIN_LENGTH = 8;
	private static final int MIN_LETTERS = 2;
	private static final int MIN_DIGITS = 2;
	private static final int MIN_UPPERCASE_LETTERS = 1;
	private static final int MIN_LOWERCASE_LETTERS = 1;

	public static boolean isCorrectPassword(String str) {
		if (!isLongEnough(str)) {
			return false;
		}
		if (!containsEnoughLetters(str)) {
			return false;
		}
		if (!containsEnoughDigits(str)) {
			return false;
		}
		if (!hasSpecialCharacter(str)) {
			return false;
		}
		if (!containsEnoughUpperCaseLetters(str)) {
			return false;
		}
		if (!containsEnoughLowerCaseLetters(str)) {
			return false;
		}
		return true;
	}

	private static boolean containsEnoughLowerCaseLetters(String str) {
		return numberOfLowerCaseLetters(str) >= MIN_LOWERCASE_LETTERS;
	}

	private static boolean containsEnoughUpperCaseLetters(String str) {
		return numberOfUpperCaseLetters(str) >= MIN_UPPERCASE_LETTERS;
	}

	private static boolean containsEnoughDigits(String str) {
		return numberOfDigits(str) >= MIN_DIGITS;
	}

	private static boolean containsEnoughLetters(String str) {
		return numberOfLetters(str) >= MIN_LETTERS;
	}

	private static boolean isLongEnough(String str) {
		return str.length() >= MIN_LENGTH;
	}

	private static boolean hasSpecialCharacter(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!isLetter(c) && !isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	private static int numberOfLetters(String str) {
		return numberOfUpperCaseLetters(str) + numberOfLowerCaseLetters(str);
	}

	private static int numberOfUpperCaseLetters(String str) {
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isUpperCaseLetter(str.charAt(i))) {
				number++;
			}
		}
		return number;
	}

	private static int numberOfLowerCaseLetters(String str) {
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isLowerCaseLetter(str.charAt(i))) {
				number++;
			}
		}
		return number;
	}

	private static int numberOfDigits(String str) {
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isDigit(str.charAt(i))) {
				number++;
			}
		}
		return number;
	}

	private static boolean isDigit(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isLetter(char c) {
		return isUpperCaseLetter(c) || isLowerCaseLetter(c);
	}

	private static boolean isUpperCaseLetter(char c) {
		if (c >= 'A' && c <= 'Z') {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isLowerCaseLetter(char c) {
		if (c >= 'a' && c <= 'z') {
			return true;
		} else {
			return false;
		}
	}

}
