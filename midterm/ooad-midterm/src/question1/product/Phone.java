/**
 * 
 */
package question1.product;

import question1.enums.Model;
import question1.enums.Region;
import question1.ingredients.Battery;
import question1.ingredients.Camera;
import question1.ingredients.Case;
import question1.ingredients.CpuRam;
import question1.ingredients.Display;
import question1.ingredients.Storage;

/**
 * Phone models base class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public abstract class Phone {

	private Model model;
	private Region region;
	protected Display display;
	protected Battery battery;
	protected CpuRam cpuRam;
	protected Storage storage;
	protected Camera camera;
	protected Case phonecase;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public void test() {
		System.out.println("Phone is being tested.");
	}

	public void box() {
		System.out.println("Phone in its box");
	}

	public void ship() {
		System.out.println("Phone has been shipped");
	}

	/**
	 * This method creates phone
	 */
	public abstract void producePhone();

}
