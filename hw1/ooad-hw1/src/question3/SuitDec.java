/**
 * 
 */
package question3;

/**
 * Suit Class (Dec)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class SuitDec extends Armor {

	
	public SuitDec() {
		this.setName("Suit Dec with");
	}
	
	@Override
	public double cost() {
		return 500;
	}

	@Override
	public double weight() {
		return 25;
	}

}
