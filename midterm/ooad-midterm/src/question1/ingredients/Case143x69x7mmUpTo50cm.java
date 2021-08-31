/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Case143x69x7mmUpTo50cm implements Case {

	public final String size = "143x69x7.3";
	public final boolean waterProof = true;
	public final double depth = 0.5;
	public final boolean dustproof = false;
	public final String type = "plastic";

	@Override
	public String toString() {
		return this.size + " mm - waterproof (up to " + this.depth + " m) - " + this.type + " case";
	}
}
