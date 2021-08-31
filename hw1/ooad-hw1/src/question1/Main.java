package question1;

import java.util.Scanner;

/**
 * User Interface Class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */

public class Main {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in);) {

			LinearSolver gaussian = new Gaussian();
			LinearSolver matrix = new Matrix();

			System.out.println("Enter variable number :");
			int length = scan.nextInt();
			double coefficients[][] = new double[length][length];
			double results[] = new double[length];

			for (int i = 0; i < length; i++) {
				System.out.println("\nEnter " + (i + 1) + ". equation coefficient ;");
				for (int j = 0; j < length; j++) {
					// System.out.println("Enter "+(j+1)+". variable coefficient");
					coefficients[i][j] = scan.nextDouble();
				}
				System.out.print("Enter equation result : ");
				results[i] = scan.nextDouble();
			}

			System.out.println("Your equations : ");
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					System.out.print("(" + coefficients[i][j] + "x[" + (j + 1) + "])");
					if (j != length - 1) {
						System.out.print(" + ");
					}
				}
				System.out.println(" = " + results[i]);
			}
			System.out.println();
			System.out.println("Enter solve method type (Gaussian - Matrix) ");

			String type;
			type = scan.next();
			if ("Gaussian".equalsIgnoreCase(type)) {
				gaussian.calculate(coefficients, results);
			} else {
				matrix.calculate(coefficients, results);
			}

			System.out.println("\n------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
