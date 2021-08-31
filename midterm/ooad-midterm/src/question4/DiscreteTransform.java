/**
 * 
 */
package question4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Discrete Transforms base class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public abstract class DiscreteTransform {
	protected ArrayList<Double> input;
	protected ArrayList<Double> output;

	/**
	 * This method prints results to screen
	 */
	abstract void printScreen();

	/**
	 * This method prints results to file
	 */
	abstract void writeFile();

	/**
	 * This method calculates transforms
	 */
	abstract void calculate();

	/**
	 * This method reads input data from file
	 * 
	 * @param filePath File path
	 */
	public void readFile(String filePath) {
		File file = new File(filePath);
		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			String st;
			while ((st = br.readLine()) != null) {
				String[] str = st.split("\t");
				for (String num : str) {
					double d = Double.parseDouble(num);
					input.add(d);
				}
			}

		} catch (NumberFormatException e) {
			System.err.println("Wrong input format ( Check the inputs are numeric or tab separated ) ");
		} catch (FileNotFoundException e) {
			System.err.println("File can not found ( Check if file exist on the given path ) ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This methods checks if results print on the screen or not
	 * 
	 * @param scan Scanner
	 * @return True if results will print on the screen else false
	 */
	public boolean wantsPrintScreen(Scanner scan) {
		return false;
	}

	/**
	 * This method calls the steps of the process in order
	 */
	final public void executeTransform() {
		String path = null;

		System.out.print("Enter file path ");

		try (Scanner scanner = new Scanner(System.in);) {
			path = scanner.nextLine();
			readFile(path);
			calculate();
			if (wantsPrintScreen(scanner)) {
				printScreen();
			}
			writeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
