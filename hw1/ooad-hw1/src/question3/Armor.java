/**
 * 
 */
package question3;

/**
 * Other classes are derived from this class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public abstract class Armor {

	String name;

	/**
	 * This method return armor description
	 * 
	 * @return Armor name
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns armor cost
	 * 
	 * @return Armor coast
	 */
	public abstract double cost();

	/**
	 * This method returns armors weight
	 * 
	 * @return
	 */
	public abstract double weight();

}
