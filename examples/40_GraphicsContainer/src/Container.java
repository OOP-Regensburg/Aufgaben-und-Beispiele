import java.util.ArrayList;

import de.ur.mi.graphics.GraphicsObject;

public class Container {

	private ArrayList<GraphicsObject> objects;

	public Container() {
		objects = new ArrayList<GraphicsObject>();
	}
	
	public void addObject(GraphicsObject object) {
		objects.add(object);
	}

	public void draw() {
		for (GraphicsObject object : objects) {
			object.draw();
		}
	}
}
