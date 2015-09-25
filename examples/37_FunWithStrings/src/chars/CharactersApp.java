package chars;

import acm.program.ConsoleProgram;

@SuppressWarnings("serial")
public class CharactersApp extends ConsoleProgram {
	
	
	public void run() {
		String input = readLine("Enter String with upper case characters: ");
		String output = stringToLowerCase(input);
		println("Result: " + output);	
	}
	
	private String stringToLowerCase(String input) {
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			output += charToLowerCase(currentChar);
		}
		return output;
	}
	
	private char charToLowerCase(char ch) {
		if(ch >= 'A' && ch <= 'Z') {
			return (char) (ch - 'A' + 'a');
		}
		return ch;
	}
}
