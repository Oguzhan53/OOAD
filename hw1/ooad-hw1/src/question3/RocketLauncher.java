/**
 * 
 */
package question3;

/**
 * Armor Equipment Class(Rocket Launcher)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class RocketLauncher extends EquipmentDecorator {

	public Armor armor;

	public RocketLauncher(Armor armor) {
		this.armor = armor;
	}

	@Override
	public String getName() {
		return this.armor.getName() + ", Rocket launcher";
	}

	@Override
	public double cost() {
		return 150 + this.armor.cost();
	}

	@Override
	public double weight() {
		return 7.5 + this.armor.weight();
	}

}
