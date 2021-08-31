/**
 * 
 */
package question1;

import java.util.Iterator;

/**
 * Component class that it can has composite and leaf classes.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class MyArray {

	private ArrayComponent array;

	public MyArray(ArrayComponent array) {
		this.array = array;
	}

	@SuppressWarnings("rawtypes")
	public void print() {
		Iterator iterator = array.createIterator();
		while (iterator.hasNext()) {
			ArrayComponent arraycomponent = (ArrayComponent) iterator.next();
			try {
				arraycomponent.print();
			} catch (UnsupportedOperationException e) {
			}
		}
	}

}
