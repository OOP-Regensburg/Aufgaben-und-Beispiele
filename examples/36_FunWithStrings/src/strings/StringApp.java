package strings;

import strings.StringHelper.CaseMode;
import acm.program.ConsoleProgram;

@SuppressWarnings("serial")
public class StringApp extends ConsoleProgram {
	
	public void run() {
		testCharCounter();
		testStringReplacer();
		testStringReverse();
		testPalindromCheck();
		testTokenizer();
	}
	
	private void testCharCounter() {
		println("Mode: count characters");
		String input = readLine("Enter string: ");
		StringHelper helper = new StringHelper(input);
		println("Upper case characters: " + helper.countChars(CaseMode.UPPER_CASE));
		println("Lower case characters: " + helper.countChars(CaseMode.LOWER_CASE));
		println("#############################################");
		println();
	}
	
	private void testStringReplacer() {
		println("Mode: replace substring");
		String input = readLine("Enter string: ");
		String token = readLine("Enter substring: ");
		String replacement = readLine("Enter replacement: ");
		StringHelper helper = new StringHelper(input);
		String output = helper.replaceSubstring(token, replacement);
		println(output);
		println("#############################################");
		println();
	}
	
	private void testStringReverse() {
		println("Mode: reverse string");
		String input = readLine("Enter string: ");
		StringHelper helper = new StringHelper(input);
		String output = helper.reverseString();
		println(output);
		println("#############################################");
		println();
	}
	
	private void testPalindromCheck() {
		println("Mode: palindrom check");
		String input = readLine("Enter string: ");
		StringHelper helper = new StringHelper(input);
		boolean result = helper.isPalindrom();
		if(result) {
			println(input + " is a palindrom!");
		} else {
			println(input + " is not a palindrom!");
		}
		println("#############################################");
		println();
	}
	
	private void testTokenizer() {
		println("Mode: tokenizer");
		String input = readLine("Enter string: ");
		String seperator = readLine("Enter seperator: ");
		StringHelper helper = new StringHelper(input);
		String result = helper.getTokens(seperator);
		println("Tokens: " + result);
		println("#############################################");
		println();
	}
	
}
