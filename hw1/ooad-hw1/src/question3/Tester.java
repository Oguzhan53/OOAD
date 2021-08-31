/**
 * 
 */
package question3;

/**
 * Tester Class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ---- When only choose suit ------
		System.out.println("----- When Only Choose Suit -----");
		Armor dec = new SuitDec();
		Armor ora = new SuitOra();
		Armor tor = new SuitTor();
		System.out.println(
				dec.getName() + " = Total Cost : " + dec.cost() + "k TL - Total Weight : " + dec.weight() + " kg");
		System.out.println(
				ora.getName() + " = Total Cost : " + ora.cost() + "k TL - Total Weight : " + ora.weight() + " kg");
		System.out.println(
				tor.getName() + " = Total Cost : " + tor.cost() + "k TL - Total Weight : " + tor.weight() + " kg");

		System.out.println();
		// ---- When Choose Suit Dec and Equipment Auto rifle, Flame thrower, 2 Laser,
		// Rocket Launcher ------
		dec = new AutoRifle(dec);
		dec = new Flamethrower(dec);
		dec = new Laser(dec);
		dec = new Laser(dec);
		dec = new RocketLauncher(dec);
		System.out.println(
				"----- When Choose Suit Dec and Equipment Auto rifle , Flame thrower, 2 Laser , Rocket Launcher -----");
		System.out.println(
				dec.getName() + " = Total Cost : " + dec.cost() + "k TL - Total Weight : " + dec.weight() + " kg \n");

		// ---- When Choose Suit Ora and Equipment Auto rifle, Flame thrower, 2 Rocket
		// Launcher ------
		ora = new AutoRifle(ora);
		ora = new Flamethrower(ora);
		ora = new RocketLauncher(ora);
		ora = new RocketLauncher(ora);
		System.out.println(
				"----- When Choose Suit Ora and Equipment Auto rifle , Flame thrower , 2 Rocket Launcher -----");
		System.out.println(
				ora.getName() + " = Total Cost : " + ora.cost() + "k TL - Total Weight : " + ora.weight() + " kg \n");

		// ---- When Choose Suit Tor and Equipment Flame thrower, Auto rifle, Rocket
		// Launcher, Laser ------
		tor = new Flamethrower(tor);
		tor = new AutoRifle(tor);
		tor = new RocketLauncher(tor);
		tor = new Laser(tor);
		System.out.println(
				"----- When Choose Suit Tor and Equipment Flame thrower, Auto rifle,  Rocket Launcher, Laser -----");
		System.out.println(
				tor.getName() + " = Total Cost : " + tor.cost() + "k TL - Total Weight : " + tor.weight() + " kg \n");

	}

}
