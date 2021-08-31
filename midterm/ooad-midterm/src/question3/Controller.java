/**
 * 
 */
package question3;

/**
 * Controller class. This class controls transactions
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Controller {
	private Command[] increaseCommand;
	private Command[] decreaseCommand;
	private Command undoCommand;
	private Command saveCommand;
	private final int commandSize = 3;

	public Controller() {
		Command noCommand = new NoCommand();
		this.increaseCommand = new Command[commandSize];
		this.decreaseCommand = new Command[commandSize];
		undoCommand = noCommand;
		saveCommand = noCommand;
	}

	/**
	 * This method sets commands to controller
	 * 
	 * @param increase Ýncrease command (add , update , increase )
	 * @param decrease Decrease command (remove , decrease )
	 * @param slot     Command slot number
	 */
	public void setCommand(Command increase, Command decrease, int slot) {
		increaseCommand[slot] = increase;
		decreaseCommand[slot] = decrease;
		saveCommand = decrease;
	}

	/**
	 * This method increases money
	 * 
	 * @param money
	 * @param slot  Command slot number
	 */
	public void increaseMoney(int money, int slot) {
		increaseCommand[slot].execute(money);
		undoCommand = increaseCommand[slot];
	}

	/**
	 * This method increases money
	 * 
	 * @param money
	 * @param slot  Command slot number
	 */
	public void decreaseMoney(int money, int slot) {
		decreaseCommand[slot].execute(money);
		undoCommand = decreaseCommand[slot];
	}

	/**
	 * This method adds property
	 * 
	 * @param property
	 * @param value
	 * @param slot     Command slot number
	 */
	public void addProperty(String property, String value, int slot) {
		increaseCommand[slot].execute(property, value);
		undoCommand = increaseCommand[slot];
	}

	/**
	 * This method removes property
	 * 
	 * @param property
	 * @param slot     Command slot number
	 */
	public void removePorpoerty(String property, int slot) {
		decreaseCommand[slot].execute(property, null);
		undoCommand = decreaseCommand[slot];
	}

	/**
	 * This method updates property
	 * 
	 * @param property
	 * @param value
	 * @param slot     Command slot number
	 */
	public void updatePropert(String property, String value, int slot) {
		increaseCommand[slot].execute(property, value);
		undoCommand = increaseCommand[slot];
	}

	public void undo() {
		undoCommand.undo();
	}

	public void save() {
		saveCommand.save();
	}

}
