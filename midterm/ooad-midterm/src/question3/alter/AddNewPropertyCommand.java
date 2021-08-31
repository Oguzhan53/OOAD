/**
 * 
 */
package question3.alter;

import question3.BankAccount;
import question3.Command;

/**
 * Add New Property command.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class AddNewPropertyCommand implements Command {
	private BankAccount account;
	private String addedProperty;

	public AddNewPropertyCommand(BankAccount account) {
		this.account = account;
		this.addedProperty = "";
	}

	private AddNewPropertyCommand(BankAccount account, String property) {
		this.account = account;
		this.addedProperty = property;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public String getAddedProperty() {
		return addedProperty;
	}

	public void setAddedProperty(String addedProperty) {
		this.addedProperty = addedProperty;
	}

	@Override
	public void execute(int money) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(String property, String value) {
		addedProperty = property;
		if (!("".equals(value) && "".equals(property)) && account.addProperty(property, value)) {
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
		account.removeProperty(addedProperty);

	}

	@Override
	public void store() {
		account.getProccess().push(new AddNewPropertyCommand(account, addedProperty));

	}

	@Override
	public void load() {
		while (account.getProccess().size() != 0) {
			account.getProccess().pop().execundo();
		}
		addedProperty = "";

	}

	@Override
	public void save() {
		while (account.getProccess().size() != 0) {
			account.getProccess().pop();
		}
		System.out.println("Saved");

	}

}
