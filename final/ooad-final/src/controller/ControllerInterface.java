/**
 * 
 */
package controller;

import individuals.Individual;

/**
 * Individual controller interface
 * 
 * @author Oguzhan SEZGIN
 *
 */
public interface ControllerInterface {

	/**
	 * This method starts the simulation
	 */
	void start();

	/**
	 * This method pauses the simulation
	 */
	void pause();

	/**
	 * This method resumes the simulation
	 */
	void resume();

	/**
	 * This method takes the individual to hospital
	 * 
	 * @param idIndividual Taken individual
	 */
	void goHospital(Individual idIndividual);

	/**
	 * This method discharges from hospital the individual
	 * 
	 * @param individual Discharged individual
	 */
	void dischargeIndividual(Individual individual);

	/**
	 * This method checks collision status
	 */
	void checkCollision();

}
