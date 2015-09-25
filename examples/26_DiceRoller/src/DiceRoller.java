import de.ur.mi.util.RandomGenerator;
import acm.program.ConsoleProgram;


@SuppressWarnings("serial")
public class DiceRoller extends ConsoleProgram {
	
	private RandomGenerator random;
	private int DICE_LOWEST_RESULT = 1;
	private int DICE_HIGHTEST_RESULT = 6;
	
	public void run() {
		random = RandomGenerator.getInstance();
		int diceCount = readInt("Mit wie vielen Würfeln soll ich würfeln? ");
		int maxResult = diceCount * DICE_HIGHTEST_RESULT;
		
		int rolls = rollDicesForMaxResult(diceCount, maxResult);
		println("Maximales Ergebnis (" + maxResult + ") nach " + rolls + " Würfen.");
	}

	private int rollDicesForMaxResult(int diceCount, int maxResults) {
		int result = 0;
		int rolls = 0;
		while(result != maxResults) {
			result = 0;
			for(int i=0; i<diceCount; i++) {
				result += random.nextInt(DICE_LOWEST_RESULT, DICE_HIGHTEST_RESULT);
			}
			rolls++;
		}
		return rolls;
	}

}