package basics.javapgms;

public class VowelConsonantCounter {

    public static void main(String[] args) {
        String input = "Hello World";
        int vowels = 0;
        int consonants = 0;
        input = input.toLowerCase(); // Convert to lowercase for easier comparison

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // Check if the character is an alphabet
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}