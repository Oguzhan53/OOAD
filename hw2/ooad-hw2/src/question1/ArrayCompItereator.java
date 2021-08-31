/**
 * 
 */
package question1;

import java.util.Iterator;

/**
 * Iterator class that iterate array component if it is also array.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */

@SuppressWarnings("rawtypes")
public class ArrayCompItereator implements Iterator {

	private ArrayComponent[][] components;
	private int position;
	private int inc;
	private int dec;
	private int visited;
	private int flag;

	public ArrayCompItereator(ArrayComponent[][] components) {
		this.components = components;
		position = 0;
		inc = 0;
		dec = components.length - 1;
		visited = 0;
		flag = 0;
	}

	@Override
	public boolean hasNext() {
		if (visited >= components.length * components.length)
			return false;
		else
			return true;
	}

	@Override
	public ArrayComponent next() {
		int i = 0, j = 0, len = components.length;
		visited++;
		ArrayComponent returnComponent;
		if (flag == 0) {
			j = position;
			i = inc;
			returnComponent = components[i][j];
			if (j == len - inc - 1) {
				flag = 1;
				position = inc;
			}
			position++;
			return returnComponent;
		}
		if (flag == 1) {
			i = position;
			j = dec;
			returnComponent = components[i][j];
			if (i == len - inc - 1) {
				flag = 2;
				position = dec - 2;
			}
			position++;
			return returnComponent;
		}
		if (flag == 2) {
			i = len - inc - 1;
			j = position;
			returnComponent = components[i][j];
			if (j == len - dec - 1) {
				flag = 3;
				position = dec;
			}
			position--;
			return returnComponent;
		}
		if (flag == 3) {
			i = position;
			j = inc;
			returnComponent = components[i][j];
			if (i == len - dec) {
				flag = 0;
				inc++;
				dec--;
				position = inc + 1;
			}
			position--;
			return returnComponent;
		}

		return null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
