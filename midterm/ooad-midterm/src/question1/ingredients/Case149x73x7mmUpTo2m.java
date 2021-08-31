/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Case149x73x7mmUpTo2m implements Case {

	public final String size = "149x73x7.7";
	public final boolean waterProof = true;
	public final double depth = 2;
	public final boolean dustproof = false;
	public final String type = "aluminum";

	@Override
	public String toString() {
		return this.size + " mm - waterproof (up to " + this.depth + " m) - " + this.type + " case";
	}
}
