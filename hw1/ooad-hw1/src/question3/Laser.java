/**
 * 
 */
package question3;

/**
 * Armor Equipment Class(Laser)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Laser extends EquipmentDecorator {

	private Armor armor;

	public Laser(Armor armor) {
		this.armor = armor;
	}

	@Override
	public String getName() {
		return this.armor.getName() + ", Laser";
	}

	@Override
	public double cost() {
		return 200 + this.armor.cost();
	}

	@Override
	public double weight() {
		return 5.5 + this.armor.weight();
	}

}
