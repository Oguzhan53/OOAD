/**
 * 
 */
package question3.update;

import question3.BankAccount;
import question3.Command;

/**
 * Update Property Command class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class UpdatePropertyCommand implements Command {

	private BankAccount account;
	private String oldProperty;
	private String oldValue;

	public UpdatePropertyCommand(BankAccount account) {
		this.account = account;
		this.oldProperty = "";
	}

	private UpdatePropertyCommand(BankAccount account, String property, String value) {
		this.account = account;
		this.oldProperty = property;
		this.oldValue = value;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public String getOldProperty() {
		return oldProperty;
	}

	public void setOldProperty(String oldProperty) {
		this.oldProperty = oldProperty;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	@Override
	public void execute(int money) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(String property, String value) {
		oldProperty = property;
		oldValue = account.getValue(property);
		if (!("".equals(value) && "".equals(property)) && account.updateProperty(property, value)) {
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
		if (!("".equals(oldProperty) && "".equals(oldValue))) {
			account.updateProperty(oldProperty, oldValue);
		}

	}

	@Override
	public void store() {
		account.getProccess().push(new UpdatePropertyCommand(account, oldProperty, oldValue));

	}

	@Override
	public void load() {
		while (account.getProccess().size() != 0) {
			account.getProccess().pop().execundo();
		}
		oldProperty = "";
		oldValue = "";

	}

	@Override
	public void save() {
		while (account.getProccess().size() != 0) {
			account.getProccess().pop();
		}
		System.out.println("Saved");

	}

}
