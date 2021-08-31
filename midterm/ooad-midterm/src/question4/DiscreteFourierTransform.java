/**
 * 
 */
package question4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author mance
 *
 */
public class DiscreteFourierTransform extends DiscreteTransform {

	private ArrayList<Double> imagOut;

	public DiscreteFourierTransform() {
		this.input = new ArrayList<Double>();
		this.output = new ArrayList<Double>();
		this.imagOut = new ArrayList<Double>();
	}

	@Override
	public boolean wantsPrintScreen(Scanner scan) {
		String answer = getUserAnswer(scan);
		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	void calculate() {
		int n = input.size();
		for (int k = 0; k < n; k++) {
			double realNum = 0;
			double imagNum = 0;

			for (int t = 0; t < n; t++) {
				double angle = 2 * Math.PI * t * k / n;
				realNum += input.get(t) * Math.cos(angle);
				imagNum += -input.get(t) * Math.sin(angle);
			}
			output.add(realNum);
			imagOut.add(imagNum);

		}

	}

	/**
	 * This method asks to user for wants to print results on the screen
	 * 
	 * @param scan Scanner
	 * @return True if user wants to print else false
	 */
	private String getUserAnswer(Scanner scan) {
		String answer = null;
		System.out.print("Would you like to print on screen (y/n)? ");

		answer = scan.nextLine();

		if (answer == null) {
			return "no";
		}
		return answer;
	}

	@Override
	void writeFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));) {
			for (int i = 0; i < input.size(); i++) {
				writer.write((i + 1) + "- " + output.get(i).toString() + "+(" + imagOut.get(i) + ")i\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	void printScreen() {
		System.out.println("RESULTS : ");
		for (int i = 0; i < output.size(); i++) {
			System.out.println((i + 1) + "- " + output.get(i) + "+(" + imagOut.get(i) + ")i ");
		}

	}

}
