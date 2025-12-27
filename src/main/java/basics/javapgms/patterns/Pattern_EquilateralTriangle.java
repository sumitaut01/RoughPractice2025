package basics.javapgms.patterns;

public class Pattern_EquilateralTriangle {
//	    *
//	   * *
//	  * * *
//	 * * * *
//	* * * * *
	public static void main(String[]args) {

		int rows = 5;

		// Outer loop for rows
		for (int i = 1; i <= rows; i++) {

			// Print leading spaces
			for (int space = 1; space <= rows - i; space++) {
				System.out.print(" ");
			}

			// Print stars
			for (int star = 1; star <= i; star++) {
				System.out.print("* ");
			}

			// Move to next line
			System.out.println();
		}
	}
		
	}

