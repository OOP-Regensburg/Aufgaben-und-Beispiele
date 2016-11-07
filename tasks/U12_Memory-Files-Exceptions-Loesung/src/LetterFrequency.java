import acm.program.ConsoleProgram;
import de.ur.mi.graphicsapp.GraphicsApp;

import java.io.File;

/**
 * Created by Alexander Bazo on 08/01/16.
 */
public class LetterFrequency extends ConsoleProgram {

    @Override
    public void run() {
        println("Starting LetterFrequencyTool");
        LetterFrequencyCounter counter = new LetterFrequencyCounter("/data/assets/alice_wonderland.txt");
        counter.readFile();
        counter.computeLetterFrequency();
        println(counter.getFormattedOutput());
    }

}
