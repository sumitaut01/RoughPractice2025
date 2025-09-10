package basics.characters;

public class CharacterDemo {

    public static void main(String[] args) {
        Character
         ch='A';
        System.out.println(ch);//A

        int aa=ch;
        System.out.println(aa);//65

        ch++;
        System.out.println(ch);//B

        System.out.println(Character.isAlphabetic('a'));//ture
        System.out.println(Character.isAlphabetic('^'));//false
        System.out.println(Character.isAlphabetic('9'));//false


        System.out.println(Character.isDigit('a'));//false
        System.out.println(Character.isDigit('9'));//true

        System.out.println(Character.isLowerCase('a'));//true
        System.out.println(Character.isUpperCase('U'));//true

        System.out.println(Character.compare('a', 'b'));//-1
        System.out.println(Character.compare('a', 'a'));//0
        System.out.println(Character.compare('b', 'a'));//1


        System.out.println(Character.isWhitespace(' '));//true

        System.out.println(Character.isLetterOrDigit('^'));//fa;se
        System.out.println(Character.isLetterOrDigit('c'));//true
        System.out.println(Character.isLetterOrDigit('8'));//true

        char c='c';
        //Character ch=new Character(c);







    }
}
