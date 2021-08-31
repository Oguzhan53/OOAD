/**
 * 
 */
package question3.alter;

import question3.BankAccount;
import question3.Command;

/**
 * Remove Property commad.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class RemovePropertyCommand implements Command {
	private BankAccount account;
	private String removedProperty;
	private String removedValue;

	public RemovePropertyCommand(BankAccount account) {
		this.account = account;
		this.removedProperty = "";
	}

	private RemovePropertyCommand(BankAccount account, String property, String value) {
		this.account = account;
		this.removedProperty = property;
		this.removedValue = value;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public String getAddedProperty() {
		return removedProperty;
	}

	public void setAddedProperty(String addedProperty) {
		this.removedProperty = addedProperty;
	}

	@Override
	public void execute(int money) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(String property, String value) {
		removedProperty = property;
		removedValue = account.getValue(property);
		if (!("".equals(property)) && account.removeProperty(property)) {
			store();
		} else {
			load();
		}

	}

	@Override
	public void undo() {
		if (account.getProccess().size() != 0) {
			account.getProccess().pop().execundo();
		}

	}

	@Override
	public void execundo() {
		if (!("".equals(removedProperty) && "".equals(removedValue))) {
			account.addProperty(removedProperty, removedValue);
		}

	}

	@Override
	public void store() {
		account.getProccess().push(new RemovePropertyCommand(account, removedProperty, removedValue));

	}

	@Override
	public void load() {
		while (account.getProccess().size() != 0) {
			account.getProccess().pop().execundo();
		}
		removedProperty = "";
		removedValue = "";

	}

	@Override
	public void save() {
		while (account.getProccess().size() != 0) {
			account.getProccess().pop();
		}
		System.out.println("Saved");
	}

}
