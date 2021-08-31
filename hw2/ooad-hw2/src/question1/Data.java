/**
 * 
 */
package question1;

import java.util.Iterator;

/**
 * Leaf array component class which has only one data.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Data extends ArrayComponent {

	private int data;

	public Data(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public void print() {
		System.out.print(data + " ");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator createIterator() {
		return new NullIterator();
	}

}
