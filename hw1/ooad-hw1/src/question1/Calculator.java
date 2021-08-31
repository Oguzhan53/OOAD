/**
 * 
 */
package question1;

/**
 * Calculator interface class
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public interface Calculator {

	/**
	 * This method solve linear equations according to concrete class method.
	 * 
	 * @param coefficients Coefficients matrix
	 * @param results      Result matrix
	 * @return Result
	 */
	public double[] solve(double coefficients[][], double results[]);
}
