/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class BatteryLithiumBoron16Hour implements Battery {

	private final String name = "Lithium-Boron";
	private final int hour = 16;
	private final int milliamperes = 2000;

	@Override
	public String toString() {
		return this.hour + "h and " + this.milliamperes + "mAh " + this.name + " battery";
	}

}
