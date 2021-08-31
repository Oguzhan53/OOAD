/**
 * 
 */
package question3;

/**
 * Suit Class (Tor)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class SuitTor extends Armor {

	public SuitTor() {
		this.setName("Suit Tor with");
	}

	@Override
	public double cost() {
		return 5000;
	}

	@Override
	public double weight() {
		return 50;
	}

}
