/**
 * 
 */
package question3.mobese;

/**
 * Base state class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public interface State {

	/**
	 * This method switches state with call context class method.
	 */
	void switchState();

	/**
	 * This method updates the time the light to stay on.
	 * 
	 * @param waitingSec New stay on time
	 * @return New stay on time
	 */
	int updateWaitingSec(int waitingSec);
}
