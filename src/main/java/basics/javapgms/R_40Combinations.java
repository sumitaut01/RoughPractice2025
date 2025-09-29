package basics.javapgms;


/*

abc
ab
ac
a
bc
b
c

 */
public class R_40Combinations {

        public static void main(String[] args) {
            String s = "abc";
            subsequence(s, "");
        }


        static void subsequence(String str, String ans) {
            if (str.length() == 0) {
                System.out.println(ans);
                return;
            }

            char ch = str.charAt(0);
            String remaining = str.substring(1);

            // 1. Include current character
            subsequence(remaining, ans + ch);

            // 2. Exclude current character
            subsequence(remaining, ans);
        }


    }


