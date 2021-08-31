/**
 * 
 */
package question3;

import java.util.ArrayList;

import question3.alter.AddNewPropertyCommand;
import question3.alter.RemovePropertyCommand;
import question3.select.Select;
import question3.update.DecreaseMoneyCommand;
import question3.update.IncreaseMoneyCommand;
import question3.update.UpdatePropertyCommand;

/**
 * Test Class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// --------------------- CREATE DATABASE ---------------------
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		BankAccount ac1 = new BankAccount(0, "oguzhan", "sezgin", 500);
		ac1.getController().setCommand(new IncreaseMoneyCommand(ac1), new DecreaseMoneyCommand(ac1), 0);
		ac1.getController().setCommand(new AddNewPropertyCommand(ac1), new RemovePropertyCommand(ac1), 1);
		ac1.getController().setCommand(new UpdatePropertyCommand(ac1), new UpdatePropertyCommand(ac1), 2);
		accounts.add(ac1);

		BankAccount ac2 = new BankAccount(1, "ali", "veli", 2500);
		ac2.getController().setCommand(new IncreaseMoneyCommand(ac2), new DecreaseMoneyCommand(ac2), 0);
		ac2.getController().setCommand(new AddNewPropertyCommand(ac2), new RemovePropertyCommand(ac2), 1);
		ac2.getController().setCommand(new UpdatePropertyCommand(ac2), new UpdatePropertyCommand(ac2), 2);
		accounts.add(ac2);

		BankAccount ac3 = new BankAccount(2, "ayse", "fatma", 25);
		ac3.getController().setCommand(new IncreaseMoneyCommand(ac3), new DecreaseMoneyCommand(ac3), 0);
		ac3.getController().setCommand(new AddNewPropertyCommand(ac3), new RemovePropertyCommand(ac3), 1);
		ac3.getController().setCommand(new UpdatePropertyCommand(ac3), new UpdatePropertyCommand(ac3), 2);
		accounts.add(ac3);

		System.out.println("-------------------- DATABASE MEMEBERS --------------------");
		System.out.println(ac1.toString());
		System.out.println(ac2.toString());
		System.out.println(ac3.toString());

		System.out.println("*********** TEST CASES ***********");
		Select select = new Select();

		BankAccount searchedAccount = select.getAccountById(accounts, 1);
		Controller myAccountController = searchedAccount.getController();
		myAccountController.increaseMoney(100, 0);
		myAccountController.increaseMoney(50, 0);
		System.out.println("-------------------- Ýncrease Money Test (Account id = 0) --------------------");
		System.out.println(searchedAccount.toString());

		myAccountController.decreaseMoney(60, 0);
		myAccountController.decreaseMoney(20, 0);
		System.out.println("-------------------- Decrease Money Test (Account id = 0) --------------------");
		System.out.println(searchedAccount.toString());
		myAccountController.undo();
		myAccountController.undo();
		System.out.println("-------------------- Undo Test (Account id = 0) --------------------");
		System.out.println(searchedAccount.toString());
		myAccountController.addProperty("job", "engineer", 1);
		myAccountController.addProperty("age", "30", 1);
		System.out.println("-------------------- Add New Poroperty Test (Account id = 0) --------------------");
		System.out.println(searchedAccount.toString());
		myAccountController.updatePropert("age", "25", 2);
		System.out.println("-------------------- Update Poroperty Test (Account id = 0) --------------------");
		System.out.println(searchedAccount.toString());
		myAccountController.decreaseMoney(30000, 0);
		System.out.println("-------------------- Wrong Transaction Test (Account id = 0) --------------------");
		System.out.println(searchedAccount.toString());
		myAccountController.increaseMoney(1000, 0);
		myAccountController.increaseMoney(500, 0);
		System.out.println("-------------------- Save Transaction Test (Account id = 0) --------------------");
		myAccountController.save();
		myAccountController.decreaseMoney(1000000, 0);
		System.out.println(searchedAccount.toString());

	}

}
