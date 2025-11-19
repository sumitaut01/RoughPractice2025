package basics.characters;

public class Rough {

    public static void main(String[] args) {



        char ch=65;
        System.out.println(ch);//A

        ch++;
        System.out.println(ch);//B

        int c=(int)ch+1;

        System.out.println(c);//67

        System.out.println((char)c);//C


        System.out.println(Character.isLetterOrDigit(ch));//true
        char chx='1';
        System.out.println(Character.isAlphabetic(chx));//false

        System.out.println(Character.isWhitespace(' '));//true




    }
}
