package question1;

import java.util.Iterator;

/**
 * Component abstract class. Array components derives from this class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public abstract class ArrayComponent {

	/**
	 * This method adds the new element to array
	 * 
	 * @param arrayComponent New array component
	 */
	public void add(ArrayComponent arrayComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method removes the new element from array
	 * 
	 * @param arrayComponent New array component
	 */
	public void remove(ArrayComponent arrayComponent) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method prints array component context
	 */
	public void print() {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method creates iterator for array component
	 * 
	 * @return Array component iterator
	 */
	@SuppressWarnings("rawtypes")
	abstract Iterator createIterator();

}
