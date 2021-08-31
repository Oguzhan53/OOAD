/**
 * 
 */
package question1;

/**
 * Class that solves the equation according to the gaussian elimination method
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class GaussianElimination implements Calculator {

	@Override
	public double[] solve(double coefficients[][], double results[]) {
		int N = results.length;
		for (int k = 0; k < N; k++) {

			int max = k;
			for (int i = k + 1; i < N; i++)
				if (Math.abs(coefficients[i][k]) > Math.abs(coefficients[max][k]))
					max = i;

			double[] temp = coefficients[k];
			coefficients[k] = coefficients[max];
			coefficients[max] = temp;

			double t = results[k];
			results[k] = results[max];
			results[max] = t;

			for (int i = k + 1; i < N; i++) {
				double factor = coefficients[i][k] / coefficients[k][k];
				results[i] -= factor * results[k];
				for (int j = k; j < N; j++)
					coefficients[i][j] -= factor * coefficients[k][j];
			}
		}

		if (!hasResult(coefficients, N))
			return null;

		double[] solution = new double[N];
		for (int i = N - 1; i >= 0; i--) {
			double sum = 0.0;
			for (int j = i + 1; j < N; j++)
				sum += coefficients[i][j] * solution[j];
			solution[i] = (results[i] - sum) / coefficients[i][i];
		}

		return solution;
	}

	/**
	 * This method checks if the result exist
	 * 
	 * @param matrix
	 * @param length matrix row length
	 * @return True if matrix has result else return false
	 */
	public boolean hasResult(double matrix[][], int length) {

		for (int i = 0; i < length; i++) {
			int j = 0;
			for (; j < length; j++) {
				if (matrix[i][j] != 0)
					break;
			}
			if (j == length)
				return false;
		}

		return true;
	}

}
