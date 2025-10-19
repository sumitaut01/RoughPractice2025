package basics.javapgms;

public class LastNonRepeatingCharArray {
    public static void main(String[] args) {
        String str = "swiss";
        int[] count = new int[256]; // ASCII

        for (char c : str.toCharArray()) {
            count[c]++;
        }

        char result = '_';
        for (int i = str.length() - 1; i >= 0; i--) {
            if (count[str.charAt(i)] == 1) {
                result = str.charAt(i);
                break;
            }
        }

        System.out.println("Last non-repeating character: " + result);
    }
}
