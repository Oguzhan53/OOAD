package question1;

/**
 * Gaussian elimination method class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Gaussian extends LinearSolver {

	public Gaussian() {
		this.calculator = new GaussianElimination();
	}

	@Override
	public void display(double[] result) {
		if (result != null) {
			System.out.println("Gaussian Elimination Solution : ");
			for (int i = 0; i < result.length; i++) {
				System.out.printf("x[" + (i + 1) + "] = %.2f | ", result[i]);
			}
			System.out.println("\n");
		} else
			System.out.println("There is not a solution (gaussian)");

	}

}
