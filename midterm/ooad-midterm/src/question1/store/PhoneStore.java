/**
 * 
 */
package question1.store;

import question1.enums.Model;
import question1.product.Phone;

/**
 * Phone stores base class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public abstract class PhoneStore {

	/**
	 * This method places a phone order
	 * 
	 * @param model Phone model
	 * @return Phone
	 */
	public Phone orderPhone(Model model) {
		System.out.println("---- Your order has been taken ---- ");
		Phone phone = createPhone(model);
		phone.test();
		phone.box();
		phone.ship();
		return phone;
	}

	/**
	 * This method creates phone by order
	 * 
	 * @param model Phone model
	 * @return Phone
	 */
	abstract Phone createPhone(Model model);
}
