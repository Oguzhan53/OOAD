/**
 * 
 */
package question1.ingredientFactory;

import question1.enums.Model;
import question1.ingredients.Battery;
import question1.ingredients.BatteryLithiumIon16Hour;
import question1.ingredients.BatteryLithiumIon20Hour;
import question1.ingredients.BatteryLithiumIon27Hour;
import question1.ingredients.Camera;
import question1.ingredients.Camera12F5RMpx3;
import question1.ingredients.Camera12F8RMpx3;
import question1.ingredients.Camera8F5RMpx3;
import question1.ingredients.Case;
import question1.ingredients.Case143x69x7mmUpTo1m;
import question1.ingredients.Case149x73x7mmUpTo1m;
import question1.ingredients.Case151x73x7mmUpTo1m;
import question1.ingredients.CpuRam;
import question1.ingredients.CpuRam4Core4GB;
import question1.ingredients.CpuRam4Core6GB;
import question1.ingredients.CpuRam4Core8GB;
import question1.ingredients.Display;
import question1.ingredients.Display24BitAndFivePointFiveInch;
import question1.ingredients.Display24BitAndFivePointThreeInch;
import question1.ingredients.Display24BitAndFourInch;
import question1.ingredients.Storage;
import question1.ingredients.Storage16Max64;
import question1.ingredients.Storage32Max64;
import question1.ingredients.Storage64Max64;

/**
 * EU Ingredient Factory Class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class EUPhoneIngredientFactory implements PhoneIngredientFactory {

	@Override
	public Display createDisplay(Model model) {
		Display display = null;
		switch (model) {
		case MAXIMUMEFFORT:
			display = new Display24BitAndFivePointFiveInch();
			break;

		case IFLASDELUXE:
			display = new Display24BitAndFivePointThreeInch();
			break;

		case IIAMANIFLAS:
			display = new Display24BitAndFourInch();
			break;
		default:
			break;
		}
		System.out.println(display.toString() + " created");
		return display;

	}

	@Override
	public Battery createBattery(Model model) {
		Battery battery = null;
		switch (model) {
		case MAXIMUMEFFORT:
			battery = new BatteryLithiumIon27Hour();
			break;

		case IFLASDELUXE:
			battery = new BatteryLithiumIon20Hour();
			break;

		case IIAMANIFLAS:
			battery = new BatteryLithiumIon16Hour();
			break;
		default:
			break;
		}
		System.out.println(battery.toString() + " created");
		return battery;
	}

	@Override
	public CpuRam createCpuRam(Model model) {
		CpuRam cpuRam = null;
		switch (model) {
		case MAXIMUMEFFORT:
			cpuRam = new CpuRam4Core8GB();
			break;

		case IFLASDELUXE:
			cpuRam = new CpuRam4Core6GB();
			break;

		case IIAMANIFLAS:
			cpuRam = new CpuRam4Core4GB();
			break;
		default:
			break;
		}
		System.out.println(cpuRam.toString() + " created");
		return cpuRam;
	}

	@Override
	public Storage createStorage(Model model) {
		Storage storage = null;
		switch (model) {
		case MAXIMUMEFFORT:
			storage = new Storage64Max64();
			break;

		case IFLASDELUXE:
			storage = new Storage32Max64();
			break;

		case IIAMANIFLAS:
			storage = new Storage16Max64();
			break;
		default:
			break;
		}
		System.out.println(storage.toString() + " created");
		return storage;
	}

	@Override
	public Camera createCamera(Model model) {
		Camera camera = null;
		switch (model) {
		case MAXIMUMEFFORT:
			camera = new Camera12F8RMpx3();
			break;

		case IFLASDELUXE:
			camera = new Camera12F5RMpx3();
			break;

		case IIAMANIFLAS:
			camera = new Camera8F5RMpx3();
			break;
		default:
			break;
		}
		System.out.println(camera.toString() + " created");
		return camera;
	}

	@Override
	public Case createCase(Model model) {
		Case case1 = null;
		switch (model) {
		case MAXIMUMEFFORT:
			case1 = new Case151x73x7mmUpTo1m();
			break;

		case IFLASDELUXE:
			case1 = new Case149x73x7mmUpTo1m();
			break;

		case IIAMANIFLAS:
			case1 = new Case143x69x7mmUpTo1m();
			break;
		default:
			break;
		}
		System.out.println(case1.toString() + " created");
		return case1;
	}

}
