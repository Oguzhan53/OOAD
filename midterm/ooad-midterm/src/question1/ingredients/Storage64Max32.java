/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Storage64Max32 implements Storage {

	private final int storage = 64;
	private final String support = "M?croSD";
	private final int max = 32;

	@Override
	public String toString() {
		return this.storage + " GB storage - " + this.support + " support (max = " + this.max + " GB )";
	}
}
