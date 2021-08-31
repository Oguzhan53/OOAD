/**
 * 
 */
package question3;

import java.util.Scanner;

/**
 * User Interface Class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in);) {

			System.out.println("------------- WELCOME ZýrhSan A.S. ------------- ");
			System.out.println("Please enter a suit type number : ");
			System.out.println(" 1 - Dec \n 2 - Ora \n 3 - Tor");

			Armor armor;
			while (true) {
				String typeNumber = scan.next();
				if ("1".equals(typeNumber)) {
					armor = new SuitDec();
				} else if ("2".equals(typeNumber)) {
					armor = new SuitOra();
				} else if ("3".equals(typeNumber)) {
					armor = new SuitTor();
				} else {
					System.out.println("Enter valid number");
					continue;
				}
				break;
			}

			while (true) {
				System.out.println("Please enter the equipment number you want to add armor to:");
				System.out.println(
						" 1 - Flame Thrower \n 2 - Auto Rifle \n 3 - Rocket Launcher \n 4 - Laser \n 5 - See Total Cost and Total Weight");
				String typeNumber = scan.next();
				if ("1".equals(typeNumber)) {
					armor = new Flamethrower(armor);
				} else if ("2".equals(typeNumber)) {
					armor = new AutoRifle(armor);
				} else if ("3".equals(typeNumber)) {
					armor = new RocketLauncher(armor);
				} else if ("4".equals(typeNumber)) {
					armor = new Laser(armor);
				} else if ("5".equals(typeNumber)) {
					break;
				} else {
					System.out.println("Enter valid number");
				}

			}
			System.out.println("Your Armor Information ");
			System.out.println(armor.getName() + " = Total Cost : " + armor.cost() + "k TL - Total Weight : "
					+ armor.weight() + " kg \n");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
