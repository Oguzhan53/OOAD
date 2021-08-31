package question1;

/**
 * Test class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Tester {

	public static void main(String[] args) {

		// ---- Equation solution with 2 unknowns

		LinearSolver gaussian = new Gaussian();
		LinearSolver matrix = new Matrix();

		double coefficients2[][] = { { 5, 2 }, { -3, 3 } };
		double results2[] = { 3, 15 };
		System.out.println("---- Equation solution with 2 unknowns ----");

		showEquation(coefficients2, results2);
		gaussian.calculate(coefficients2, results2);

		matrix.calculate(coefficients2, results2);

		// ---- Equation solution with 3 unknowns
		double coefficients3[][] = { { 2, -1, 3 }, { 2, 2, 3 }, { -2, 3, 0 } };
		double results3[] = { 5, 7, -3 };
		System.out.println("\n---- Equation solution with 3 unknowns ----");
		showEquation(coefficients3, results3);

		gaussian.calculate(coefficients3, results3);

		matrix.calculate(coefficients3, results3);

		// ---- Equation solution with 4 unknowns
		double coefficients4[][] = { { 1, 2, -3, -1 }, { 0, -3, 2, 6 }, { -3, -1, 3, 1 }, { 2, 3, 2, -1 } };
		double results4[] = { 0, -8, 0, -8 };
		System.out.println("\n---- Equation solution with 4 unknowns ----");
		showEquation(coefficients4, results4);
		gaussian.calculate(coefficients4, results4);

		matrix.calculate(coefficients4, results4);

		// Equation with 3 unknowns with no solution

		double coefficients5[][] = { { 1, 2, 3 }, { -3, -2, -1 }, { 4, 4, 4 } };
		double results5[] = { 1, 2, 3 };
		System.out.println("\n---- Equation with 3 unknowns with no solution ----");
		showEquation(coefficients5, results5);
		gaussian.calculate(coefficients5, results5);

		matrix.calculate(coefficients5, results5);

	}

	public static void showEquation(double coefficients[][], double results[]) {
		System.out.println("Your equations : ");
		for (int i = 0; i < results.length; i++) {
			for (int j = 0; j < results.length; j++) {
				System.out.print("(" + coefficients[i][j] + "x[" + (j + 1) + "])");
				if (j != results.length - 1) {
					System.out.print(" + ");
				}
			}
			System.out.println(" = " + results[i]);
		}
		System.out.println();

	}

}
