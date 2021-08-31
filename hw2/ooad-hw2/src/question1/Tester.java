package question1;

/**
 * Test class.
 * 
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Tester {

	public static void main(String[] args) {

		int len = 4;
		Data[][] datas = new Data[len][len];

		int val = 1;
		DataArray array = new DataArray();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				datas[i][j] = new Data(val);
				System.out.print(val + "\t");
				val++;

			}

			System.out.println("");
		}
		System.out.println("\n\n---------------CLOCK-WISE PRINT-----------------\n");
		array.setArrayComponent(datas);
		array.setLength(len);
		MyArray arr = new MyArray(array);
		arr.print();

		System.out.println("\n\n***************************************");

		len = 6;
		Data[][] datas2 = new Data[len][len];

		val = 1;
		DataArray array2 = new DataArray();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				datas2[i][j] = new Data(val);
				System.out.print(val + "\t");
				val++;

			}

			System.out.println("");
		}
		System.out.println("\n\n---------------CLOCK-WISE PRINT-----------------\n");
		array2.setArrayComponent(datas2);
		array2.setLength(len);
		MyArray arr2 = new MyArray(array2);
		arr2.print();

	}

}
