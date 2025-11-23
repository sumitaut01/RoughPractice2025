package basics.characters;

import org.testng.annotations.Test;

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

    @Test
    public void Rough(){
        String name="sumit raut";
        int [] aChar=new int[256];
        for( char c: name.toCharArray()){
         aChar[(int)c]++;
        }

        for(int i=0;i<aChar.length;i++){
            if(aChar[i]!=0){
                System.out.println(i +" "+ (char)i +" "+aChar[i]);
            }
        }
    }


    @Test
    public void R2(){

        String name="sumit raut";
       int [] all=new int[256];

       for(int i=0;i<name.length();i++){
           all[ (int)name.charAt(i)]++;
        }


       for(int i=0;i<all.length;i++){

           if(all[i]!=0){
               System.out.println( i +" "+ (char)i +" "+all[i]);
           }
        }


//32   1
//97 a 1
//105 i 1
//109 m 1
//114 r 1
//115 s 1
//116 t 2
//117 u 2





    }
}
