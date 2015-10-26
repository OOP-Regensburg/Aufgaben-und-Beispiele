/**
 * @author Alexander Bazo
 * An interface defining methods, which must be implemented by all 
 * eatable objects. The behavior (the result of eating it) differs from 
 * object to object. All classes that implement this interface can be accessed
 * via a common interface (public void eat()). The actual implementation of that
 * method may be different for each class.
 */
public interface Eatable {
	public void eat();
}
