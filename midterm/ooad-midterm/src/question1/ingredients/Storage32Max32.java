/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Storage32Max32 implements Storage {

	private final int storage = 32;
	private final String support = "MýcroSD";
	private final int max = 32;

	@Override
	public String toString() {
		return this.storage + " GB storage - " + this.support + " support (max = " + this.max + " GB )";
	}
}
