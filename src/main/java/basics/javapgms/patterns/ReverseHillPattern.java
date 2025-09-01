package basics.javapgms.patterns;
public class ReverseHillPattern {
    public static void main(String[] args) {
        int n = 4; // You can change this to adjust the size of the pattern.

        // Outer loop for the number of rows
        for (int i = 1; i <= n; i++) {

            // Inner loop for leading spaces
            // The number of spaces increases with each row.
            for (int j = 1; j < i; j++) {
                System.out.print("  "); // Print two spaces
            }

            // Inner loop for the stars in the first half of the pattern
            // The number of stars decreases with each row.
            for (int k = i; k <= n; k++) {
                System.out.print("* ");
            }

            // Inner loop for the stars in the second half of the pattern
            // The number of stars also decreases with each row.
            for (int l = i; l < n; l++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to the next line
        }
    }
}