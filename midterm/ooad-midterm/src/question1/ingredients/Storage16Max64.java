/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Storage16Max64 implements Storage {

	private final int storage = 16;
	private final String support = "MýcroSD";
	private final int max = 64;

	@Override
	public String toString() {
		return this.storage + " GB storage - " + this.support + " support (max = " + this.max + " GB )";
	}
}
