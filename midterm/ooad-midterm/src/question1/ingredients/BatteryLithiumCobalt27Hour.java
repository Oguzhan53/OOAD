/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class BatteryLithiumCobalt27Hour implements Battery {

	private final String name = "Lithium-Cobalt";
	private final int hour = 27;
	private final int milliamperes = 3600;

	@Override
	public String toString() {
		return this.hour + "h and " + this.milliamperes + "mAh " + this.name + " battery";
	}

}
