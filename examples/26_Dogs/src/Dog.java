import de.ur.mi.graphics.Color;
import de.ur.mi.util.RandomGenerator;

/**
 * 
 * @author Alexander Bazo
 * @version 1.0
 * 
 * A class representing a dog
 *
 */
public class Dog {
	/**
	 * Members: Defining the status and properties of an instance of Dog-Class 
	 */
	private Color furColor;
	private boolean hungry;
	
	/**
	 * Constructor: Used to create instances of Dog-Class
	 * @param furColor The color of the dog's fur
	 */
	public Dog(Color furColor) {
		this.furColor = furColor;
		hungry = true;
	}
	
	/**
	 * A public method: Used to envoke a certain behaviour
	 */
	public void eat() {
		if(hungry) {
			hungry = false;
		}
	}
	
	/**
	 * A public method: Used to envoke a certain behaviour
	 */
	public String bark() {
		return "Wuff!";
	}
	
	/**
	 * A public method: Used to envoke a certain behaviour
	 */
	public void fetch() {
		boolean hasStick = false;
		runToStick();
		
		while(!hasStick) {
			hasStick = tryToPickUpStick();
		}
		runToOwner();
	}
	

	/**
	 * A public getter: Used to return/read a property
	 */
	public Color getFurColor() {
		return furColor;
	}
	
	
	/**
	 * A private method: Used for internal processing
	 */
	private void runToStick() {
		//TODO: Implement
	}
	
	/**
	 * A private method: Used for internal processing
	 */
	private void runToOwner() {
		//TODO: Implement
	}
	
	/**
	 * /**
	 * A private method: Used for internal processing
	 * @return A boolean value indicating if the dog succeeded in picking up the stick
	 */
	private boolean tryToPickUpStick() {
		return RandomGenerator.getInstance().nextBoolean();
	}
	
	
}
