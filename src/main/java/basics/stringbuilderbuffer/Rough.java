package basics.stringbuilderbuffer;

import org.testng.annotations.Test;

public class Rough {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("s");
        sb.insert(0, "x");
        System.out.println(sb);//xs
        System.out.println(sb.delete(0, 1));//s
        System.out.println(sb.delete(0, 1)); //blank

    }


    @Test
    public void CreditCardProb() {

        String num = "1234567812345678";

        StringBuilder res = new StringBuilder();

        //0 15
        //o/p   ****_****_****_5678
        for (int i = 0; i < num.length(); i++) {

            if (i > 11) {
                res.append(num.charAt(i));
            } else {
                res.append("*");
            }
            if (i < 12 && (i + 1) % 4 == 0) {
                res.append("_");
            }
        }

        System.out.println(res);
    }


    @Test
    public void CreditCardProb_GPT() {


        String num = "1234567812345678";
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {

            if (i >= num.length() - 4) {
                res.append(num.charAt(i));
            } else {
                res.append("*");
            }

            if (i < num.length() - 4 && (i + 1) % 4 == 0) {
                res.append("_");
            }
        }

        System.out.println(res);
    }
}
