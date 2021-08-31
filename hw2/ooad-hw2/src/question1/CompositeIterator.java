/**
 * 
 */
package question1;

import java.util.Iterator;
import java.util.Stack;

/**
 * Iterator class that iterate array.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CompositeIterator implements Iterator {

	Stack stack = new Stack();

	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}

	@Override
	public Object next() {
		if (hasNext()) {
			Iterator iterator = (Iterator) stack.peek();
			ArrayComponent component = (ArrayComponent) iterator.next();
			if (component instanceof DataArray) {
				stack.push(component.createIterator());
			}
			return component;
		} else {
			return null;
		}
	}

	@Override
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
