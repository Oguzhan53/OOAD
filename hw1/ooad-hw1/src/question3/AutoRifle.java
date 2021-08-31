/**
 * 
 */
package question3;

/**
 * Armor Equipment Class(Auto Rifle)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class AutoRifle extends EquipmentDecorator {

	private Armor armor;

	public AutoRifle(Armor armor) {
		this.armor = armor;
	}

	@Override
	public String getName() {
		return this.armor.getName() + ", Auto rifle";
	}

	@Override
	public double cost() {
		return 30 + this.armor.cost();
	}

	@Override
	public double weight() {
		return 1.5 + this.armor.weight();
	}

}
