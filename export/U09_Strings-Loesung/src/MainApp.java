import acm.program.ConsoleProgram;
import numberdelimiter.NumberDelimiter;
import passwordchecker.PasswordChecker;
import remover.Remover;
import scrabble.ScoreChecker;
import sun.font.TrueTypeFont;


public class MainApp extends ConsoleProgram {

    @Override
    public void run() {
        testDelimiterApp();
        testPasswordChecker();
        testRemover();
        testScoreChecker();
    }

    private void testDelimiterApp() {
        println("Testing NumberDelimiter");
        NumberDelimiter delimiter = new NumberDelimiter(NumberDelimiter.SEPARATOR_COMMA);
        while (true) {
            String input = readLine("Enter a numeric string: ");
            if (input.length() == 0) {
                break;
            }
            String result = delimiter.addSeparatorToNumericString(input);
            println(result);
        }
    }

    private void testPasswordChecker() {
        println("Testing PasswordChecker");
        while (true) {
            String input = readLine("Enter password:");
            if (input.length() == 0) {
                break;
            }
            boolean result = PasswordChecker.isCorrectPassword(input);
            if(result == true) {
                println(input + " is a valid password.");
            } else {
                println(input + " is not a valid password.");
            }
        }
    }

    private void testRemover() {
        println("Testing Remover");
        while (true) {
            String input = readLine("Enter String:");
            String characterString = readLine("Enter Character to be removed: ");
            if (input.length() == 0 || characterString.length() == 0) {
                break;
            }
            char character = characterString.charAt(0);
            String result = Remover.removeOccurrences(input, character);
            println(result);
        }
    }

    private void testScoreChecker() {
        println("Testing ScoreChecker");
        while (true) {
            String input = readLine("Enter word:");
            if (input.length() == 0) {
                break;
            }
            int result = ScoreChecker.getScore(input);
            println(input + " [" + result + " points]");
        }
    }
}
