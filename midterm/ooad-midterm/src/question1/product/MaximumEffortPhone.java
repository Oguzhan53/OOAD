/**
 * 
 */
package question1.product;

import question1.enums.Model;
import question1.ingredientFactory.PhoneIngredientFactory;

/**
 * Maxýmum Effort Model
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class MaximumEffortPhone extends Phone {

	private PhoneIngredientFactory phoneIngredientFactory;

	public MaximumEffortPhone(PhoneIngredientFactory phoneIngredientFactory) {
		this.phoneIngredientFactory = phoneIngredientFactory;
		this.setModel(Model.MAXIMUMEFFORT);
	}

	@Override
	public void producePhone() {
		System.out.println(this.getModel() + "  is being produced for " + this.getRegion());
		this.display = phoneIngredientFactory.createDisplay(getModel());
		this.battery = phoneIngredientFactory.createBattery(getModel());
		this.cpuRam = phoneIngredientFactory.createCpuRam(getModel());
		this.storage = phoneIngredientFactory.createStorage(getModel());
		this.camera = phoneIngredientFactory.createCamera(getModel());
		this.phonecase = phoneIngredientFactory.createCase(getModel());
		System.out.println("---- Components combined ---- ");
	}

}
