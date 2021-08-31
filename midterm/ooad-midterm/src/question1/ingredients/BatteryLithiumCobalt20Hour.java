/**
 * 
 */
package question1.ingredients;

/**
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class BatteryLithiumCobalt20Hour implements Battery {

	private final String name = "Lithium-Cobalt";
	private final int hour = 20;
	private final int milliamperes = 2800;

	@Override
	public String toString() {
		return this.hour + "h and " + this.milliamperes + "mAh " + this.name + " battery";
	}
}
