/**
 * 
 */
package question3;

import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Bank Account Class (DB member)
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class BankAccount {

	private TreeMap<String, String> property;
	private int money;
	private int id;
	private Stack<Command> proccess;
	private Controller controller;

	public BankAccount(int id, String name, String surname, int money) {
		this.property = new TreeMap<String, String>();
		this.property.put("Name", name);
		this.property.put("Surname", surname);
		this.money = money;
		this.proccess = new Stack<Command>();
		this.id = id;
		this.controller = new Controller();
	}

	public Stack<Command> getProccess() {
		return proccess;
	}

	public void setProccess(Stack<Command> proccess) {
		this.proccess = proccess;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TreeMap<String, String> getProperty() {
		return property;
	}

	public void setProperty(TreeMap<String, String> property) {
		this.property = property;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getValue(String key) {
		return property.get(key);
	}

	/**
	 * This method adds new property to account
	 * 
	 * @param key   Property key
	 * @param value Property value
	 * @return If can add returns true else return false
	 */
	public boolean addProperty(String key, String value) {
		if (property.containsKey(key)) {
			return false;
		} else {
			property.put(key, value);
			return true;
		}

	}

	/**
	 * This method remove property from account
	 * 
	 * @param key Property key
	 * @return If can remove returns true else return false
	 */
	public boolean removeProperty(String key) {
		if (!property.containsKey(key)) {
			return false;
		} else {
			property.remove(key);
			return true;
		}
	}

	/**
	 * This method updates account property
	 * 
	 * @param key   Property key
	 * @param value Property value
	 * @return If can update returns true else return false
	 */
	public boolean updateProperty(String key, String value) {
		if (!property.containsKey(key)) {
			return false;
		} else {
			property.replace(key, value);
			return true;
		}
	}

	/**
	 * This method increases money in account
	 * 
	 * @param update Money to add
	 * @return New money amount 
	 */
	public int increaseMoney(int update) {
		this.money += update;
		return this.money;
	}

	/**
	 * This method decreases money in account
	 * 
	 * @param update Money to remove
	 * @return New money amount
	 */
	public int decreaseMoney(int update) {
		this.money -= update;
		return this.money;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("ID : " + this.id + "\n");
		for (Entry<String, String> entry : property.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			str.append(key + " : ");
			str.append(value + "\n");
		}
		str.append("Money : " + money);
		return str.toString();

	}

}
