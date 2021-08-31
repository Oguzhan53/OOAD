/**
 * 
 */
package question1;

import question1.enums.Model;
import question1.product.Phone;
import question1.store.EUPhoneStore;
import question1.store.GlobalPhoneStore;
import question1.store.PhoneStore;
import question1.store.TurkeyPhoneStore;

/**
 * Question 1 test class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("******* TEST FOR TURKEY *******\n");
		PhoneStore phoneStore1 = new TurkeyPhoneStore();
		Phone myphone11 = phoneStore1.orderPhone(Model.MAXIMUMEFFORT);
		System.out.println(myphone11.getRegion() + " - " + myphone11.getModel());
		System.out.println("\n----------------------------");

		Phone myphone12 = phoneStore1.orderPhone(Model.IFLASDELUXE);
		System.out.println(myphone12.getRegion() + " - " + myphone12.getModel());
		System.out.println("\n----------------------------");

		Phone myphone13 = phoneStore1.orderPhone(Model.IIAMANIFLAS);
		System.out.println(myphone13.getRegion() + " - " + myphone13.getModel());
		System.out.println("\n----------------------------");
		System.out.println("\n----------------------------");

		System.out.println("******* TEST FOR EU *******\n");

		PhoneStore phoneStore2 = new EUPhoneStore();
		Phone myphone21 = phoneStore2.orderPhone(Model.MAXIMUMEFFORT);
		System.out.println(myphone21.getRegion() + " - " + myphone21.getModel());
		System.out.println("\n----------------------------");

		Phone myphone22 = phoneStore2.orderPhone(Model.IFLASDELUXE);
		System.out.println(myphone22.getRegion() + " - " + myphone22.getModel());
		System.out.println("\n----------------------------");

		Phone myphone23 = phoneStore2.orderPhone(Model.IIAMANIFLAS);
		System.out.println(myphone23.getRegion() + " - " + myphone23.getModel());
		System.out.println("\n----------------------------");
		System.out.println("\n----------------------------");

		System.out.println("******* TEST FOR GLOBAL *******\n");

		PhoneStore phoneStore3 = new GlobalPhoneStore();
		Phone myphone31 = phoneStore3.orderPhone(Model.MAXIMUMEFFORT);
		System.out.println(myphone31.getRegion() + " - " + myphone31.getModel());
		System.out.println("\n----------------------------");

		Phone myphone32 = phoneStore3.orderPhone(Model.IFLASDELUXE);
		System.out.println(myphone32.getRegion() + " - " + myphone32.getModel());
		System.out.println("\n----------------------------");

		Phone myphone33 = phoneStore3.orderPhone(Model.IIAMANIFLAS);
		System.out.println(myphone33.getRegion() + " - " + myphone33.getModel());
		System.out.println("\n----------------------------");

	}

}
