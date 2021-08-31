package question1;

/**
 * Matrix inversion method class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Matrix extends LinearSolver {

	public Matrix() {
		this.calculator = new MatrixInversion();
	}

	@Override
	public void display(double[] result) {
		if (result != null) {
			System.out.println("Matrix Inversion Solution : ");
			for (int i = 0; i < result.length; i++) {
				System.out.printf("x[" + (i + 1) + "] = %.2f | ", result[i]);
			}
			System.out.println("\n");
		} else {
			System.out.println("Singular matrix, can't find its inverse \nThere is not solution (matrix)");
		}

	}

}
