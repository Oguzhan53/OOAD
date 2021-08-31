/**
 * 
 */
package individuals;

import java.util.Iterator;

/**
 * Null iterator class that if individual component array has just one data call this
 * iterator.
 * 
 * @author Oguzhan SEZGIN 
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
