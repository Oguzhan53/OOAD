/**
 * 
 */
package question1;

import java.util.Iterator;

/**
 * Null iterator class that if array component has just one data call this
 * iterator.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
@SuppressWarnings("rawtypes")
public class NullIterator implements Iterator {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
