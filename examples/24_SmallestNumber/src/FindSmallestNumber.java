import acm.program.ConsoleProgram;

/*
 * This program read several numbers into an array and
 * calculates the smallest value
 */
@SuppressWarnings("serial")
public class FindSmallestNumber extends ConsoleProgram {
	
	private static final int MAX_NUMBERS = 10;
	private int[] numberArray;
	
	public void run() {
		numberArray = new int[MAX_NUMBERS];
		readNumbers();
		int smallestNumber = getSmallestNumber(numberArray);
		println("Smallest Number was: " + smallestNumber);
	}
	
	private void readNumbers() {
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = readInt("Enter Number: ");
		}
	}
	
	private int getSmallestNumber(int[] numbers) {
		int smallestNumber = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			int currentNumber = numbers[i];
			if(currentNumber < smallestNumber) {
				smallestNumber = currentNumber;
			}
		}
		return smallestNumber;
	}

}
