package basics.javapgms;

public class RX_VovelsConsonants {

    public static void main(String[] args) {


        String str="this is it";

        String vowel="aeiou";

        int ivowel=0;
        int iConso=0;
        for(char c:str.toCharArray()){
            char current=Character.toLowerCase(c);
            if(current>='a' && current<='z'){

                if(vowel.indexOf(current)!=-1){
                    System.out.println(current);
                    ivowel++;

                }
                else{
                    System.out.println(current );
                    iConso++;
                }
            }


        }

        System.out.println(ivowel);//3
        System.out.println(iConso);//5
    }
}
