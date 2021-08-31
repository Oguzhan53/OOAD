/**
 * 
 */
package question3.select;

import java.util.ArrayList;

import question3.BankAccount;

/**
 * Select class . This class gets account from database.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Select {

	/**
	 * This method gets account by id
	 * 
	 * @param accounts Database
	 * @param id
	 * @return Account
	 */
	public BankAccount getAccountById(ArrayList<BankAccount> accounts, int id) {

		for (BankAccount idAccount : accounts) {
			if (idAccount.getId() == id) {
				return idAccount;
			}
		}
		return null;

	}

	/**
	 * This method gets account by name
	 * 
	 * @param accounts Database
	 * @param name
	 * @return Account
	 */
	public BankAccount getAccountByName(ArrayList<BankAccount> accounts, String name) {
		for (BankAccount idAccount : accounts) {
			if (idAccount.getProperty().get("name").equals(name)) {
				return idAccount;
			}
		}
		return null;
	}

}
