/**
 * 
 */
package question1.ingredientFactory;

import question1.enums.Model;
import question1.ingredients.Battery;
import question1.ingredients.BatteryLithiumBoron16Hour;
import question1.ingredients.BatteryLithiumBoron20Hour;
import question1.ingredients.BatteryLithiumBoron27Hour;
import question1.ingredients.Camera;
import question1.ingredients.Camera12F5RMpx4;
import question1.ingredients.Camera12F8RMpx4;
import question1.ingredients.Camera8F5RMpx4;
import question1.ingredients.Case;
import question1.ingredients.Case143x69x7mmUpTo2m;
import question1.ingredients.Case149x73x7mmUpTo2m;
import question1.ingredients.Case151x73x7mmUpTo2m;
import question1.ingredients.CpuRam;
import question1.ingredients.CpuRam8Core4GB;
import question1.ingredients.CpuRam8Core6GB;
import question1.ingredients.CpuRam8Core8GB;
import question1.ingredients.Display;
import question1.ingredients.Display32BitAndFivePointFiveInch;
import question1.ingredients.Display32BitAndFivePointThreeInch;
import question1.ingredients.Display32BitAndFourInch;
import question1.ingredients.Storage;
import question1.ingredients.Storage16Max128;
import question1.ingredients.Storage32Max128;
import question1.ingredients.Storage64Max128;

/**
 * Turkey Ingredient Factory Class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class TurkeyPhoneIngredientFactory implements PhoneIngredientFactory {

	@Override
	public Display createDisplay(Model model) {
		Display display = null;
		switch (model) {
		case MAXIMUMEFFORT:
			display = new Display32BitAndFivePointFiveInch();
			break;

		case IFLASDELUXE:
			display = new Display32BitAndFivePointThreeInch();
			break;

		case IIAMANIFLAS:
			display = new Display32BitAndFourInch();
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
			battery = new BatteryLithiumBoron27Hour();
			break;

		case IFLASDELUXE:
			battery = new BatteryLithiumBoron20Hour();
			break;

		case IIAMANIFLAS:
			battery = new BatteryLithiumBoron16Hour();
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
			cpuRam = new CpuRam8Core8GB();
			break;

		case IFLASDELUXE:
			cpuRam = new CpuRam8Core6GB();
			break;

		case IIAMANIFLAS:
			cpuRam = new CpuRam8Core4GB();
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
			storage = new Storage64Max128();
			break;

		case IFLASDELUXE:
			storage = new Storage32Max128();
			break;

		case IIAMANIFLAS:
			storage = new Storage16Max128();
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
			camera = new Camera12F8RMpx4();
			break;

		case IFLASDELUXE:
			camera = new Camera12F5RMpx4();
			break;

		case IIAMANIFLAS:
			camera = new Camera8F5RMpx4();
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
			case1 = new Case151x73x7mmUpTo2m();
			break;

		case IFLASDELUXE:
			case1 = new Case149x73x7mmUpTo2m();
			break;

		case IIAMANIFLAS:
			case1 = new Case143x69x7mmUpTo2m();
			break;
		default:
			break;
		}
		System.out.println(case1.toString() + " created");
		return case1;
	}

}
