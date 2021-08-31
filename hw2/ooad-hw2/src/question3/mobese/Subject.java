package question3.mobese;

/**
 * Subject interface.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public interface Subject {

	/**
	 * This method registers new subscriber to web site
	 * 
	 * @param o New subscriber
	 */
	public void registerObserver(Observer o);

	/**
	 * This method removes subscriber to web site
	 * 
	 * @param o Subscriber
	 */
	public void removeObserver(Observer o);

	/**
	 * This method triggers the update method when the updates made
	 */
	public void notifyObservers();

	/**
	 * This method allows to subscribers notify
	 */
	public void setChange();
}
