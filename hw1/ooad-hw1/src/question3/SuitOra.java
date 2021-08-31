/**
 * 
 */
package question3;

/**
 * Suit Class (Ora)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class SuitOra extends Armor {

	public SuitOra() {
		this.setName("Suit Ora with");
	}

	@Override
	public double cost() {
		return 1500;
	}

	@Override
	public double weight() {
		return 30;
	}

}
