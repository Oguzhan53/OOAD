/**
 * 
 */
package question3;

/**
 * Transaction command base class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public interface Command {

	/**
	 * This method executes commands process which require integer parameter (
	 * increase money ,decrease money )
	 * 
	 * @param money
	 */
	void execute(int money);

	/**
	 * This method executes commands process which require string parameter ( add
	 * property , remove property , update property )
	 * 
	 * @param property
	 * @param value
	 */
	void execute(String property, String value);

	/**
	 * This method takes undo command from user
	 */
	void undo();

	/**
	 * This method executes undo command
	 */
	void execundo();

	/**
	 * This method stores transactions
	 */
	void store();

	/**
	 * This method loads previous transactions if anything goes wrong
	 */
	void load();

	/**
	 * This method saves transactions
	 */
	void save();
}
