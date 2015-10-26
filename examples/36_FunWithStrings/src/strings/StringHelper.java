package strings;

import java.util.StringTokenizer;

/** 
 * This utility class provides several methods to analyze and manipulate Strings.
 * The input value is passed to the constructor. All methods operate on that input value.
 * 
 * @author Alexander Bazo
 * @version 1.0
 *
 */
public class StringHelper {
	
	private String input;
	
	public StringHelper(String input) {
		this.input = input;
	}
	
	public String getInput() {
		return input;
	}

	/**
	 * Counts upper or lower characters in input
	 * @param mode Enum used to switch between differen counting modes (Upper, Lower, All)
	 * @return Number of counted characters
	 */
	public int countChars(CaseMode mode) {
		switch(mode) {
		case UPPER_CASE:
			return countUpperCaseChars();
		case LOWER_CASE:
			return countLowerCaseChars();
		case ALL: 
			return countUpperCaseChars() + countLowerCaseChars();
		default:
			return 0;
		}
	}
	
	/**
	 * Replaces a given token with the replacement value.
	 * @param token Token to be replaced in the input string
	 * @param replacement Token to be used as a replacement
	 * @return A new string where the first occurrence of token is
	 * replaced with replacement
	 */
	public String replaceSubstring(String token, String replacement) {
		int indexOfToken = input.indexOf(token);
		if(indexOfToken == -1) {
			return input;
		} else {
			return input.substring(0, indexOfToken) + replacement + input.substring(indexOfToken + token.length());
		}
	}
	
	
	/**
	 * Reverses the input string
	 * @return The input string in reversed order
	 */
	public String reverseString() {
		String result = "";
		for(int i=0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			result = currentChar + result;
		}
		return result;
	}
	
	/**
	 * Checks if the input string is a palindrom
	 * @return True if the input string is a palindrom
	 */
	public boolean isPalindrom() {
		String original = toUpperCase(input);
		String reversed = reverseString();
		return original.equals(toUpperCase(reversed));
	}
	
	/**
	 * DEMO: Separates the input string along the given separator
	 * @param separator Token to be used as a separator
	 * @return A somehow tokenized representation of the string where whitespace mark the different tokens
	 */
	public String getTokens(String separator) {
		String result = "";
		StringTokenizer tokenizer = new StringTokenizer(input, separator);
		while(tokenizer.hasMoreTokens()) {
			result += tokenizer.nextToken() + " ";
		}
		return result;
	}
	
	private String toUpperCase(String input) {
		String result = "";
		for(int i=0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			result += Character.toUpperCase(currentChar);
		}
		return result;
	}
	
	private int countUpperCaseChars() {
		int result = 0;
		for(int i=0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if(Character.isUpperCase(currentChar)) {
				result++;
			}
		}
		return result;
	}

	private int countLowerCaseChars() {
		int result = 0;
		for(int i=0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if(Character.isLowerCase(currentChar)) {
				result++;
			}
		}
		return result;
	}

	public enum CaseMode {
		UPPER_CASE,
		LOWER_CASE,
		ALL
	}
}
