package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Display24BitAndFourInch implements Display {
	private final double inches = 4.5;
	private final int bit = 24;

	@Override
	public String toString() {
		return this.inches + " inches - " + this.bit + " bit display";
	}

}
