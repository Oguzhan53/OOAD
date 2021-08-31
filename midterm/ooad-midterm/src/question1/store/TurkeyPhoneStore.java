/**
 * 
 */
package question1.store;

import question1.enums.Model;
import question1.enums.Region;
import question1.ingredientFactory.PhoneIngredientFactory;
import question1.ingredientFactory.TurkeyPhoneIngredientFactory;
import question1.product.Phone;
import question1.product.IIAmanIflasPhone;
import question1.product.IflasDeluxePhone;
import question1.product.MaximumEffortPhone;

/**
 * Turkey Phone Store class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class TurkeyPhoneStore extends PhoneStore {

	@Override
	Phone createPhone(Model model) {
		Phone phone = null;
		PhoneIngredientFactory phoneIngredientFactory = new TurkeyPhoneIngredientFactory();
		System.out.println("---- Ordered to factory for components ---- ");

		switch (model) {
		case MAXIMUMEFFORT:
			phone = new MaximumEffortPhone(phoneIngredientFactory);
			phone.setRegion(Region.TURKEY);
			break;
		case IFLASDELUXE:
			phone = new IflasDeluxePhone(phoneIngredientFactory);
			phone.setRegion(Region.TURKEY);
			break;
		case IIAMANIFLAS:
			phone = new IIAmanIflasPhone(phoneIngredientFactory);
			phone.setRegion(Region.TURKEY);
			break;
		default:
			break;
		}
		phone.producePhone();
		return phone;
	}

}
