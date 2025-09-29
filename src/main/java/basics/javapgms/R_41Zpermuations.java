package basics.javapgms;



/*
Generating all permutations for string: abc
abc
acb
bac
bca
cab
cba
 */
public class R_41Zpermuations {

    // Function to generate permutations
    static void permute(String str, String ans) {
        // Base case: if string is empty
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            // Pick one character
            char ch = str.charAt(i);
            //System.out.println(ch);

            // Remaining string after removing picked char
            String remaining = str.substring(0, i) + str.substring(i + 1);
           // System.out.println(remaining);

            // Recurse
            //System.out.println("executing "+i);
            permute(remaining, ans + ch);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        permute(s, "");
    }
}
