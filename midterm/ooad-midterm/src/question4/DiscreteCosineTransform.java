/**
 * 
 */
package question4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mance
 *
 */
public class DiscreteCosineTransform extends DiscreteTransform {

	public DiscreteCosineTransform() {
		this.input = new ArrayList<Double>();
		this.output = new ArrayList<Double>();

	}

	@Override
	public void writeFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));) {
			for (int i = 0; i < input.size(); i++) {
				writer.write((i + 1) + "- " + output.get(i).toString() + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printScreen() {
		System.out.println("RESULTS : ");
		for (int i = 0; i < output.size(); i++) {
			System.out.println((i + 1) + "- " + output.get(i));
		}
	}

	@Override
	void calculate() {

		double ci, dct1, sum;
		int n = input.size();

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				ci = 1 / Math.sqrt(n);
			} else {
				ci = Math.sqrt(2) / Math.sqrt(n);
			}
			sum = 0;
			for (int k = 0; k < n; k++) {
				double angle = (2 * k + 1) * i * Math.PI / (2 * n);
				dct1 = input.get(k) * Math.cos(angle);
				sum = sum + dct1;

			}
			output.add(ci * sum);

		}

	}

}
