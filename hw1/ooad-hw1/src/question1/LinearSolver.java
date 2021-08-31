package question1;

/**
 * Linear equation solver abstract class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 * 
 */
public abstract class LinearSolver {

	/**
	 * Calculator method class reference
	 */
	public Calculator calculator;

	/**
	 * This method calculates equation result
	 * 
	 * @param coefficients Coefficients matrix
	 * @param results      Results matrix
	 */
	public void calculate(double coefficients[][], double results[]) {
		display(calculator.solve(coefficients, results));
	}

	/**
	 * This method displays result.
	 * 
	 * @param result
	 */
	public abstract void display(double result[]);

}
