/**
 * 
 */
package model;

import controller.ControllerInterface;
import individuals.Mediator;
import individuals.Society;
import view.Observer;

/**
 * Model interface class
 * 
 * @author Oguzhan SEZGIN
 *
 */
public interface SocietyModelInterface {

	/**
	 * This method creates society with random attributes and register the mediator
	 * class
	 * 
	 * @param Pnum       Population number
	 * @param healthyNum Healthy individual number
	 * @return Created mediator
	 */
	Mediator create(int Pnum, int healthyNum);

	/**
	 * This method returns society
	 * 
	 * @return Society
	 */
	Society getSociety();

	/**
	 * This method stars the model
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
	 * This method registers observers to controller
	 * 
	 * @param o Observer
	 */
	void registerObserver(Observer o);

	/**
	 * This method removes the observer
	 * 
	 * @param o Observer
	 */
	void removeObserver(Observer o);

	/**
	 * This method notifies the observers
	 */
	void notifyObserver();

	/**
	 * This method set change attribute to true if changes occurs
	 */
	void setChange();

	/**
	 * This method sets the controller
	 * 
	 * @param controller Controller
	 */
	void setController(ControllerInterface controller);

}
