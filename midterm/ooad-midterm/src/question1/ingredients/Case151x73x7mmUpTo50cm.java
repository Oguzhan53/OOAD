/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Case151x73x7mmUpTo50cm implements Case {

	public final String size = "151x73x7.7";
	public final boolean waterProof = true;
	public final double depth = 0.5;
	public final boolean dustproof = true;
	public final String type = "aluminum";

	@Override
	public String toString() {
		return this.size + " mm - waterproof (up to " + this.depth + " m) - dustproof - " + this.type + " case";
	}

}
