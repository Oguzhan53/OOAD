/**
 * 
 */
package question1;

import java.util.Iterator;

/**
 * Composite array component class which it is also array.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
@SuppressWarnings("rawtypes")
public class DataArray extends ArrayComponent {
	private int length;
	private ArrayComponent[][] arrayComponent;

	public ArrayComponent[][] getArrayComponent() {
		return arrayComponent;
	}

	public void setArrayComponent(ArrayComponent[][] arrayComponent) {
		this.arrayComponent = arrayComponent;
	}

	public int getlength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void print() {
		Iterator iter = createIterator();
		while (iter.hasNext()) {
			ArrayComponent com = (ArrayComponent) iter.next();
			com.print();
		}

	}

	@Override
	public Iterator createIterator() {
		return new CompositeIterator(new ArrayCompItereator(arrayComponent));
	}
}
