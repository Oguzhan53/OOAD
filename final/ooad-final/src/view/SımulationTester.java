/**
 * 
 */
package view;

import controller.IndividulaController;
import model.SocietyModel;

/**
 * @author Oguzhan SEZGIN
 *
 */
public class SýmulationTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double mortalityRate = 0.2;
		double spreadingRate = 0.9;
		int population = 100;
		int healtyInduvidual = 20;
		SocietyModel societyModel = new SocietyModel(mortalityRate, spreadingRate);
		IndividulaController controller = new IndividulaController(societyModel, population, healtyInduvidual);
		controller.start();

	}

}
