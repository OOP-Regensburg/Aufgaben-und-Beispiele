import acm.program.ConsoleProgram;


@SuppressWarnings("serial")
public class CaesarApp extends ConsoleProgram {
	
	public void run() {
		testStringEncoding();
		testStringDecoding();
	}

	private void testStringEncoding() {
		String input = readLine("Enter string: ");
		int keyShift = readInt("Enter key shift distance: ");
		
		CodeHelper codeHelper = new CodeHelper(keyShift);
		String result = codeHelper.encodeString(input);
		
		println("Encodede string: " + result);
	}
	
	private void testStringDecoding() {
		String input = readLine("Enter string: ");
		int keyShift = readInt("Enter key shift distance: ");
		
		CodeHelper codeHelper = new CodeHelper(keyShift);
		String result = codeHelper.decodeString(input);
		
		println("Decodede string: " + result);
	}

}
