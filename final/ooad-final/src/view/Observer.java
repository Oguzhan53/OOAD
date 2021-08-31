/**
 * 
 */
package view;

import individuals.Society;
import model.SocietyModel;

/**
 * Observer interface
 * 
 * @author Oguzhan SEZGIN
 *
 */
public interface Observer {

	/**
	 * This method updates the observers data
	 * 
	 * @param society Up to date society
	 */
	void update(Society society);

	/**
	 * This method starts to observer views
	 * 
	 * @param societyModel Society which will displayed
	 */
	void start(SocietyModel societyModel);

}
