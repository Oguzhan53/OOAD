/**
 * 
 */
package question3.mobese;

/**
 * Test class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HiTech mobese = new HiTech(30);
		TrafficLight trafficLight1 = new TrafficLight(mobese, 5, 1);
		TrafficLight trafficLight2 = new TrafficLight(mobese, 5, 2);
		TrafficLight trafficLight3 = new TrafficLight(mobese, 5, 3);
		TrafficLight trafficLight4 = new TrafficLight(mobese, 5, 4);
		trafficLight1.turnOnLight();
		mobese.changeDetected(true);
		System.out.println("-------------------------");
		trafficLight1.turnOnLight();
		mobese.changeDetected(true);
		System.out.println("-------------------------");
		trafficLight1.turnOnLight();

	}

}
