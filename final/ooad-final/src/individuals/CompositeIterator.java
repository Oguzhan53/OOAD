/**
 * 
 */
package individuals;

import java.util.Iterator;
import java.util.Stack;

/**
 * Iterator class that iterate society.
 * 
 * @author Oguzhan SEZGIN
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
			IndividualComponent component = (IndividualComponent) iterator.next();
			if (component instanceof IndividualArray) {
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
		Iterator iterator = (Iterator) stack.peek();
		// IndividualComponent component = (IndividualComponent) iterator.next();
		iterator.remove();

	}

}
