/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Display32BitAndFivePointFiveInch implements Display {

	private final double inches = 5.5;
	private final int bit = 32;

	@Override
	public String toString() {
		return this.inches + " inches - " + this.bit + " bit display";
	}

}
