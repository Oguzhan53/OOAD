/**
 * 
 */
package question1;

/**
 * Class that solves the equation according to the matrix inversion method
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class MatrixInversion implements Calculator {

	/**
	 * This method calculates cofactor value of matrix element
	 * 
	 * @param matrix
	 * @param temp   Template matrix
	 * @param p      Row number
	 * @param q      Column number
	 * @param n      Row length
	 */
	public void getCofactor(double matrix[][], double temp[][], int p, int q, int n) {
		int i = 0, j = 0;

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {

				if (row != p && col != q) {
					temp[i][j++] = matrix[row][col];

					if (j == n - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}

	/**
	 * This method calculates determinant of matrix recursively
	 * 
	 * @param matrix
	 * @param n
	 * @param length
	 * @return Determinant value
	 */
	public double determinant(double matrix[][], int n, int length) {
		int D = 0;

		if (n == 1)
			return matrix[0][0];

		double[][] temp = new double[length][length];

		int sign = 1;

		for (int f = 0; f < n; f++) {

			getCofactor(matrix, temp, 0, f, n);
			D += sign * matrix[0][f] * determinant(temp, n - 1, length);

			sign = -sign;
		}

		return D;
	}

	/**
	 * This method calculates adjoint matrix of a matrix
	 * 
	 * @param matrix
	 * @param adj    Adjoint matrix
	 * @param length
	 */
	public void adjoint(double matrix[][], double[][] adj, int length) {
		if (length == 1) {
			adj[0][0] = 1;
			return;
		}

		int sign = 1;
		double[][] temp = new double[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {

				getCofactor(matrix, temp, i, j, length);

				sign = ((i + j) % 2 == 0) ? 1 : -1;

				adj[j][i] = (sign) * (determinant(temp, length - 1, length));
			}
		}
	}

	/**
	 * This method calculates inverse matrix if it is exist
	 * 
	 * @param matrix
	 * @param inverse Inverse matrix
	 * @param length
	 * @return True if inverse matrix exist.
	 */
	public boolean inverse(double matrix[][], double[][] inverse, int length) {

		double det = determinant(matrix, length, length);
		if (det == 0) {
			return false;
		}

		double[][] adj = new double[length][length];
		adjoint(matrix, adj, length);

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				inverse[i][j] = (adj[i][j] / det);

		return true;
	}

	/**
	 * This method multiplies two matrix
	 * 
	 * @param firstMatrix
	 * @param secondMatrix
	 * @return Result
	 */
	public double[] multiplyMatrices(double[][] firstMatrix, double[] secondMatrix) {
		double[] product = new double[secondMatrix.length];
		for (int i = 0; i < secondMatrix.length; i++) {
			for (int j = 0; j < secondMatrix.length; j++) {
				product[i] += firstMatrix[i][j] * secondMatrix[j];
			}
		}

		return product;
	}

	@Override
	public double[] solve(double coefficients[][], double results[]) {

		double[][] inv = new double[results.length][results.length];

		if (inverse(coefficients, inv, results.length)) {
			return (multiplyMatrices(inv, results));
		}

		return null;

	}

}
