/**
 * 
 */
package question1.ingredientFactory;

import question1.enums.Model;
import question1.ingredients.Battery;
import question1.ingredients.Camera;
import question1.ingredients.Case;
import question1.ingredients.CpuRam;
import question1.ingredients.Display;
import question1.ingredients.Storage;

/**
 * Ingredient Factor Interface
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public interface PhoneIngredientFactory {

	/**
	 * This method crates display for phone
	 * 
	 * @param model Phone model
	 * @return Display
	 */
	public Display createDisplay(Model model);

	/**
	 * This method crates battery for phone
	 * 
	 * @param model Phone model
	 * @return Battery
	 */
	public Battery createBattery(Model model);

	/**
	 * This method crates cpu and ram for phone
	 * 
	 * @param model Phone model
	 * @return Cpu&Ram
	 */
	public CpuRam createCpuRam(Model model);

	/**
	 * This method crates storage for phone
	 * 
	 * @param model Phone model
	 * @return Storage
	 */
	public Storage createStorage(Model model);

	/**
	 * This method crates camera for phone
	 * 
	 * @param model Phone model
	 * @return Camera
	 */
	public Camera createCamera(Model model);

	/**
	 * This method crates case for phone
	 * 
	 * @param model Phone model
	 * @return Case
	 */
	public Case createCase(Model model);

}
