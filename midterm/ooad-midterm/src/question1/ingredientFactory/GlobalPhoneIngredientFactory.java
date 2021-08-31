/**
 * 
 */
package question1.ingredientFactory;

import question1.enums.Model;
import question1.ingredients.Battery;
import question1.ingredients.BatteryLithiumCobalt16Hour;
import question1.ingredients.BatteryLithiumCobalt20Hour;
import question1.ingredients.BatteryLithiumCobalt27Hour;
import question1.ingredients.Camera;
import question1.ingredients.Camera12F5RMpx2;
import question1.ingredients.Camera12F8RMpx2;
import question1.ingredients.Camera8F5RMpx2;
import question1.ingredients.Case;
import question1.ingredients.Case143x69x7mmUpTo50cm;
import question1.ingredients.Case149x73x7mmUpTo50cm;
import question1.ingredients.Case151x73x7mmUpTo50cm;
import question1.ingredients.CpuRam;
import question1.ingredients.CpuRam2Core4GB;
import question1.ingredients.CpuRam2Core6GB;
import question1.ingredients.CpuRam2Core8GB;
import question1.ingredients.Display;
import question1.ingredients.Display24BitAndFivePointFiveInch;
import question1.ingredients.Display24BitAndFivePointThreeInch;
import question1.ingredients.Display24BitAndFourInch;
import question1.ingredients.Storage;
import question1.ingredients.Storage16Max32;
import question1.ingredients.Storage32Max32;
import question1.ingredients.Storage64Max32;

/**
 * Global Ingredient Factory Class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class GlobalPhoneIngredientFactory implements PhoneIngredientFactory {

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
			battery = new BatteryLithiumCobalt27Hour();
			break;

		case IFLASDELUXE:
			battery = new BatteryLithiumCobalt20Hour();
			break;

		case IIAMANIFLAS:
			battery = new BatteryLithiumCobalt16Hour();
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
			cpuRam = new CpuRam2Core8GB();
			break;

		case IFLASDELUXE:
			cpuRam = new CpuRam2Core6GB();
			break;

		case IIAMANIFLAS:
			cpuRam = new CpuRam2Core4GB();
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
			storage = new Storage64Max32();
			break;

		case IFLASDELUXE:
			storage = new Storage32Max32();
			break;

		case IIAMANIFLAS:
			storage = new Storage16Max32();
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
			camera = new Camera12F8RMpx2();
			break;

		case IFLASDELUXE:
			camera = new Camera12F5RMpx2();
			break;

		case IIAMANIFLAS:
			camera = new Camera8F5RMpx2();
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
			case1 = new Case151x73x7mmUpTo50cm();
			break;

		case IFLASDELUXE:
			case1 = new Case149x73x7mmUpTo50cm();
			break;

		case IIAMANIFLAS:
			case1 = new Case143x69x7mmUpTo50cm();
			break;
		default:
			break;
		}
		System.out.println(case1.toString() + " created");
		return case1;
	}

}
