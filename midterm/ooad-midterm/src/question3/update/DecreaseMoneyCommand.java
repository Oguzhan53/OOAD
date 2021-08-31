/**
 * 
 */
package question3.update;

import question3.BankAccount;
import question3.Command;

/**
 * Decrease Money Command class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class DecreaseMoneyCommand implements Command {
	private BankAccount account;
	private int updateVal;

	public DecreaseMoneyCommand(BankAccount account) {
		this.account = account;

		this.updateVal = 0;
	}

	private DecreaseMoneyCommand(int update, BankAccount account) {
		this.updateVal = update;
		this.account = account;

	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public int getUpdateVal() {
		return updateVal;
	}

	public void setUpdateVal(int updateVal) {
		this.updateVal = updateVal;
	}

	@Override
	public void execute(int money) {
		if (money > account.getMoney()) { // Rolls back transactions if the account balance become negative
			load();
		} else {
			updateVal = money;
			account.decreaseMoney(money);
			store();
		}

	}

	@Override
	public void execute(String property, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void undo() {
		if (account.getProccess().size() != 0) {
			account.getProccess().pop().execundo();
		}

	}

	@Override
	public void store() {
		account.getProccess().push(new DecreaseMoneyCommand(updateVal, account));

	}

	@Override
	public void load() {
		while (account.getProccess().size() != 0) {
			account.getProccess().pop().execundo();
		}
		updateVal = 0;
	}

	@Override
	public void execundo() {
		account.increaseMoney(updateVal);

	}

	@Override
	public void save() {
		while (account.getProccess().size() != 0) {
			account.getProccess().pop();
		}
		System.out.println("Saved");

	}
}
