package basics.characters;

import org.testng.annotations.Test;

public class Rough {

    public static void main(String[] args) {
        char ch = 65;
        System.out.println(ch);//A

        ch++;
        System.out.println(ch);//B

        int c = (int) ch + 1;

        System.out.println(c);//67

        System.out.println((char) c);//C


        System.out.println(Character.isLetterOrDigit(ch));//true
        char chx = '1';
        System.out.println(Character.isAlphabetic(chx));//false

        System.out.println(Character.isWhitespace(' '));//true


        char cx = 'A';
        System.out.println(cx);//A

        cx++;
        System.out.println(cx);//B


    }


    @Test
    public void Rough1() {

        char c = 'a';
        System.out.println(c);//a
        c++;
        System.out.println(c);//b
        System.out.println((int) c);//98
        System.out.println(Character.isDigit('a'));//false
        System.out.println(Character.isAlphabetic('c'));//true
        System.out.println(Character.isDigit('a'));//false
        System.out.println(Character.isUpperCase('a'));//false
        System.out.println(Character.isLowerCase('a'));//true
        System.out.println(Character.isDigit(9));//false



        char hindi = 'क';
        System.out.println(hindi);
        hindi++;
        System.out.println(hindi);

//क
//ख

    }
}
