/**
 * 
 */
package question3;

/**
 * Armor Equipment Class(Flame Thrower)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Flamethrower extends EquipmentDecorator {

	private Armor armor;

	public Flamethrower(Armor armor) {
		this.armor = armor;
	}

	@Override
	public String getName() {
		return this.armor.getName() + ", Flame thrower";
	}

	@Override
	public double cost() {
		return 50 + this.armor.cost();
	}

	@Override
	public double weight() {
		return 2 + this.armor.weight();
	}

}
