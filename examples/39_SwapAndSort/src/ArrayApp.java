import acm.program.ConsoleProgram;


@SuppressWarnings("serial")
public class ArrayApp extends ConsoleProgram {
	
	private int[] values = {5,7,2,3,8,9,0,1,4,6};
	
	public void run() {
		printArray(values, "Source");
		swapElements(values[0], values[1]);
		printArray(values, "After buggy swap");
		swapElements(values, 0, 1);
		printArray(values, "After working swap");
		sortArray(values);
		printArray(values, "After sorting");
	}
	
	
	/**
	 * This method swaps to elements in an integer array (Buggy implementation)
	 * 
	 * @param x First element to be swapped
	 * @param y Second element to  be swapped
	 */
	private void swapElements(int x, int y) {
		int tmp = x;
		x = y;
		y = tmp;
	}
	
	/**
	 * This method swaps to elements in an integer array (Buggy implementation)
	 * 
	 * @param array Array containing the values 
	 * @param x Index of first element to be swapped
	 * @param y Index of second element to  be swapped
	 */
	private void swapElements(int[] array, int indexX, int indexY) {
		int tmp = array[indexX];
		array[indexX] = array[indexY];
		array[indexY] = tmp;
	}
	
	/**
	 * This method sorts all elements in an integer array ascending
	 * 
	 * @param array Array to be sorted
	 */
	private void sortArray(int[] array) {
		for(int end = array.length-1;  end > 0; end--) {
			for(int index = 0; index < end; index++) {
				int currentValue = array[index];
				int nextValue = array[index+1];
				if(currentValue > nextValue) {
					swapElements(array, index, index+1);
				}
			}
		}
	}
	
	private void printArray(int[] array, String msg) {
		print(msg+": ");
		for(int i = 0; i < array.length; i++) {
			print(array[i]);
			if(i == array.length - 1) {
				print(".");
			} else {
				print(", ");
			}
		}
		print("\n");
	}

}
